package com.cicisp.exercise;

/**
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。

如果数组中不存在目标值 target，返回 [-1, -1]。

进阶：

你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？

示例 1：

输入：nums = [5,7,7,8,8,10], target = 8
输出：[3,4]
示例 2：

输入：nums = [5,7,7,8,8,10], target = 6
输出：[-1,-1]
示例 3：

输入：nums = [], target = 0
输出：[-1,-1]

提示：

0 <= nums.length <= 105
-109 <= nums[i] <= 109
nums 是一个非递减数组
-109 <= target <= 109
 */
public class leetcode_34 {
    public int[] searchRange(int[] nums, int target) {
        int lens = nums.length;
        if (lens == 0){
            return new int[]{-1, -1};
        }
        int left = findFirstPosition(nums, target);
        if (left == -1){
            return new int[]{-1, -1};
        }
        int right = findLastPosition(nums, target);
        return new int[]{left, right};
    }

    private int findFirstPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int mid = left + (right - left) / 2;
            if (nums[mid] < target){
                left = mid + 1;
            }else if (nums[mid] == target){
                right = mid ;
            }else{
                right = mid - 1;
            }
        }
        if (nums[left] == target){
            return left;
        }
        return -1;
    }

    private int findLastPosition(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int mid = left + (right - left + 1) / 2;
            if (nums[mid] < target){
                left = mid + 1 ;
            }
            else if (nums[mid] == target){
                left = mid;
            }
            else {
                right = mid - 1;
            }
        }
        return left;
    }
}
