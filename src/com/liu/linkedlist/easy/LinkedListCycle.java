package com.liu.linkedlist.easy;

import com.liu.linkedlist.ListNode;

/**
 * Created by liu on 17-6-25.
 */
public class LinkedListCycle {

    /**
     * * Given a linked list, determine if it has a cycle in it.
     * Follow up:
     * Can you solve it without using extra space?
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        if(head==null||head.next==null)
            return false;
        ListNode low=head.next,fast=head.next.next;
        while(low!=null&&fast!=null&&fast.next!=null){
            if(low==fast){
                return true;
            }
            low = low.next;
            fast = fast.next.next;
        }
        return false;
    }

    public boolean hasCycle02(ListNode head) {
        if(head==null) return false;
        ListNode walker = head;
        ListNode runner = head;
        while(runner.next!=null && runner.next.next!=null) {
            walker = walker.next;
            runner = runner.next.next;
            if(walker==runner) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode p = new ListNode(2);
        head.next=p;

        ListNode q = new ListNode(3);
        p.next=q;
        p=p.next;

        p.next = new ListNode(5);
        p=p.next;

        p.next=q;

        System.out.println(new LinkedListCycle().hasCycle(head));
    }
}
