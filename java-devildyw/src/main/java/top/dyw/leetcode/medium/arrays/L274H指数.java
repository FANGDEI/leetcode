package top.dyw.leetcode.medium.arrays;

import java.util.Arrays;

/**
 * @author Devildyw
 * @date 2023/07/15 12:45
 **/
@SuppressWarnings("all")
public class L274H指数 {

    public static void main(String[] args) {
        System.out.println(new L274H指数().hIndex(new int[]{1, 3, 1}));
    }

    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        int i = citations.length-1;
        while (i>=0&&citations[i]>h){
            h++;
            i--;
        }
        return h;
    }
}
