package com.liu.review;

/**
 * Created by liu on 17-8-23.
 */
public class MultiplyStrings {
    /**
     * `num1[i] * num2[j]` will be placed at indices `[i + j`, `i + j + 1]`
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        if(len1==0||len2==0)
            return "0";
        int[] dp = new int[len1 + len2];
        for (int i = len1-1; i >=0; i--) {
            for (int j = len2-1; j >= 0; j--) {
                int pos1 = i+j;
                int pos2 = i+j+1;
                int tmp = (num1.charAt(i)-'0')*(num2.charAt(j)-'0')+dp[pos2];
                dp[pos1]+=tmp/10;
                dp[pos2] = tmp%10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int i=0;
        while (dp[i]==0&&i<len1+len2){
            i++;
        }
        while (i<len1+len2){
            sb.append(dp[i]);
            i++;
        }
        return sb.length()==0?"0":sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(new MultiplyStrings().multiply("123","45"));
    }
}
