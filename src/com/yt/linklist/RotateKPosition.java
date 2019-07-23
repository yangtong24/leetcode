package com.yt.linklist;

/**
 * @Author : Tong.Yang11@geely.com
 * @Date : 2019/07/23 16:55
 * @Description :
 * 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 */
public class RotateKPosition {


    public static ListNode rotateRight(ListNode head, int k) {
        int length = countLinkList(head);
        if (length == 0 || k == 0 || k % length == 0) {
            return head;
        }
        // 真正的需要右移的位数
        int m = length - k % length - 1;
        ListNode cur = head;
        while (m > 0) {
            m--;
            cur = cur.next;
        }

        // 分割点
        ListNode tmp = cur.next;
        cur.next = null;

        // 尾节点
        ListNode tail = tmp;
        while (tail != null && tail.next != null) {
            tail = tail.next;
        }
        tail.next = head;

        return tmp;
    }


    private static int countLinkList(ListNode head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.next;
        }
        return count;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);

        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;

        ListNode root = rotateRight(listNode, 3);
        while (root != null) {
            System.out.print(root.val + " -> ");
            root = root.next;
        }
        System.out.print("null");
    }

}
