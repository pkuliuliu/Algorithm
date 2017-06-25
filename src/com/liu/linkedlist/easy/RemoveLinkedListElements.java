package com.liu.linkedlist.easy;

import com.liu.linkedlist.ListNode;

/**
 * Created by liu on 17-6-25.
 */
public class RemoveLinkedListElements {
    /**
     * Remove all elements from a linked list of integers that have value val.
        Example
        Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
        Return: 1 --> 2 --> 3 --> 4 --> 5
     * @param head
     * @param val
     * @return
     */
    public ListNode removeElements(ListNode head, int val) {
        while(head!=null){
            if(head.val==val){
                head=head.next;
            }else {
                break;
            }
        }
        if(head==null)
            return head;
        ListNode pre = head;
        ListNode cur = head.next;
        while(cur!=null){
            if(cur.val==val){
                cur = cur.next;//delect current node
                pre.next = cur;//link node
            }else {
                pre = cur;
                cur=cur.next;
            }
        }
        return head;
    }
}
