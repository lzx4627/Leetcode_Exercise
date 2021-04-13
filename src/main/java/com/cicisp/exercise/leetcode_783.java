package com.cicisp.exercise;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

/**
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。

注意：本题与 530：https://leetcode-cn.com/problems/minimum-absolute-difference-in-bst/ 相同

示例 1：

输入：root = [4,2,6,1,3]
输出：1
示例 2：

输入：root = [1,0,48,null,null,12,49]
输出：1
 
提示：

树中节点数目在范围 [2, 100] 内
0 <= Node.val <= 105
 */

public class leetcode_783 {
    int ans;
    int pre;
    public int minDiffInBST(TreeNode root) {
        ans = Integer.MAX_VALUE;
        pre = -1;
        dfs(root);
        return ans;
    }

    public void dfs(TreeNode root){
        if (root == null){
            return ;
        }
        dfs(root.left);
        if (pre == -1){
            pre = root.val;
        }else{
            ans = Math.min(ans, root.val - pre);
            pre = root.val;
        }
        dfs(root.right);
    }
}
