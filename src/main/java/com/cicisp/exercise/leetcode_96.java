package com.cicisp.exercise;

/**
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？

示例:

输入: 3
输出: 5
解释:
给定 n = 3, 一共有 5 种不同结构的二叉搜索树:

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 */
public class leetcode_96 {
    public int numTrees(int n) {
        // 动态规划
        // int[] G = new int[n + 1];
        // G[0] = 1;
        // G[1] = 1;

        // for (int i = 2; i <= n; ++i) {
        //     for (int j = 1; j <= i; ++j) {
        //         G[i] += G[j - 1] * G[i - j];
        //     }
        // }
        // return G[n];
        // 提示：我们在这里需要用 long 类型防止计算过程中的溢出
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }
}