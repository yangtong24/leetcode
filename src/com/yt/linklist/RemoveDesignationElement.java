package com.yt.linklist;

/**
 * @Author : Tong.Yang11@geely.com
 * @Date : 2019/11/07 13:36
 * @Description : no.203
 * <p>
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 * <p>
 * <p>
 * 删除链表中等于给定值 val 的所有节点。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->6->6->6->3->4->5->6, val = 6
 * 输出: 1->2->3->4->5
 */
public class RemoveDesignationElement {

    private static ListNode removeElements(ListNode head, int val) {
        ListNode dumb = new ListNode(-1);
        dumb.next = head;
        ListNode cur = dumb;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dumb.next;
    }

    public static void main(String[] args) {

        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(6);
        ListNode listNode4 = new ListNode(6);
        ListNode listNode5 = new ListNode(6);
        ListNode listNode6 = new ListNode(3);
        ListNode listNode7 = new ListNode(4);
        ListNode listNode8 = new ListNode(5);
        ListNode listNode9 = new ListNode(6);

        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode8;
        listNode8.next = listNode9;

        ListNode middleNode = removeElements(listNode, 6);
        while (middleNode != null) {
            System.out.println(middleNode.val);
            middleNode = middleNode.next;
        }

    }
}
