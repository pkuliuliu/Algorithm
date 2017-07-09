package com.liu.string.medium;

/**
 * Created by liu on 17-7-9.
 */
public class LongestCommonSubstring {
    /**
     * f(i,j)表示以当前位置结尾的最长公共子串的长度。
     *          0             ,i==0||j==0
     * f(i,j) = f(i-1,j-1)+1  ,Xi==Yj
     *          0             ,Xi!=Yj
     *
     * @param str1
     * @param str2
     * @return
     */
    public String longestCommonSubstring(String str1,String str2){
        int key=0;
        int cnt=1;
        int len1 = str1.length();
        int len2 = str2.length();
        int[][] flag = new int[len1+1][len2+1];
        for(int i=1;i<len1+1;i++){
            for(int j=1;j<len2+1;j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    flag[i][j] = flag[i - 1][j - 1] + 1;
                    if(flag[i][j]>cnt){
                        key=i-1;
                        cnt = flag[i][j];
                    }
                }
            }
        }

        return str1.substring(key-cnt+1,key+1);
    }

    public static void main(String[] args) {
        System.out.println(new LongestCommonSubstring().longestCommonSubstring("abcdefgh","cdefg"));
    }
}
