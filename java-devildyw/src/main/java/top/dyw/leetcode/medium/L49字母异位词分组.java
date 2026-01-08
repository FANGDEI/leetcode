package top.dyw.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class L49字母异位词分组 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList();

        HashMap<String, List<String>> map = new HashMap();
        for (String str : strs) {
            char[] bytes = str.toCharArray();
            Arrays.sort(bytes);
            String newStr = new String(bytes);

            List<String> list = map.getOrDefault(newStr, new ArrayList<String>());
            list.add(str);
            map.put(newStr, list);
        }

        for (String key : map.keySet()) {
            result.add(map.get(key));
        }

        return result;
    }

}

