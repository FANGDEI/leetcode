package com.dyw.leetcode.simple.arrays;

/**
 * @author Devil
 * @date 2022-05-23-16:28
 */
@SuppressWarnings("all")
public class L661图片平滑器 {
    public static void main(String[] args) {

    }

    /**
     * 常规遍历
     * @param img
     * @return
     */
    public int[][] imageSmoother(int[][] img) {
        int iLength = img.length;
        int jLength = img[0].length;

        int[][] ints = new int[iLength][jLength];
        for (int i = 0; i < iLength; i++) {
            for (int j = 0; j < jLength; j++) {
                int sum = 0, num = 0;
                for (int x = i-1; x <= i+1; x++) {
                    for (int y = j-1; y <= j+1; y++) {
                        if (x>=0&&y>=0&&x<iLength&&y<jLength){
                            num++;
                            sum+=img[x][y];
                        }
                    }
                }
                ints[i][j] = sum/num;
            }
        }
        return ints;
    }
}
