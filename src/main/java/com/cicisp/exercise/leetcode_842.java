package com.cicisp.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个数字字符串 S，比如 S = "123456579"，我们可以将它分成斐波那契式的序列 [123, 456, 579]。

形式上，斐波那契式序列是一个非负整数列表 F，且满足：

0 <= F[i] <= 2^31 - 1，（也就是说，每个整数都符合 32 位有符号整数类型）；
F.length >= 3；
对于所有的0 <= i < F.length - 2，都有 F[i] + F[i+1] = F[i+2] 成立。
另外，请注意，将字符串拆分成小块时，每个块的数字一定不要以零开头，除非这个块是数字 0 本身。

返回从 S 拆分出来的任意一组斐波那契式的序列块，如果不能拆分则返回 []。

示例 1：

输入："123456579"
输出：[123,456,579]
示例 2：

输入: "11235813"
输出: [1,1,2,3,5,8,13]
示例 3：

输入: "112358130"
输出: []
解释: 这项任务无法完成。
示例 4：

输入："0123"
输出：[]
解释：每个块的数字不能以零开头，因此 "01"，"2"，"3" 不是有效答案。
示例 5：

输入: "1101111"
输出: [110, 1, 111]
解释: 输出 [11,0,11,11] 也同样被接受。
 

提示：

1 <= S.length <= 200
字符串 S 中只含有数字。
 */
public class leetcode_842 {
    int len;
    public List<Integer> splitIntoFibonacci(String S) {
        len = S.length();
        List<Integer> res = new ArrayList<>();
        return dfs(0, S, res) ? res : new ArrayList<>();
    }

    private boolean dfs(int p, String S, List<Integer> res) {
        int size = res.size();
        if (p == len) {
            return size > 2;
        }
        int num = 0;
        for (int i = p; i < len; i ++) {
            num = 10 * num + S.charAt(i) - '0';
            //判断是否溢出
            if (num < 0) {
                return false;
            }
            if (size < 2 || num == res.get(size -1) + res.get(size -2)) {
                res.add(num);
                if (dfs(i + 1, S, res)) {
                    return true;
                }
                res.remove(size);
            }
            //判断是否以0开头，阻止循环到下一位
            if (S.charAt(i) - '0' == 0 && i == p) {
                return false;
            }
        }
        return false;
    }
}
