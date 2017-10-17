package com.liu.dynamicprogramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by liu on 17-8-18.
 */
public class CanIWin {
    /**
     * In the "100 game," two players take turns adding, to a running total, any integer from 1..10. The player who first causes the running total to reach or exceed 100 wins.

     What if we change the game so that players cannot re-use integers?

     For example, two players might take turns drawing from a common pool of numbers of 1..15 without replacement until they reach a total >= 100.

     Given an integer maxChoosableInteger and another integer desiredTotal, determine if the first player to move can force a win, assuming both players play optimally.

     You can always assume that maxChoosableInteger will not be larger than 20 and desiredTotal will not be larger than 300.

     Example

     Input:
     maxChoosableInteger = 10
     desiredTotal = 11

     Output:
     false

     Explanation:
     No matter which integer the first player choose, the first player will lose.
     The first player can choose an integer from 1 up to 10.
     If the first player choose 1, the second player can only choose integers from 2 up to 10.
     The second player will win by choosing 10 and get a total = 11, which is >= desiredTotal.
     Same with other integers chosen by the first player, the second player will always win.
     * @param maxChoosableInteger
     * @param desiredTotal
     * @return
     */
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int[] used = new int[maxChoosableInteger];
        if(maxChoosableInteger*(maxChoosableInteger+1)/2<desiredTotal)
            return false;
        return helper(used,new HashMap<>(),desiredTotal);
    }

    //计算当前状态used下，能否取胜
    boolean helper(int[] used, Map<String,Boolean> states, int desiredTotal){
        String state = Arrays.toString(used);
        if(!states.containsKey(state)){
            for (int i = 0; i < used.length; i++) {
                if(used[i]==0){
                    if (i+1>=desiredTotal){
                        states.put(state,true);
                        return true;
                    }
                }
            }

            for (int i = 0; i < used.length; i++) {
                if(used[i]==0) {
                    used[i] = 1;
                    boolean tmp = helper(used, states, desiredTotal - i - 1);
                    if (tmp == false) {
                        used[i] = 0;
                        states.put(state, true);
                        return true;
                    }
                    used[i] = 0;
                }
            }
            states.put(state, false);
            return false;
        }else {
            return states.get(state);
        }
    }

    public static void main(String[] args) {
        CanIWin canIWin = new CanIWin();
        System.out.println(canIWin.canIWin(5,50));
    }
}
