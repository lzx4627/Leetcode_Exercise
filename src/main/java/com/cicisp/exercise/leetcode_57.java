package com.cicisp.exercise;

import java.util.ArrayList;

/**
 * 出一个无重叠的 ，按照区间起始端点排序的区间列表。

在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。

示例 1：

输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
输出：[[1,5],[6,9]]
示例 2：

输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
输出：[[1,2],[3,10],[12,16]]
解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10] 重叠。
 */
public class leetcode_57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> reslut = new ArrayList<>();
        if (intervals == null || intervals.length <= 0) {
            reslut.add(newInterval);
            return reslut.toArray(new int[0][]);
        }

        int startIndex = -1;
        int endIndex = -1;
        boolean startOverlap = false;
        boolean endOverlap = false;

        /*
            寻找newInterval 的 左边界位置：
                加入到intervals中的左边界位置 是指 newInterval[0] 比 intervals某个区间的有边界大
         */
        for (int i = 0; i < intervals.length; i++) {
            if (newInterval[0] <= intervals[i][1]) {
                startIndex = i;
                startOverlap = newInterval[0] >= intervals[startIndex][0];
                break;
            }
            reslut.add(intervals[i]);
        }

        /*
            寻找newInterval 的 右边界位置：
                加入到intervals中的右边界位置 是指 newInterval[1] 比 intervals某个区间的有边界小
         */
        ArrayList<int[]> right = new ArrayList<>();
        for (int i = intervals.length - 1; i >= 0; i--) {
            if (newInterval[1] >= intervals[i][0]) {
                endIndex = i;
                endOverlap = newInterval[1] <= intervals[i][1];
                break;
            }
            right.add(0, intervals[i]); // 由于是“倒序遍历”，因此 每次将 当前合适节点 插入 当前结果数组的最前面，以保证顺序
        }

        if (startIndex == -1 || endIndex == -1) { // newInterval区间 与 intervals的任意一区间 都不相交
            reslut.add(newInterval);
            reslut.addAll(right);
            return reslut.toArray(new int[0][]);
        }

        int curLeft = 0;
        int curRight = 0;
        if (startOverlap) { // newInterval区间 被 intervals的某一区间的左边界 插入
            curLeft = intervals[startIndex][0];
        } else {
            curLeft = newInterval[0];
        }
        if (endOverlap) { // newInterval区间 被 intervals的某一区间的右边界 插入
            curRight = intervals[endIndex][1];
        } else {
            curRight = newInterval[1];
        }
        reslut.add(new int[] {curLeft, curRight});
        reslut.addAll(right);
        return reslut.toArray(new int[0][]);
    }
}
