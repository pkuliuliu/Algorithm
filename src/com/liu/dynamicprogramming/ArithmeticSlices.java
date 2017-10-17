package com.liu.dynamicprogramming;

/**
 * Created by liu on 17-8-22.
 */
public class ArithmeticSlices {
    /**
     * A sequence of number is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.

     For example, these are arithmetic sequence:

     1, 3, 5, 7, 9
     7, 7, 7, 7
     3, -1, -5, -9
     The following sequence is not arithmetic.

     1, 1, 2, 5, 7

     A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q) such that 0 <= P < Q < N.

     A slice (P, Q) of array A is called arithmetic if the sequence:
     A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.

     The function should return the number of arithmetic slices in the array A.


     Example:

     A = [1, 2, 3, 4]

     return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
     */

    public int numberOfArithmeticSlices(int[] A) {
        int len = A.length;
        if(len<3)
            return 0;
        int res = 0;
        int tmp = 2;
        int d = A[1]-A[0];
        for (int i = 2; i < len; i++) {
            if(A[i]-A[i-1]==d){
                tmp++;
            }else
            {
                if(tmp>=3)
                    res+=(tmp-2)*(tmp-1)/2;
                tmp = 2;
                d = A[i] - A[i-1];
            }
        }
        if(tmp>=3)
            res+=(tmp-2)*(tmp-1)/2;
        return res;
    }

    public static void main(String[] args) {
        ArithmeticSlices a = new ArithmeticSlices();
        int res = a.numberOfArithmeticSlices(new int[]{1, 2, 3, 4});
        System.out.println(res);
    }
}
