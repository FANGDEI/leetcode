package com.dyw.nowcoder.top100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

/**
 * @author Devil
 * @since 2023-02-05-12:36
 */
@SuppressWarnings("all")
public class BM52数组中只出现一次的两个数字 {

    public static void main(String[] args) {

    }

    public int[] FindNumsAppearOnce (int[] array) {
        // write code here

        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < array.length; i++) {
            map.put(array[i],map.getOrDefault(array[i],0)+1);
        }

        for (int i = 0; i < array.length; i++) {
            if (map.get(array[i])==1){
                result.add(array[i]);
            }
        }

        //按次序整理
        if (result.get(0)>result.get(1)){
            return new int[]{result.get(1),result.get(0)};
        }else{
            return new int[]{result.get(0),result.get(1)};
        }
    }
}
