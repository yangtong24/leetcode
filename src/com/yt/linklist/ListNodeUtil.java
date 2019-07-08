package com.yt.linklist;

/**
 * @Author : Tong.Yang11@geely.com
 * @Date : 2019/07/05 09:08
 * @Description : 链表工具类
 */
public class ListNodeUtil {


    public static ListNode middleNode(ListNode head) {
        ListNode cur = head;
        while (cur.next != null && cur.next.next != null) {
            cur = cur.next.next;
            head = head.next;
        }
        return head;
    }

}
