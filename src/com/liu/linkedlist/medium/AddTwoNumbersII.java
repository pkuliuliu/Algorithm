package com.liu.linkedlist.medium;

import com.liu.linkedlist.ListNode;

import java.util.Stack;

/**
 * Created by liu on 17-6-25.
 */
public class AddTwoNumbersII {
    /**
     * You are given two non-empty linked lists representing two non-negative integers.
     * The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
     * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
     Follow up:
     What if you cannot modify the input lists? In other words, reversing the lists is not allowed.
     Example:
     Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
     Output: 7 -> 8 -> 0 -> 7
     */

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        ListNode p1 = l1;
        ListNode p2 = l2;
        while(p1!=null){
            stack1.add(p1);
            p1 = p1.next;
        }

        while(p2!=null){
            stack2.add(p2);
            p2 = p2.next;
        }
        ListNode headNew = null;
        int k=0;
        while (!stack1.empty()&&!stack2.empty()){
            int tmp = stack1.pop().val+stack2.pop().val+k;
            ListNode tmpNode = new ListNode(tmp%10);
            k = tmp/10;
            tmpNode.next = headNew;
            headNew = tmpNode;
        }
        while(!stack1.empty()){
            int tmp = stack1.pop().val+k;
            ListNode tmpNode = new ListNode(tmp%10);
            k = tmp/10;
            tmpNode.next = headNew;
            headNew = tmpNode;
        }
        while(!stack2.empty()){
            int tmp = stack2.pop().val+k;
            ListNode tmpNode = new ListNode(tmp%10);
            k = tmp/10;
            tmpNode.next = headNew;
            headNew = tmpNode;
        }
        if(k>0){
            ListNode tmpNode = new ListNode(k);
            tmpNode.next  = headNew;
            headNew = tmpNode;
        }

        return headNew;
    }
}
