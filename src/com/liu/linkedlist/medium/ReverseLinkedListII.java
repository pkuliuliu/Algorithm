package com.liu.linkedlist.medium;

import com.liu.linkedlist.ListNode;

/**
 * Created by liu on 17-6-25.
 */
public class ReverseLinkedListII {
    /**
     * Reverse a linked list from position m to n. Do it in-place and in one-pass.
     For example:
     Given 1->2->3->4->5->NULL, m = 2 and n = 4,
     return 1->4->3->2->5->NULL.
     1<=m<=n<=length
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode begin=head,ltail=null,rhead=null,end=null;

        int i=1;
        while(i<m){//find begin
            ltail = begin;
            begin = begin.next;
            i++;
        }
        end = begin;

        while(i<n){
            end=end.next;
            i++;
        }
        rhead = end.next;

        ListNode headNew = rhead;
        while (begin!=end){
            ListNode tmp = begin.next;
            begin.next = headNew;
            headNew = begin;
            begin = tmp;
        }
        begin.next = headNew;
        headNew = begin;

        if(ltail!=null){
            ltail.next = headNew;
            return head;
        }else {
            return headNew;
        }
    }


    public static void main(String[] args) {
        ListNode head = ListNode.createLinkedList(new int[]{3,5});
        head = new ReverseLinkedListII().reverseBetween(head,1,1);
        ListNode.display(head);
    }
}
