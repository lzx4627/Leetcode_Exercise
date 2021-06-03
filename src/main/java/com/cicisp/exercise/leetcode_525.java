package com.cicisp.exercise;

import java.util.HashMap;
import java.util.Map;

/**
 * 525. 连续数组
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。

示例 1:

输入: nums = [0,1]
输出: 2
说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
示例 2:

输入: nums = [0,1,0]
输出: 2
说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
 
提示：

1 <= nums.length <= 105
nums[i] 不是 0 就是 1
 */
public class leetcode_525 {
    public int findMaxLength(int[] nums) {
        int max = 0, n = nums.length;
        int[] ans = new int[n + 1];
        Map<Integer, Integer> res = new HashMap<Integer, Integer>();
        for (int i = 1; i <= n; i ++){
            ans[i] = ans[i - 1] + (nums[i - 1] == 1 ? 1 : -1);
        }
        res.put(0,0);
        for (int i = 2; i <= n; i ++){
            if (!res.containsKey(ans[i-2])){
                res.put(ans[i - 2], i - 2);
            }
            if (res.containsKey(ans[i])){
                max = Math.max(max, i - res.get(ans[i]));
            }
        }
        return max;
    }
}
