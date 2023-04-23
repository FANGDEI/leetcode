package top.dyw.leetcode.剑指Offer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Devildyw
 * @date 2023/04/22 12:36
 **/
@SuppressWarnings("all")
public class O38字符串的排列 {
    public static void main(String[] args) {
        String[] permutation = new O38字符串的排列().permutation("aab");
        for (String s : permutation) {
            System.out.print(s+" ");
        }
    }

    HashSet<String> result = new HashSet<>();
    StringBuilder path = new StringBuilder("");
    public String[] permutation(String s) {
        HashSet<Integer> set = new HashSet<>();
        backTracking(s,set);
        ArrayList<String> res = new ArrayList<>(result);
        return res.toArray(new String[res.size()]);
    }

    private void backTracking(String str, HashSet<Integer> set) {
        if (path.length()==str.length()){
            result.add(path.toString());
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
