package com.cicisp.exercise;

/**
 * 给定一个有相同值的二叉搜索树（BST），找出 BST 中的所有众数（出现频率最高的元素）。

假定 BST 有如下定义：

结点左子树中所含结点的值小于等于当前结点的值
结点右子树中所含结点的值大于等于当前结点的值
左子树和右子树都是二叉搜索树
例如：
给定 BST [1,null,2,2],

   1
    \
     2
    /
   2
返回[2].

提示：如果众数超过1个，不需考虑输出顺序

进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内）
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
public class leetcode_501 {
    private TreeNode pre = null;
    private int[] ret;
    private int retCount = 0;
    private int maxCount = 0;
    private int currCount = 0;

    public int[] findMode(TreeNode root) {
        inOrder(root);
        pre = null;
        ret = new int[retCount];
        retCount = 0;
        currCount = 0;
        inOrder(root);
        return ret;
    }

    private void inOrder(TreeNode root) {
        if (root == null)
            return;
        inOrder(root.left);
        if (pre != null && pre.val == root.val)
            currCount++;
        else
            currCount = 1;
        if (currCount > maxCount) {
            maxCount = currCount;
            retCount = 1;
        }
        else if (currCount == maxCount) {
            if (ret != null)
                ret[retCount] = root.val;
            retCount++;
        }
        pre = root;
        inOrder(root.right);
    }
}