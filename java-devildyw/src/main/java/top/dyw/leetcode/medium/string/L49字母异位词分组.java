package top.dyw.leetcode.medium.string;


import java.util.*;

/**
 * @author Devil
 * @since 2022-08-01-10:17
 */
@SuppressWarnings("all")
public class L49字母异位词分组 {
    public static void main(String[] args) {
        System.out.println(new L49字母异位词分组().groupAnagrams(new String[]{"", ""}));
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        //使用hashmap存储 每个key都是字符串排序过后的字符串 value则是与排序后与key相同的字符串列表
        HashMap<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            //先将字符串转化为字符数组
            char[] array = str.toCharArray();
            //排序
            Arrays.sort(array);
            //再转化为字符串
            String key = new String(array);
            //取出对应的key的列表 如果没有就初始化一个列表
            List<String> list = map.getOrDefault(key, new ArrayList<String>());
            //将该字符串填入列表
            list.add(str);
            //再更新map
            map.put(key,list);
        }
        //返回结果
        return new ArrayList<List<String>>(map.values());
    }
}
