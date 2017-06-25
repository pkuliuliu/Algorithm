package com.liu.linkedlist.medium;

import com.liu.linkedlist.ListNode;

/**
 * Created by liu on 17-6-25.
 */
public class RotateList {
    /**
     * Given a list, rotate the list to the right by k places, where k is non-negative.

     For example:
     Given 1->2->3->4->5->NULL and k = 2,
     return 4->5->1->2->3->NULL
     */
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null||head.next==null){
            return head;
        }
        int len = 0;
        ListNode cur = head;
        while (cur!=null){
            len++;
            cur = cur.next;
        }
        k=k%len;
        if(k==0)
            return head;

        cur=head;
        while(len-->k+1){
            cur = cur.next;
        }
        ListNode headNew = cur.next;
        cur.next=null;

        cur = headNew;
        while(cur.next!=null){
            cur=cur.next;
        }
        cur.next=head;
        return headNew;
    }
}
