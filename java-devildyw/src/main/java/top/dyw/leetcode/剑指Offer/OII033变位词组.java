package top.dyw.leetcode.剑指Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Devildyw
 * @date 2023/07/06 10:46
 **/
@SuppressWarnings("all")
public class OII033变位词组 {
    public static void main(String[] args) {

    }

    //老题新作
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        if (strs.length==0||strs==null){
            return result;
        }

        for (String str : strs) {
            char[] charArray = str.toCharArray();
            Arrays.sort(charArray);
            String key = new String(charArray);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str);
            map.put(key,list);
        }

        for (String key : map.keySet()) {
            result.add(map.get(key));
        }
        return result;
    }
}
