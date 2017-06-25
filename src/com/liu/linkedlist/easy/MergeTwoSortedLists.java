package com.liu.linkedlist.easy;

import com.liu.linkedlist.ListNode;

/**
 * Created by liu on 17-6-25.
 */
public class MergeTwoSortedLists {
    /**
     * Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
     */
    public ListNode mergeTwoLists02(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while(p1!=null&&p2!=null){
            if(p1.val<p2.val){
                cur.next = p1;
                cur = cur.next;
                p1 = p1.next;
            }else{
                cur.next = p2;
                cur = cur.next;
                p2 = p2.next;
            }
        }
        if(p1!=null){
            cur.next=p1;
        }
        if(p2!=null){
            cur.next=p2;
        }
        return head.next;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        ListNode mergeNode;
        if(l1.val<l2.val){
            mergeNode=l1;
            mergeNode.next=mergeTwoLists(l1.next,l2);
        }
        else{
            mergeNode=l2;
            mergeNode.next=mergeTwoLists(l1,l2.next);
        }
        return mergeNode;
    }
}
