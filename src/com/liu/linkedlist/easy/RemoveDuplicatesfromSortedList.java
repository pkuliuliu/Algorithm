package com.liu.linkedlist.easy;

import com.liu.linkedlist.ListNode;

/**
 * Created by liu on 17-6-25.
 */
public class RemoveDuplicatesfromSortedList {
    /**
     * Given a sorted linked list, delete all duplicates such that each element appear only once.
     * For example,
     * Given 1->1->2, return 1->2.
     * Given 1->1->2->3->3, return 1->2->3.
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null)
            return head;
        ListNode pre=head;
        ListNode cur=head.next;
        while (cur!=null){
            if(cur.val!=pre.val){
                pre=pre.next;
                cur=cur.next;
            }else{
                cur=cur.next;
                pre.next=cur;
            }
        }
        return head;
    }
}
