package com.cicisp.exercise;

/**
 * 给定两个字符串 s 和 t，它们只包含小写字母。

字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。

请找出在 t 中被添加的字母。

示例 1：

输入：s = "abcd", t = "abcde"
输出："e"
解释：'e' 是那个被添加的字母。
示例 2：

输入：s = "", t = "y"
输出："y"
示例 3：

输入：s = "a", t = "aa"
输出："a"
示例 4：

输入：s = "ae", t = "aea"
输出："a"
 
提示：

0 <= s.length <= 1000
t.length == s.length + 1
s 和 t 只包含小写字母
 */
public class leetcode_389 {
    public char findTheDifference(String s, String t) {
        // 计数
        // int[] cnt = new int[26];
        // for (int i = 0; i < s.length(); i ++){
        //     char cs = s.charAt(i);
        //     cnt[cs - 'a'] ++;
        // }
        // for (int j = 0; j < t.length(); j ++){
        //     char ct = t.charAt(j);
        //     cnt[ct - 'a'] --;
        //     if (cnt[ct - 'a'] < 0){
        //         return ct;
        //     }
        // }
        // return ' ';
        // 求和
        // int as = 0, at = 0;
        // for (int i = 0; i <s.length(); ++i){
        //     as += s.charAt(i);
        // }
        // for (int j = 0; j < t.length(); ++j){
        //     at += t.charAt(j);
        // }
        // return (char) (at - as);
        // 位运算
        int ret = 0;
        for (int i = 0; i < s.length(); i ++){
            ret ^= s.charAt(i);
        }
        for (int j = 0; j < t.length(); j ++){
            ret ^= t.charAt(j);
        }
        return (char)ret;
    }   
}
