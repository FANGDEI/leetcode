package com.dyw.nowcoder.top100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @author Devil
 * @since 2023-02-09-23:13
 */
@SuppressWarnings("all")
public class BM58字符串的排列 {

    public static void main(String[] args) {
        System.out.println(new BM58字符串的排列().Permutation("qwertyuio"));
    }

    ArrayList<String> result = null;
    StringBuilder path = new StringBuilder();
    HashSet<String> temp = new HashSet<>();
    public ArrayList<String> Permutation(String str) {
        HashSet<Integer> set = new HashSet<>();
        backTracking(str,set);
        result = new ArrayList<>(temp);
        return result;
    }

    private void backTracking(String str, HashSet<Integer> set) {
        if (path.length()==str.length()){
            temp.add(path.toString());
            return;
        }

        for (int i = 0; i < str.length(); i++) {
            if (set.contains(i)){
                continue;
            }

            set.add(i);
            path.append(str.charAt(i));

            backTracking(str,set);

            set.remove(i);
            path.deleteCharAt(path.length()-1);
        }
    }
}
