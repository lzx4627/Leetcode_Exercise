package com.cicisp.exercise;

/**
 * 给定一个二叉树，我们在树的节点上安装摄像头。

节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。

计算监控树的所有节点所需的最小摄像头数量。

示例 1：

输入：[0,0,null,0,0]
输出：1
解释：如图所示，一台摄像头足以监控所有节点。
示例 2：

输入：[0,0,null,0,null,0,null,null,0]
输出：2
解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class leetcode_968 {
    public int minCameraCover(TreeNode root) {
        return findMinCam(root)[1];
    }
    public int[] findMinCam(TreeNode root){
        if(root!=null){
            int[] left=findMinCam(root.left);
            int[] right=findMinCam(root.right);
            int ans[]=new int[3];           
            //0必须放置摄像头的情况下，覆盖整棵树需要的摄像头数目。
            //1覆盖整棵树需要的摄像头数目，无论root是否放置摄像头
            //2覆盖两棵子树需要的摄像头数目，无论节点 root本身是否被监控到
            ans[0]=left[2]+right[2]+1;
            ans[1]=Math.min(ans[0],Math.min(left[0]+right[1],right[0]+left[1]));
            ans[2]=Math.min(ans[0],left[1]+right[1]);
            return ans;
        }
        return new int[]{1073741824,0,0};    
    }
}