package com.liu.linkedlist.medium;

import com.liu.linkedlist.ListNode;

/**
 * Created by liu on 17-6-25.
 */
public class SortList {
    /**
     * Sort a linked list in O(n log n) time using constant space complexity.
     * @param head
     * @return
     *
     * 归并排序
     */

    public ListNode sortList(ListNode head){
        if(head==null || head.next==null)
            return head;

        // split list to two short list
        ListNode slow = head,fast = head.next;
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast =fast.next.next;
        }
        ListNode second = slow.next;
        slow.next=null;
        ListNode first = head;

        first = sortList(first);
        second = sortList(second);

        return merge(first,second);
    }

    public ListNode merge(ListNode head1,ListNode head2){
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        ListNode p1 = head1;
        ListNode p2 = head2;
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

    /**
     * 大于当前节点的放一起，等于的放一起，小于的放一起。。然后拼起来
     * @param head
     * @return
     */
    public ListNode sortList02(ListNode head) {

        if(head == null|| head.next == null) return head;

        ListNode ehandle = new ListNode(0), equal = ehandle;
        ListNode lhandle = new ListNode(0), left = lhandle;
        ListNode rhandle = new ListNode(0), right = rhandle;

        ListNode current = head;
        while(current != null){

            if(current.val < head.val){
                left.next = current;
                left = left.next;
            }

            else if(current.val == head.val){
                equal.next = current;
                equal = equal.next;
            }

            else{
                right.next = current;
                right = right.next;
            }

            current = current.next;
        }
        left.next = equal.next = right.next = null;


        ListNode small = sortList(lhandle.next);
        ListNode large = sortList(rhandle.next);

        equal.next = large;
        if(small == null) return ehandle.next;

        ListNode tail = small;
        while(tail.next != null) tail = tail.next;
        tail.next = ehandle.next;

        return small;


    }


    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        ListNode newHead = new SortList().sortList(head);
        ListNode cur = newHead;
        while(cur!=null){
            System.out.println(cur.val);
            cur= cur.next;
        }

    }
}
