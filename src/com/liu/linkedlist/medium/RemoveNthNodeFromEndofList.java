package com.liu.linkedlist.medium;

import com.liu.linkedlist.ListNode;

/**
 * Created by liu on 17-6-25.
 */
public class RemoveNthNodeFromEndofList {
    /**
     * Given a linked list, remove the nth node from the end of list and return its head.

     For example,

     Given linked list: 1->2->3->4->5, and n = 2.

     After removing the second node from the end, the linked list becomes 1->2->3->5.
     Note:
     Given n will always be valid.
     Try to do this in one pass.
     */

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        head = pre;
        ListNode curr = pre;
        int i = 0;
        while (i<n){
            curr = curr.next;
            i++;
        }
        while (curr.next!=null){
            curr = curr.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return head.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.createLinkedList(new int[]{1,2,3,4,5});
        head = new RemoveNthNodeFromEndofList().removeNthFromEnd(head,2);
        ListNode.display(head);
    }
}
