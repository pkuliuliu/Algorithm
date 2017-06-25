package com.liu.array.easy;

import java.util.Arrays;

/**
 * Created by liu on 17-6-24.
 */
public class ReshapeMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {

        int[][] result= new int[r][c];
        int row = nums.length;
        if(row<1){
            return nums;
        }
        int col = nums[0].length;
        if(row*col!=r*c)
            return nums;
        int cnt=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                result[cnt/c][cnt%c]=nums[i][j];
                cnt++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[][] result = new ReshapeMatrix().matrixReshape(new int[][]{{1,2},{3,4}},1,4);
        for(int i=0;i<result.length;i++){
            System.out.println(Arrays.toString(result[i]));
        }
    }
}
