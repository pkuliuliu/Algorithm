package com.liu.linkedlist.easy;

import com.liu.linkedlist.ListNode;

/**
 * Created by liu on 17-6-25.
 */
public class IntersectionofTwoLinkedLists {
    /**
     * Write a program to find the node at which the intersection of two singly linked lists begins.
     * For example, the following two linked lists:
     * A:          a1 → a2↘
                            c1 → c2 → c3
                            ↗
        B:     b1 → b2 → b3
     begin to intersect at node c1.
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA=0,lenB=0;
        ListNode pA = headA;
        ListNode pB = headB;
        while(pA!=null||pB!=null){
            if(pA!=null){
                lenA++;
                pA=pA.next;
            }
            if(pB!=null){
                lenB++;
                pB=pB.next;
            }
        }
        pA = headA;
        pB = headB;
        int diff = lenA-lenB;
        if(diff>0){
            while (diff-->0){
                pA=pA.next;
            }
        }else{
            while (diff++<0){
                pB=pB.next;
            }
        }
        while(pA!=null){
            if(pA==pB)
                return pA;
            pA=pA.next;
            pB=pB.next;
        }
        return null;
    }
}
