package com.liu.linkedlist.easy;

import com.liu.linkedlist.ListNode;

/**
 * Created by liu on 17-6-25.
 */
public class PalindromeLinkedList {
    /**
     * Given a singly linked list, determine if it is a palindrome.

     Follow up:
     Could you do it in O(n) time and O(1) space?
     */
    public boolean isPalindrome(ListNode head) {
        if(head==null ||head.next==null)
            return true;

        ListNode slow = head;
        ListNode fast = head;
        while (fast!=null&&fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //reverse linkedlist start with slow
        ListNode headNew = null;
        while(slow!=null){
            ListNode tmp = slow.next;
            slow.next = headNew;
            headNew = slow;
            slow = tmp;
        }

        //compare
        slow = headNew;
        ListNode cur = head;
        while(slow!=null){
            if(slow.val!=cur.val){
                return false;
            }
            slow = slow.next;
            cur = cur.next;
        }
        return true;
    }
}
