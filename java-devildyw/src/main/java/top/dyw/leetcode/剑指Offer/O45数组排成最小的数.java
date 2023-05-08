package top.dyw.leetcode.剑指Offer;

import java.util.Arrays;

/**
 * @author Devildyw
 * @date 2023/05/08 22:21
 **/
@SuppressWarnings("all")
public class O45数组排成最小的数 {

    public static void main(String[] args) {

    }

    public String minNumber(int[] nums) {
        String[] newNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newNums[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(newNums,(x,y)->{
            return (x+y).compareTo(y+x);
        });

        StringBuilder res = new StringBuilder();
        for (String newNum : newNums) {
            res.append(newNum);
        }

        return res.toString();
    }
}
