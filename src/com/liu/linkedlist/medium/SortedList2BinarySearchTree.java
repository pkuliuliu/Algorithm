package com.liu.linkedlist.medium;

import com.liu.linkedlist.ListNode;
import com.liu.tree.TreeNode;

/**
 * Created by liu on 17-6-25.
 */
public class SortedList2BinarySearchTree {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null){
            return null;
        }
        TreeNode root = new TreeNode(head.val);
        ListNode p = head.next;
        while(p!=null){
            insert2Tree(root,p);
            p=p.next;
        }
        return null;
    }

    public void insert2Tree(TreeNode root,ListNode node){

    }
}
