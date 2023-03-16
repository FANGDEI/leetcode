package top.dyw.leetcode.simple.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * @author Devil
 * @since 2022-07-09-13:03
 * <p>
 * 句子 是一串由空格分隔的单词。每个 单词 仅由小写字母组成。
 * <p>
 * 如果某个单词在其中一个句子中恰好出现一次，在另一个句子中却 没有出现 ，那么这个单词就是 不常见的 。
 * <p>
 * 给你两个 句子 s1 和 s2 ，返回所有 不常用单词 的列表。返回列表中单词可以按 任意顺序 组织。
 */
@SuppressWarnings("all")
public class L884两句话中的不常见单词 {
    public static void main(String[] args) {

    }

    /**
     * hash表
     *
     * @param s1
     * @param s2
     * @return
     */
    public String[] uncommonFromSentences(String s1, String s2) {
        String[] split1 = s1.split("[ ]+");
        String[] split2 = s2.split("[ ]+");
        ArrayList<String> res = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap();
        for (int i = 0; i < split1.length; i++) {
            map.put(split1[i], map.getOrDefault(split1[i], 0) + 1);
        }
        for (int i = 0; i < split2.length; i++) {
            map.put(split2[i], map.getOrDefault(split2[i], 0) + 1);
        }

        Set<String> strings = map.keySet();
        for (String string : strings) {
            if (map.get(string) == 1) {
                res.add(string);
            }
        }
        return res.toArray(new String[0]);


    }
}
