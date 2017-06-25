package com.liu.linkedlist.medium;

import com.liu.linkedlist.ListNode;

/**
 * Created by liu on 17-6-25.
 */
public class RemoveDuplicatesfromSortedListII {
    /**
     * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

     For example,
     Given 1->2->3->3->4->4->5, return 1->2->5.
     Given 1->1->1->2->3, return 2->3.
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
        ListNode pre = head;
        ListNode p = head.next;
        if(p.val!=pre.val){
            head=pre;
        }else {
            while(p!=null&&p.val==pre.val||p!=null&&p.next!=null&&p.val==p.next.val){
                pre=p;
                p=p.next;
            }
            if(p==null)
                return null;
            head=p;
        }
        while (p!=null&&p.next!=null&&p.next.next!=null){
            if(p.val==p.next.val&&p.val==p.next.next.val){//delete p
                pre.next = p.next;
                p = p.next;
            }else if(p.val==p.next.val){//delete p and p.next
                pre.next = p.next.next;
                p=p.next.next;
            }else {//go to next
                pre=p;
                p=p.next;
            }
        }
        if(p!=null&&p.next!=null&&p.next.next==null&&p.val==p.next.val){
            pre.next=null;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.createLinkedList(new int[]{1,1,2,2,3,3,4,4,5});
        head = new RemoveDuplicatesfromSortedListII().deleteDuplicates(head);
        ListNode.display(head);
    }
}
