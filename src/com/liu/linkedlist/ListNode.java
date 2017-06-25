package com.liu.linkedlist;

/**
 * Created by liu on 17-6-25.
 */
public class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int x) {
        val = x;
        next = null;
    }

    public static ListNode createLinkedList(int[] nums){
        if(nums.length==0){
            return null;
        }
        ListNode head = new ListNode(nums[0]);
        ListNode curr = head;
        for (int i = 1; i < nums.length; i++) {
            curr.next = new ListNode(nums[i]);
            curr = curr.next;
        }
        return head;
    }

    public static void display(ListNode head){
        ListNode curr = head;
        while (curr!=null){
            System.out.print(curr.val+" ");
            curr = curr.next;
        }
        System.out.println();
    }
}
