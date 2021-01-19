package com.cicisp.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。

连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 val 的绝对值。

请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。

示例 1：

输入：points = [[0,0],[2,2],[3,10],[5,2],[7,0]]
输出：20
解释：

我们可以按照上图所示连接所有点得到最小总费用，总费用为 20 。
注意到任意两个点之间只有唯一一条路径互相到达。
示例 2：

输入：points = [[3,12],[-2,5],[-4,1]]
输出：18
示例 3：

输入：points = [[0,0],[1,1],[1,0],[-1,1]]
输出：4
示例 4：

输入：points = [[-1000000,-1000000],[1000000,1000000]]
输出：4000000
示例 5：

输入：points = [[0,0]]
输出：0
 
提示：

1 <= points.length <= 1000
-106 <= xi, yi <= 106
所有点 (xi, yi) 两两不同。
 */
public class leetcode_1584 {
    List<Edge> edges = new ArrayList<Edge>();
    Pos[] pos;

    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        solve(points, n);

        DisjointSetUnion dsu = new DisjointSetUnion(n);
        Collections.sort(edges, new Comparator<Edge>() {
            public int compare(Edge edge1, Edge edge2) {
                return edge1.len - edge2.len;
            }
        });
        int ret = 0, num = 1;
        for (Edge edge : edges) {
            int len = edge.len, x = edge.x, y = edge.y;
            if (dsu.unionSet(x, y)) {
                ret += len;
                num++;
                if (num == n) {
                    break;
                }
            }
        }
        return ret;
    }

    public void solve(int[][] points, int n) {
        pos = new Pos[n];
        for (int i = 0; i < n; i++) {
            pos[i] = new Pos(i, points[i][0], points[i][1]);
        }
        build(n);
        for (int i = 0; i < n; i++) {
            int temp = pos[i].x;
            pos[i].x = pos[i].y;
            pos[i].y = temp;
        }
        build(n);
        for (int i = 0; i < n; i++) {
            pos[i].x = -pos[i].x;
        }
        build(n);
        for (int i = 0; i < n; i++) {
            int temp = pos[i].x;
            pos[i].x = pos[i].y;
            pos[i].y = temp;
        }
        build(n);
    }

    public void build(int n) {
        Arrays.sort(pos, new Comparator<Pos>() {
            public int compare(Pos pos1, Pos pos2) {
                return pos1.x == pos2.x ? pos1.y - pos2.y : pos1.x - pos2.x;
            }
        });
        int[] a = new int[n];
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            a[i] = pos[i].y - pos[i].x;
            set.add(pos[i].y - pos[i].x);
        }
        int num = set.size();
        int[] b = new int[num];
        int index = 0;
        for (int element : set) {
            b[index++] = element;
        }
        Arrays.sort(b);
        BIT bit = new BIT(num + 1);
        for (int i = n - 1; i >= 0; i--) {
            int poss = binarySearch(b, a[i]) + 1;
            int j = bit.query(poss);
            if (j != -1) {
                int dis = Math.abs(pos[i].x - pos[j].x) + Math.abs(pos[i].y - pos[j].y);
                edges.add(new Edge(dis, pos[i].id, pos[j].id));
            }
            bit.update(poss, pos[i].x + pos[i].y, i);
        }
    }

    public int binarySearch(int[] array, int target) {
        int low = 0, high = array.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            int num = array[mid];
            if (num < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}

class DisjointSetUnion {
    int[] f;
    int[] rank;
    int n;

    public DisjointSetUnion(int n) {
        this.n = n;
        this.rank = new int[n];
        Arrays.fill(this.rank, 1);
        this.f = new int[n];
        for (int i = 0; i < n; i++) {
            this.f[i] = i;
        }
    }

    public int find(int x) {
        return f[x] == x ? x : (f[x] = find(f[x]));
    }

    public boolean unionSet(int x, int y) {
        int fx = find(x), fy = find(y);
        if (fx == fy) {
            return false;
        }
        if (rank[fx] < rank[fy]) {
            int temp = fx;
            fx = fy;
            fy = temp;
        }
        rank[fx] += rank[fy];
        f[fy] = fx;
        return true;
    }
}

class BIT {
    int[] tree;
    int[] idRec;
    int n;

    public BIT(int n) {
        this.n = n;
        this.tree = new int[n];
        Arrays.fill(this.tree, Integer.MAX_VALUE);
        this.idRec = new int[n];
        Arrays.fill(this.idRec, -1);
    }

    public int lowbit(int k) {
        return k & (-k);
    }

    public void update(int pos, int val, int id) {
        while (pos > 0) {
            if (tree[pos] > val) {
                tree[pos] = val;
                idRec[pos] = id;
            }
            pos -= lowbit(pos);
        }
    }

    public int query(int pos) {
        int minval = Integer.MAX_VALUE;
        int j = -1;
        while (pos < n) {
            if (minval > tree[pos]) {
                minval = tree[pos];
                j = idRec[pos];
            }
            pos += lowbit(pos);
        }
        return j;
    }
}

class Edge {
    int len, x, y;

    public Edge(int len, int x, int y) {
        this.len = len;
        this.x = x;
        this.y = y;
    }
}

class Pos {
    int id, x, y;

    public Pos(int id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }
}