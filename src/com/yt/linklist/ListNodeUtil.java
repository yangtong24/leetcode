package com.yt.linklist;

/**
 * @Author : Tong.Yang11@geely.com
 * @Date : 2019/07/05 09:08
 * @Description : 链表工具类
 */
public class ListNodeUtil {


    public static ListNode middleNode(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = head;
        while (dummyHead.next != null && dummyHead.next.next != null) {
            dummyHead = dummyHead.next.next;
            head = head.next;
        }
        return head;
    }

}
