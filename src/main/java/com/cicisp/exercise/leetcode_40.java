package com.cicisp.exercise;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。

candidates 中的每个数字在每个组合中只能使用一次。

说明：

所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。 
示例 1:

输入: candidates = [10,1,2,7,6,1,5], target = 8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]
示例 2:

输入: candidates = [2,5,2,1,2], target = 5,
所求解集为:
[
  [1,2,2],
  [5]
]
 */
public class leetcode_40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if(len == 0){
            return res;
        }
        
        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>(len);
        dfs(candidates, len, 0, target, path, res);
        return res;
    }
    public void dfs(int[] candidates, int len, int begin, int target, Deque<Integer> path, List<List<Integer>> res){
        if(target == 0){
            res.add(new ArrayList<>(path));
        }
        for(int i=begin;i<len;i++){
            if(target - candidates[i] < 0){
                break;
            }
            if(i>begin && candidates[i] == candidates[i-1]){
                continue;
            }
            path.addLast(candidates[i]);
            dfs(candidates, len, i + 1, target - candidates[i], path, res);
            path.removeLast();
        }
    }
}
