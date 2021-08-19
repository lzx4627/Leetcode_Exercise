package com.cicisp.exercise;

/**
 * 345. 反转字符串中的元音字母
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。

示例 1：

输入："hello"
输出："holle"
示例 2：

输入："leetcode"
输出："leotcede"
 
提示：

元音字母不包含字母 "y" 。
 */
public class leetcode_345 {
    public String reverseVowels(String s) {
        int lens = s.length();
        char[] data = s.toCharArray();
        int i = 0, j = lens - 1;
        while(i < j){
            while(i < lens && !isVolum(data[i])){
                ++ i;
            }
            while(j > 0 && !isVolum(data[j])){
                -- j;
            }
            if (i < j){
                change(data, i, j);
                ++ i;
                -- j;
            }
        }
        return new String(data);
    }


    public boolean isVolum(char s){
        return "aeiouAEIOU".indexOf(s) >= 0;
    }

    public void change(char[] d, int i, int j){
        char temp = d[i];
        d[i] = d[j];
        d[j] = temp;
    }
}
