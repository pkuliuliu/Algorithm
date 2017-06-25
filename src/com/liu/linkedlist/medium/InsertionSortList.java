package com.liu.linkedlist.medium;

import com.liu.linkedlist.ListNode;

/**
 * Created by liu on 17-6-25.
 */
public class InsertionSortList {

    /**
     * Sort a linked list using insertion sort.
     * @param head
     * @return
     */
    public ListNode insertionSortList(ListNode head) {

        if(head==null)
            return head;

        ListNode headNew = new ListNode(Integer.MIN_VALUE);//new linkedlist
        ListNode p = headNew;
        ListNode pre = null;

        ListNode curr = head;
        while (curr!=null){
            ListNode tmp = curr.next;
            //find poisition for insert current node
            while(p!=null && curr.val>=p.val){//loop until find curr vlue < a value
                pre = p;
                p = p.next;
            }
            //insert current value before the bigger value
            pre.next=curr;
            curr.next=p;
            curr=tmp;
            p=headNew;
            pre=null;
        }

        return headNew.next;
    }
}
