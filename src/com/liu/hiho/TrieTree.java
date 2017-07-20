package com.liu.hiho;

/**
 * Created by liu on 17-7-18.
 */
import java.util.*;
public class TrieTree{
    public static TreeNode initTree(){
        return new TreeNode(' ');
    }
    public static void addWord(TreeNode root,String word,int idx){
        int len = word.length();
        char c = word.charAt(idx);
        if(idx>=len){
            return;
        }
        for(TreeNode node : root.children){
            if(node.elem == c){
                node.num++;
                addWord(node,word,++idx);
                return;
            }
        }

        TreeNode pre = root;
        while(idx<len){
            TreeNode curr = new TreeNode(word.charAt(idx));
            pre.children.add(curr);
            pre = curr;
            idx++;
        }
    }
    public static int find(TreeNode root,String word,int idx){

        int len = word.length();
        char c = word.charAt(idx);
        TreeNode keynode = null;
        for(TreeNode node:root.children){
            if(node.elem == c){
                keynode = node;
                break;
            }
        }
        if(keynode==null){
            return 0;
        }
        if(idx==len-1){
            return keynode.num;
        }else{
            return find(keynode,word,++idx);
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        TreeNode root = initTree();
        int n = scanner.nextInt();
        scanner.nextLine();
        while(n-->0){
            String word = scanner.nextLine();
            addWord(root,word,0);
        }
        int m = scanner.nextInt();
        scanner.nextLine();
        while(m-->0){
            String word = scanner.nextLine();
            System.out.println(find(root,word,0));
        }
    }
}

class TreeNode{
    char elem;
    int num;
    List<TreeNode> children;
    public TreeNode(char elem){
        this.elem = elem;
        num = 1;
        children = new ArrayList<>();
    }
}
