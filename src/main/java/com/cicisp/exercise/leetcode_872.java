package com.cicisp.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * 请考虑一棵二叉树上所有的叶子，这些叶子的值按从左到右的顺序排列形成一个 叶值序列 。

举个例子，如上图所示，给定一棵叶值序列为 (6, 7, 4, 9, 8) 的树。

如果有两棵二叉树的叶值序列是相同，那么我们就认为它们是 叶相似 的。

如果给定的两个根结点分别为 root1 和 root2 的树是叶相似的，则返回 true；否则返回 false 。

示例 1：

输入：root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]
输出：true
示例 2：

输入：root1 = [1], root2 = [1]
输出：true
示例 3：

输入：root1 = [1], root2 = [2]
输出：false
示例 4：

输入：root1 = [1,2], root2 = [2,2]
输出：true
示例 5：

输入：root1 = [1,2,3], root2 = [1,3,2]
输出：false
 
提示：

给定的两棵树可能会有 1 到 200 个结点。
给定的两棵树上的值介于 0 到 200 之间。
 */

public class leetcode_872 {
    List<Integer> list1 = new ArrayList();
    List<Integer> list2 = new ArrayList();
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null){
            return false;
        }
        dfs(root1, list1);
        dfs(root2, list2);
        if (list1.size() != list2.size()){
            return false;
        }
        // if (list1.equals(list2)){
        //     return true;
        // }else{
        //     return false;
        // }
        for (int i = 0; i < list1.size(); i ++){
            if (list1.get(i) != list2.get(i)){
                return false;
            }
        }
        return true;
    }

    public void dfs(TreeNode root, List<Integer> list){
        if (root == null){
            return ;
        }
        if (root.left == null && root.right == null){
            list.add(root.val);
        }
        dfs(root.left, list);
        dfs(root.right, list);
    }
}
