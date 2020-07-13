package com.cicisp.exercise;

import java.util.Arrays;
/**
 * 给定两个数组，编写一个函数来计算它们的交集。

示例 1:

输入: nums1 = [1,2,2,1], nums2 = [2,2]
输出: [2,2]
示例 2:

输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出: [4,9]
说明：

输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
我们可以不考虑输出结果的顺序。
 */
public class leetcode_350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        // 哈希表
        // if (nums1.length > nums2.length) {
        //     return intersect(nums2, nums1);
        // }
        // Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        // for (int num : nums1) {
        //     int count = map.getOrDefault(num, 0) + 1;
        //     map.put(num, count);
        // }
        // int[] intersection = new int[nums1.length];
        // int index = 0;
        // for (int num : nums2) {
        //     int count = map.getOrDefault(num, 0);
        //     if (count > 0) {
        //         intersection[index++] = num;
        //         count--;
        //         if (count > 0) {
        //             map.put(num, count);
        //         } else {
        //             map.remove(num);
        //         }
        //     }
        // }
        // return Arrays.copyOfRange(intersection, 0, index);
        // 排序
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int length1 = nums1.length, length2 = nums2.length;
        int[] intersection = new int[Math.min(length1, length2)];
        int index1 = 0, index2 = 0, index = 0;
        while (index1 < length1 && index2 < length2) {
            if (nums1[index1] < nums2[index2]) {
                index1++;
            } else if (nums1[index1] > nums2[index2]) {
                index2++;
            } else {
                intersection[index] = nums1[index1];
                index1++;
                index2++;
                index++;
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }
}