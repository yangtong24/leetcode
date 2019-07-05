package com.yt.linklist;

/**
 * @Author : Tong.Yang11@geely.com
 * @Date : 2019/07/05 09:06
 * @Description : 单向链表的排序
 */
public class SortSingleListNode {

    /**
     * 思路还是找到链表中间， 递归merge
     *
     * @param head
     * @return
     */
    private ListNode sort(ListNode head) {
        ListNode middle = ListNodeUtil.middleNode(head);
        ListNode last = ListNodeUtil.lastNode(head);
        sort(head, middle);
        sort(middle, last);
        merge(head, middle, last);
        return null;
    }

    private void merge(ListNode head, ListNode middle, ListNode last) {

    }

    private void sort(ListNode head, ListNode midddle) {

    }


}
