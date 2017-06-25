package com.liu.linkedlist.medium;

import com.liu.linkedlist.ListNode;

/**
 * Created by liu on 17-6-25.
 */
public class PartitionList {
    /**
     * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
     * You should preserve the original relative order of the nodes in each of the two partitions
     *
     * For example,
     Given 1->4->3->2->5->2 and x = 3,
     return 1->2->2->4->3->5.
     */
    public ListNode partition(ListNode head, int x) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode head1 = new ListNode(0);
        ListNode head2 = new ListNode(0);
        ListNode p1 = head1;
        ListNode p2 = head2;
        ListNode p = head;
        while (p!=null){
            if(p.val<x){
                p1.next=p;
                p1=p;
            }else {
                p2.next=p;
                p2=p;
            }
            p=p.next;
        }
        p1.next=head2.next;
        p2.next=null;
        return head1.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.createLinkedList(new int[]{1,1});
        head = new PartitionList().partition(head,2);
        ListNode.display(head);
    }
}
