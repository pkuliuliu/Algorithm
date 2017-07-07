package com.liu.string;

/**
 * Created by liu on 17-7-6.
 */
public class ReverseWordsIII {
    /**
     * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
     *
     Example 1:
     Input: "Let's take LeetCode contest"
     Output: "s'teL ekat edoCteeL tsetnoc"
     Note: In the string, each word is separated by single space and there will not be any extra space in the string.
     *
     */
    public String reverseWords(String s) {
        StringBuilder stringBuilder = new StringBuilder();
        for(String word : s.split(" ")){
            stringBuilder.append(new StringBuilder(word).reverse());
            stringBuilder.append(" ");
        }
        return stringBuilder.substring(0, stringBuilder.length()-1);
    }

    public static void main(String[] args) {
        System.out.println(new ReverseWordsIII().reverseWords("Let's take LeetCode contest"));
    }
}
