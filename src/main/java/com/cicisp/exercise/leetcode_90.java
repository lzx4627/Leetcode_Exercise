package com.cicisp.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class leetcode_90 {
    List<Integer> f = new ArrayList<Integer>();
    List<List<Integer>> res = new ArrayList<List<Integer>>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        dfs(false, nums, 0);
        return res;
    }

    public void dfs(boolean chooseFlag, int[] nums, int start){
        if (start == nums.length) {
            res.add(new ArrayList<Integer>(f));
            return;
        }
        dfs(false, nums, start + 1);
        if (!chooseFlag && start > 0 && nums[start - 1] == nums[start]) {
            return;
        }
        f.add(nums[start]);
        dfs(true, nums, start + 1);
        f.remove(f.size() - 1);
    }
}
