package com.yt.linklist;

/**
 * @Author : Tong.Yang11@geely.com
 * @Date : 2019/07/08 23:36
 * 21
 * @Description : 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoList {

    public ListNode mergeTwoSortLists(ListNode l1, ListNode l2) {
        ListNode dummyHead, current;
        dummyHead = new ListNode(0);
        current = dummyHead;

        while(l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }

            current = current.next;
        }

        current.next = (l1 == null) ? l2: l1;

        return dummyHead.next;
    }
}
