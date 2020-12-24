package com.cicisp.exercise;

/**
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。

示例：

s = "leetcode"
返回 0

s = "loveleetcode"
返回 2
 
提示：你可以假定该字符串只包含小写字母。
 */
public class leetcode_387 {
    public int firstUniqChar(String s) {
        int[] res = new int[26];
        int lens = s.length();
        for (int i = 0; i < lens; i ++){
            res[s.charAt(i) - 'a'] ++;
        }
        for (int j = 0; j < lens; j ++){
            if (res[s.charAt(j) - 'a'] == 1 ){
                return j;
            }
        }
        return -1;
    }
}
