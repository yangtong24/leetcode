package com.yt.linklist;

/**
 * @Author : Tong.Yang11@geely.com
 * @Date : 2019/07/23 10:46
 * @Description : 删除排序链表中重复元素
 */
public class RemoveSortDuplicateNode {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode faker = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur = cur.next;
                if (cur.next == null) {
                    faker.next = null;
                }
            } else {
                faker.next = cur.next;
                faker = faker.next;
                cur = cur.next;
            }
        }

        return head;
    }



     public static ListNode deleteDuplicatesV2(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode cur = head;
        while ( cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
               cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {

        ListNode listNode = new ListNode(1);
        ListNode listNode2 = new ListNode(1);
        ListNode listNode3 = new ListNode(2);
        ListNode listNode4 = new ListNode(3);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(5);

        listNode.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;


//        ListNode root = deleteDuplicates(listNode);
        ListNode root = deleteDuplicatesV2(listNode);

        while (root != null) {
            System.out.print(root.val + " -> ");
            root = root.next;
        }
        System.out.print("null");
    }
}
