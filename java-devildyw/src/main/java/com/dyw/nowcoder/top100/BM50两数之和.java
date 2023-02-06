package com.dyw.nowcoder.top100;

import java.util.HashMap;

/**
 * @author Devil
 * @since 2023-02-05-12:27
 */
@SuppressWarnings("all")
public class BM50两数之和 {

    public static void main(String[] args) {

    }

    public int[] twoSum (int[] numbers, int target) {
        // write code here

        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target-numbers[i])){
                return new int[]{map.get(target-numbers[i]),i+1};
            }else{
                map.put(numbers[i],i+1);
            }
        }

        return null;

    }
}
