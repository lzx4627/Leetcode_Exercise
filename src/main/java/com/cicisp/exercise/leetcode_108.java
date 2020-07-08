package com.cicisp.exercise;

public class leetcode_108 {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    
    public static TreeNode sortedArrayToBST(int[] nums) {
        return sort(nums, 0, nums.length - 1);
    }

    public static TreeNode sort(int[] nums,int left,int right){
        if (left > right){
            return null;
        }
        //向上取中位数
        int mid = left + (right - left + 1)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left=sort(nums,left,mid-1);
        root.right=sort(nums,mid+1,right);
        return root;
    }
    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        sortedArrayToBST(nums);
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}