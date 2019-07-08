package com.yt.linklist;

/**
 * @Author : Tong.Yang11@geely.com
 * @Date : 2019/07/05 09:06
 * @Description : 单向链表的排序
 */
public class SortSingleListNode {


    public static ListNode sortList(ListNode head) {
        //采用归并排序
        if (head == null || head.next == null) {
            return head;
        }
        //获取中间结点
        ListNode mid = ListNodeUtil.middleNode(head);

        ListNode right = mid.next;

        mid.next = null;

        //合并
        return mergeSort(sortList(head), sortList(right));
    }

    public static ListNode mergeSort(ListNode first, ListNode second) {

        ListNode dummyHead, curr;
        dummyHead = new ListNode();
        curr = dummyHead;

        while (first != null && second != null) {
            if (first.val <= second.val) {
                curr.next = first;
                first = first.next;
            } else {
                curr.next = second;
                second = second.next;
            }
            curr = curr.next;
        }

        curr.next = (first == null) ? second : first;
        return dummyHead.next;
    }
}
