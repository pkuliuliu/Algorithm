package com.liu.linkedlist.medium;

import com.liu.linkedlist.ListNode;

/**
 * Created by liu on 17-6-25.
 */
public class ReorderList {
    /**
     * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
     reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

     You must do this in-place without altering the nodes' values.

     For example,
     Given {1,2,3,4}, reorder it to {1,4,2,3}.
     */
    public void reorderList(ListNode head) {
        if (head==null||head.next==null||head.next.next==null){
            return;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode curr = slow.next;
        slow.next = null;

        ListNode headLater = null;
        while(curr!=null){
            ListNode tmp = curr.next;
            curr.next = headLater;
            headLater = curr;
            curr = tmp;
        }
        curr = head;
        ListNode currLater = headLater;
        while(curr!=null&&currLater!=null){
            ListNode tmp = currLater.next;
            currLater.next = curr.next;
            curr.next = currLater;
            curr = currLater.next;
            currLater = tmp;
        }
    }

    public static void main(String[] args) {
        ListNode head = ListNode.createLinkedList(new int[]{1,2,3,4});
        new ReorderList().reorderList(head);
        ListNode.display(head);
    }
}
