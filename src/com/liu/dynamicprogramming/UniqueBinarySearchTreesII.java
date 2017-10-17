package com.liu.dynamicprogramming;

import com.liu.tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liu on 17-8-10.
 */
public class UniqueBinarySearchTreesII {


    public List<TreeNode> generateTrees(int n) {
        if(n==0)
            return new ArrayList<>();
        return  helper(1,n);
    }

    public List<TreeNode> helper(int begin,int end){
        List<TreeNode> result = new ArrayList<>();
        if(begin==end){
            result.add(new TreeNode(begin));
            return result;
        }
        if(begin>end){
            result.add(null);
            return result;
        }
        for (int i = begin; i <= end; i++) {
            List<TreeNode> lefttrees = helper(begin,i-1);
            List<TreeNode> righttrees = helper(i+1,end);
            for (TreeNode left : lefttrees){
                for(TreeNode right : righttrees){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    result.add(root);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        UniqueBinarySearchTreesII un = new UniqueBinarySearchTreesII();
        List<TreeNode> result = un.generateTrees(3);
        System.out.println(result.size());
        System.out.println();
    }
}
