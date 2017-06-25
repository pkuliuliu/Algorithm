
package com.liu.array.easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by liu on 17-6-24.
 */
public class MaximumDistanceinArrays {
    /**
     * Given m arrays, and each array is sorted in ascending order.
     * Now you can pick up two integers from two different arrays (each array picks one) and calculate the distance.
     * We define the distance between two integers a and b to be their absolute difference |a-b|.
     * Your task is to find the maximum distance.
     * @param arrays
     * @return
     */
    public int maxDistance(List<List<Integer>> arrays) {
        int max = arrays.get(0).get(arrays.get(0).size()-1);
        int min = arrays.get(0).get(0);
        int result = 0;
        int size = arrays.size();
        int i=1;
        while (i<size){
            int tmpMin = arrays.get(i).get(0);
            int tmpMax = arrays.get(i).get(arrays.get(i).size()-1);

            result = Math.max(Math.max(Math.abs(tmpMax-min),Math.abs(max-tmpMin)),result);

            max = Math.max(max,tmpMax);
            min = Math.min(min,tmpMin);
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(new Integer[]{1,2,3}));
        list.add(Arrays.asList(new Integer[]{4,5}));
        list.add(Arrays.asList(new Integer[]{1,2,3}));
        System.out.println(new MaximumDistanceinArrays().maxDistance(list));
    }
}
