package com.dyw.nowcoder.top100;

/**
 * @author Devil
 * @since 2023-02-05-12:32
 */
@SuppressWarnings("all")
public class BM51数组中出现次数超过一半的数字 {

    public static void main(String[] args) {

    }

    public int MoreThanHalfNum_Solution(int [] array) {
        int[] hash = new int[10000];

        int n = array.length/2;
        for (int i : array) {
            hash[i]++;
            if (hash[i]>n){
                return i;
            }
        }
        return -1;
    }
}
