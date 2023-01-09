package com.dyw.leetcode.algorithm.doublePointer;

/**
 * @author Devil
 * @since 2022-12-28-11:33
 */
@SuppressWarnings("all")
public class L1750删除字符串两端相同字符后的最短长度 {

    public static void main(String[] args) {
        System.out.println(new L1750删除字符串两端相同字符后的最短长度().minimumLength("bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb"));
    }

    /**
     * 双指针
     * @param s
     * @return
     */
    public int minimumLength(String s) {
        int left = 0, right = s.length()-1;

        while (left<right&&s.charAt(left)==s.charAt(right)){
            char c = s.charAt(left);

            while (left<=right&&s.charAt(left)==c){
                left++;
            }

            while (left<=right&&s.charAt(right)==c){
                right--;
            }

        }

        return right-left+1;
    }
}
