package com.dyw.leetcode.周赛.第322周;

/**
 * @author Devil
 * @since 2022-12-04-11:10
 */
@SuppressWarnings("all")
public class L6253回环句 {

    public static void main(String[] args) {
        System.out.println(new L6253回环句().isCircularSentence("leetcode exercises sound delightful"));
    }

    public boolean isCircularSentence(String sentence) {
        String[] array = sentence.split("[ ]+");
        for (int i = 1; i<array.length; i++){
            if (array[i-1].charAt(array[i-1].length()-1)!=array[i].charAt(0)){
                return false;
            }
        }
        if (array[array.length-1].charAt(array[array.length-1].length()-1)!=array[0].charAt(0)){
            return false;
        }
        return true;

    }
}
