package com.cicisp.exercise;

/**
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。

示例：

输入：[1,12,-5,-6,50,3], k = 4
输出：12.75
解释：最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 
提示：

1 <= k <= n <= 30,000。
所给数据范围 [-10,000，10,000]。
 */
public class leetcode_643 {
    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        int lenn = nums.length;
        // 获取第一个划窗
        for (int i = 0; i < k; i ++){
            sum += nums[i];
        }
        // 初始化最大值
        int maxSum = sum;
        for (int i = k; i < lenn; i ++){
            // 更新划窗总值
            sum = sum - nums[i-k] + nums[i];
            // 保留最大值
            maxSum = Math.max(sum, maxSum);
        }
        return (double)maxSum/k;
    }
}
