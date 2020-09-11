package com.cicisp.exercise;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。

说明：

所有数字都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: k = 3, n = 7
输出: [[1,2,4]]
示例 2:

输入: k = 3, n = 9
输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class leetcode_216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> path = new ArrayDeque<>();
        dfs(k,n,1,path,res);
        return res;
    }
    public void dfs(int k, int n, int start, Deque<Integer> path, List<List<Integer>> res){
        if(n == 0 && k == 0){
            res.add(new ArrayList<>(path));
            return ;
        }
        for(int i = start;i < 10 ; ++i){
            if(n-i<0 || k<=0){
                break;
            }
            path.addLast(i);
            dfs(k-1,n-i,i+1,path,res);
            path.removeLast();
        }
    }
}
