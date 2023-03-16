package top.dyw.leetcode.medium.priority_queue;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author Devil
 * @since 2022-08-21-10:52
 * <p>
 * 给定一个字符串 s ，根据字符出现的 频率 对其进行 降序排序 。一个字符出现的 频率 是它出现在字符串中的次数。
 * <p>
 * 返回 已排序的字符串。如果有多个答案，返回其中任何一个。
 */
@SuppressWarnings("all")
public class L451根据字符出现频率排序 {
    public static void main(String[] args) {
        System.out.println(new L451根据字符出现频率排序().frequencySort("tree"));
    }

    public String frequencySort(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }

        Iterator<Map.Entry<Character, Integer>> iterator = map.entrySet().stream().sorted(Comparator.comparingInt(entry -> -entry.getValue())).iterator();
        StringBuffer sb = new StringBuffer();
        while (iterator.hasNext()){
            Map.Entry<Character, Integer> next = iterator.next();
            for (Integer i = 0; i < next.getValue(); i++) {
                sb.append(next.getKey());
            }
        }
        return sb.toString();
    }
}
