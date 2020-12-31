package com.cicisp.exercise;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 给定一个区间的集合，找到需要移除区间的最小数量，使剩余区间互不重叠。

注意:

可以认为区间的终点总是大于它的起点。
区间 [1,2] 和 [2,3] 的边界相互“接触”，但没有相互重叠。
示例 1:

输入: [ [1,2], [2,3], [3,4], [1,3] ]

输出: 1

解释: 移除 [1,3] 后，剩下的区间没有重叠。
示例 2:

输入: [ [1,2], [1,2], [1,2] ]

输出: 2

解释: 你需要移除两个 [1,2] 来使剩下的区间没有重叠。
示例 3:

输入: [ [1,2], [2,3] ]

输出: 0

解释: 你不需要移除任何区间，因为它们已经是无重叠的了。
 */
public class leetcode_435 {
    public int eraseOverlapIntervals(int[][] intervals) {
        // 是否为空
        if (intervals.length == 0){
            return 0;
        }
        // 排序
        Arrays.sort(intervals, new Comparator<int[]>(){
            public int compare(int[] intervals1, int[] intervals2){
               return intervals1[1] - intervals2[1]; 
            }
        });

        int leni = intervals.length;
        // 保留的个数
        int ans = 1;
        // 初始右边界
        int right = intervals[0][1];
        for (int i = 1; i < leni; i ++){
            // 当新区间的左边界大于初始右边界时
            if (intervals[i][0] >= right){
                ans ++;
                // 更新右边界
                right = intervals[i][1];
            }
        }
        // 返回删除的区间个数
        return leni - ans;
    }
}
