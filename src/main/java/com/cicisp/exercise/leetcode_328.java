package com.cicisp.exercise;


/**
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。

请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。

示例 1:

输入: 1->2->3->4->5->NULL
输出: 1->3->5->2->4->NULL
示例 2:

输入: 2->1->3->5->6->4->7->NULL 
输出: 2->3->6->7->1->5->4->NULL
说明:

应当保持奇数节点和偶数节点的相对顺序。
链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。

 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class leetcode_328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null){
            return head;
        }
        ListNode fakeHead = head.next;  // 用于存储 另一个 “链表头”
        ListNode oddNode = head;
        ListNode evenNode = fakeHead;

        /*
            1、边遍历，边将 原链表 分为 奇数下标 和 偶数下标 两链表
         */
        while (evenNode != null && evenNode.next != null && oddNode.next != null && oddNode.next != null) {
            /*
                此处必须是 先改变oddNode的next指向，再改变evenNode的next指向
                因为 每轮oddNode的next域 就是下一个evenNode,
                若是先改变了evenNode，那么对应的前驱节点(oddNode)就会被影响
             */
            oddNode.next = oddNode.next.next;
            evenNode.next = evenNode.next.next;
            evenNode = evenNode.next;
            oddNode = oddNode.next;
        }

        /*
            2、将 偶数下标链表 拼接在 奇数下标链表 后
         */
        oddNode.next = fakeHead;
        return head;
    }
}