package com.liu.linkedlist.medium;

import com.liu.linkedlist.ListNode;

/**
 * Created by liu on 17-6-25.
 */
public class LinkedListCycleII {
    /**
     *  Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
        Note: Do not modify the linked list.
        Follow up:
        Can you solve it without using extra space?
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if(head==null||head.next==null)
            return null;
        ListNode slow = head,fast = head.next;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                break;
            }
        }
        if(slow!=fast){
            return null;
        }
        ListNode head2 = slow.next;
        slow.next = null;
        int len1 = 0,len2 = 0;
        ListNode p1 = head,p2 = head2;
        while(p1!=null){
            len1++;
            p1 = p1.next;
        }
        while (p2!=null){
            len2++;
            p2 = p2.next;
        }

        p1 = head;
        p2 = head2;
        while(len1>len2){
            p1=p1.next;
            len1--;
        }
        while(len2>len1){
            p2=p2.next;
            len2--;
        }
        while(p1!=p2){
            p1=p1.next;
            p2=p2.next;
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode head1 = ListNode.createLinkedList(new int[]{-1,-7,7,-4,19,6});
        ListNode tail1=head1;
        while (tail1.next!=null){
            tail1 = tail1.next;
        }
        ListNode head2 = ListNode.createLinkedList(new int[]{-9,-5,-2,-5});
        ListNode tail2=head2;
        while (tail2.next!=null){
            tail2 = tail2.next;
        }

        tail1.next = head2;
        tail2.next = tail1;
        new LinkedListCycleII().detectCycle(head1);
    }
}
