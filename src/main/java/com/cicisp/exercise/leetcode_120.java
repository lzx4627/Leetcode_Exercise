package com.cicisp.exercise;

import java.util.List;

/**
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。

相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。

 

例如，给定三角形：

[
     [2],
    [3,4],
   [6,5,7],
  [4,1,8,3]
]
自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 */
public class leetcode_120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        // 动态规划
        // int n = triangle.size();
        // int[][] f = new int[n][n];
        // f[0][0] = triangle.get(0).get(0);
        // for (int i = 1; i < n; ++i) {
        //     f[i][0] = f[i - 1][0] + triangle.get(i).get(0);
        //     for (int j = 1; j < i; ++j) {
        //         f[i][j] = Math.min(f[i - 1][j - 1], f[i - 1][j]) + triangle.get(i).get(j);
        //     }
        //     f[i][i] = f[i - 1][i - 1] + triangle.get(i).get(i);
        // }
        // int minTotal = f[n - 1][0];
        // for (int i = 1; i < n; ++i) {
        //     minTotal = Math.min(minTotal, f[n - 1][i]);
        // }
        // return minTotal;
        // 动态规划+空间优化
        // int n = triangle.size();
        // int[][] f = new int[2][n];
        // f[0][0] = triangle.get(0).get(0);
        // for (int i = 1; i < n; ++i) {
        //     int curr = i % 2;
        //     int prev = 1 - curr;
        //     f[curr][0] = f[prev][0] + triangle.get(i).get(0);
        //     for (int j = 1; j < i; ++j) {
        //         f[curr][j] = Math.min(f[prev][j - 1], f[prev][j]) + triangle.get(i).get(j);
        //     }
        //     f[curr][i] = f[prev][i - 1] + triangle.get(i).get(i);
        // }
        // int minTotal = f[(n - 1) % 2][0];
        // for (int i = 1; i < n; ++i) {
        //     minTotal = Math.min(minTotal, f[(n - 1) % 2][i]);
        // }
        // return minTotal;
        int n = triangle.size();
        int[] f = new int[n];
        f[0] = triangle.get(0).get(0);
        for (int i = 1; i < n; ++i) {
            f[i] = f[i - 1] + triangle.get(i).get(i);
            for (int j = i - 1; j > 0; --j) {
                f[j] = Math.min(f[j - 1], f[j]) + triangle.get(i).get(j);
            }
            f[0] += triangle.get(i).get(0);
        }
        int minTotal = f[0];
        for (int i = 1; i < n; ++i) {
            minTotal = Math.min(minTotal, f[i]);
        }
        return minTotal;
    }
}