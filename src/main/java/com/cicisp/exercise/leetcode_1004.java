package com.cicisp.exercise;

/**
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。

返回仅包含 1 的最长（连续）子数组的长度。

示例 1：

输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
输出：6
解释： 
[1,1,1,0,0,1,1,1,1,1,1]
粗体数字从 0 翻转到 1，最长的子数组长度为 6。
示例 2：

输入：A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3
输出：10
解释：
[0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
粗体数字从 0 翻转到 1，最长的子数组长度为 10。
 
提示：

1 <= A.length <= 20000
0 <= K <= A.length
A[i] 为 0 或 1 
 */
public class leetcode_1004 {
    public int longestOnes(int[] A, int K) {
        int lena = A.length;
        int l = 0, r = 0;
        int zeroCount = 0, res = 0;
        // 左指针
        while (l < lena){
            if (A[l] == 0){
                zeroCount ++;
            }
            l ++;
            // 当0数量大于K, 右指针向右移
            while (zeroCount > K){
                if (A[r] == 0){
                    zeroCount --;
                }
                r ++;
            }
            res = Math.max(res, l - r);
        }
        return res;
    }
}
