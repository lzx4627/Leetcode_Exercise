package com.cicisp.exercise;

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。

示例 1：

输入：n = 3
输出：[[1,2,3],[8,9,4],[7,6,5]]
示例 2：

输入：n = 1
输出：[[1]]
 
提示：

1 <= n <= 20
 */
public class leetcode_59 {
    public int[][] generateMatrix(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] res = new int[n][n];
        int x = 1, max = n * n;
        while(x <= max){
            for (int i = l; i <= r; i ++){
                res[t][i] = x ++;
            }
            t ++;
            for (int i = t; i <= b; i ++){
                res[i][r] = x ++;
            }
            r --;
            for (int i = r; i >= l; i --){
                res[b][i] = x ++;
            }
            b --;
            for (int i = b; i >= t; i --){
                res[i][l] = x ++;
            }
            l ++;
        }
        return res;
    }
}
