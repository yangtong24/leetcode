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

    public ListNode middleNode(ListNode head) {
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            cur = cur.next.next;
            head = head.next;
        }
        return head;
    }
  


}
