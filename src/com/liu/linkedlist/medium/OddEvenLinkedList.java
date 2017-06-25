package com.liu.linkedlist.medium;

import com.liu.linkedlist.ListNode;

/**
 * Created by liu on 17-6-25.
 */
public class OddEvenLinkedList {
    /**
     * Given a singly linked list, group all odd nodes together followed by the even nodes.
     * Please note here we are talking about the node number and not the value in the nodes.
     * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

     Example:
     Given 1->2->3->4->5->NULL,
     return 1->3->5->2->4->NULL.

     Note:
     The relative order inside both the even and odd groups should remain as it was in the input.
     The first node is considered odd, the second node even and so on ...
     */

    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null||head.next.next==null)
            return head;
        ListNode p = head;
        ListNode head1 = new ListNode(-1);
        ListNode head2 = new ListNode(-1);
        ListNode p1 = head1,p2 = head2;
        int k=0;
        while(p!=null){
            if(k%2==0){//odd
                p1.next = p;
                p1=p;
            }else {//even
                p2.next = p;
                p2=p;
            }
            p=p.next;
            k++;
        }
        p1.next=head2.next;
        p2.next=null;
        return head1.next;
    }

    public ListNode oddEvenList02(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;

        while(even != null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }

        odd.next = evenHead;
        return head;



    }

    public static void main(String[] args) {
        ListNode head = ListNode.createLinkedList(new int[]{1,2,3,4,5,6,7,8});
        head = new OddEvenLinkedList().oddEvenList(head);
        ListNode.display(head);
    }
}
