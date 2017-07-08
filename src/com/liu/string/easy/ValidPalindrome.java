package com.liu.string.easy;

/**
 * Created by liu on 17-6-29.
 */
public class ValidPalindrome {
    public boolean isPalindrome(String s){
        int low = 0;
        int high = s.length()-1;
        s = s.toLowerCase();
        while(low<=high){
            while(low<=high&&!Character.isAlphabetic(s.charAt(low))){//find character -->
                low++;
            }
            while(low<=high&&!Character.isAlphabetic(s.charAt(high))){
                high--;
            }
            if(low>high){
                return true;
            }
            if(s.charAt(low)!=s.charAt(high)){
                return false;
            }else {
                low++;
                high--;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new ValidPalindrome().isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(new ValidPalindrome().isPalindrome("0P"));
    }
}
