package com.cicisp.exercise;

/**
 * 171. Excel表列序号
 * 给定一个Excel表格中的列名称，返回其相应的列序号。

例如，

    A -> 1
    B -> 2
    C -> 3
    ...
    Z -> 26
    AA -> 27
    AB -> 28 
    ...
示例 1:

输入: "A"
输出: 1
示例 2:

输入: "AB"
输出: 28
示例 3:

输入: "ZY"
输出: 701
 */
public class leetcode_171 {
    public int titleToNumber(String columnTitle) {
        int len = columnTitle.length();
        int sum = 0;
        int layer = 1;
        for (int i = len - 1; i >= 0; i --){
            int k = columnTitle.charAt(i) - 'A' + 1;
            sum += k * layer;
            layer *= 26;
        }
        return sum;
    }
}
