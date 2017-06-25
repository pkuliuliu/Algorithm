package com.liu.array.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liu on 17-6-24.
 */
public class PascalTriangle {
    /**
     * Given numRows, generate the first numRows of Pascal's triangle.
     * For example, given numRows = 5,
     * Return
     * [
     * [1],
     * [1,1],
     * [1,2,1],
     * [1,3,3,1],
     * [1,4,6,4,1]
     * ]
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        for(int i=0;i<numRows;i++){
            List<Integer> tmp = new ArrayList<>();
            int vCur=1;
            tmp.add(vCur);
            for (int j = 1; j <= i; j++) {
                vCur = vCur*(i-j+1)/j;
                tmp.add(vCur);
            }
            lists.add(tmp);
        }
        return lists;
    }

    public List<List<Integer>> generate02(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows < 1) {
            return res;
        }
        //generate 1st row
        List<Integer> cur = new ArrayList<>();
        cur.add(1);
        res.add(cur);
        for(int i = 1; i < numRows; i++) {
            cur = new ArrayList<>();
            cur.add(1);
            List<Integer> last = res.get(i - 1);
            for(int j = 1; j < last.size(); j++) {
                cur.add(last.get(j - 1) + last.get(j));
            }
            cur.add(1);
            res.add(cur);
        }
        return res;
    }

    public static void main(String[] args) {
        List<List<Integer>> lists = new PascalTriangle().generate(5);
        for(List<Integer> list : lists){
            System.out.println(list);
        }
    }
}
