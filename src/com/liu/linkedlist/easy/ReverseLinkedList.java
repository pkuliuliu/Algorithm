package com.liu.linkedlist.easy;

import com.liu.linkedlist.ListNode;

/**
 * Created by liu on 17-6-25.
 */
public class ReverseLinkedList {
    /**
     * Reverse a singly linked list
     * Hint:
     * A linked list can be reversed either iteratively or recursively. Could you implement both?
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode headNew = null;
        ListNode cur = head;
        while (cur!=null){
            ListNode tmp = cur.next;
            cur.next = headNew;
            headNew = cur;
            cur = tmp;
        }
        return headNew;
    }
}
