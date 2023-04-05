package top.dyw.leetcode.simple.string;

import java.util.HashMap;

/**
 * @author Devil
 * @since 2022-06-20-16:01
 * <p>
 * 给定两个字符串s和t，判断它们是否是同构的。
 * <p>
 * 如果s中的字符可以按某种映射关系替换得到t，那么这两个字符串是同构的。
 *
 * <strong>每个出现的字符都应当映射到另一个字符，同时不改变字符的顺序。不同字符不能映射到同一个字符上，相同字符只能映射到同一个字符上，字符可以映射到自己本身。</strong>
 */
@SuppressWarnings("all")
public class L205同构字符串 {
    public static void main(String[] args) {
        System.out.println(new L205同构字符串().isIsomorphic("egg", "add"));
    }

    /**
     * hash表 主要是存储两个字符串中字符之间的对应关系 每个出现的字符都应当映射到另一个字符,同时不改变字符的顺序
     *
     * @param s
     * @param t
     * @return
     */
    public boolean isIsomorphic(String s, String t) {
        //为两个数组都创建hash表
        HashMap<Character, Character> sMap = new HashMap<>();
        HashMap<Character, Character> tMap = new HashMap<>();
        //因为由题可知 两个字符串的长度都是相同的 所以可以一次遍历两个字符串
        for (int i = 0; i < s.length(); i++) {
            //取出两个字符串中相同索引的字符
            char x = s.charAt(i), y = t.charAt(i);
            //判断在hash表中存在该字符的请款下 该字符映射的字符是否是另一个字符此时索引对应的字符(因为由题可知字符的顺序是一致的)
            if ((sMap.containsKey(x) && sMap.get(x) != y) || (tMap.containsKey(y) && tMap.get(y) != x)) {
                //如果现一个不满足就返回false 即不是同构字符串
                return false;
            }
            //如果两个都不满足那么就将映射关系加入两个字符串各自的hashmap中(上述if条件不满足说明此时可能该字符不存在在hash表中 也可能两者映射关系满足 x-->y y-->x)
            sMap.put(x, y);
            tMap.put(y, x);
        }
        return true;
    }
}
