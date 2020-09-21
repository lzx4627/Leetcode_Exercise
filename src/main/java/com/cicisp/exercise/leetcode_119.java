package com.cicisp.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个非负索引 k，其中 k ≤ 33，返回杨辉三角的第 k 行。

在杨辉三角中，每个数是它左上方和右上方的数的和。

示例:

输入: 3
输出: [1,3,3,1]
 */
public class leetcode_119 {
    public List<Integer> getRow(int rowIndex) {
        rowIndex ++;
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i<rowIndex;i++){
            if(i == 0){
                res.add(1);
            }else{
                long num = (long) res.get(i - 1) * (long) (rowIndex - i) / i;
                res.add((int) num);
            }
            
        }
        return res;
    }
}
