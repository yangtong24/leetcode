package com.yt.linklist;

/**
 * @Author : Tong.Yang11@geely.com
 * @Date : 2019/07/04 23:22
 * @Description :
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 * 876
 */
public class MiddleNodeSolution {

    private ListNode middleNode(ListNode head) {
        ListNode dummyHead = head;
        while (dummyHead != null && dummyHead.next != null) {
            dummyHead = dummyHead.next.next;
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        MiddleNodeSolution solution = new MiddleNodeSolution();

        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        ListNode middleNode = solution.middleNode(listNode);
        while (middleNode != null) {
            System.out.println(middleNode.val);
            middleNode = middleNode.next;
        }

    }


}
