package top.dyw.leetcode.simple.arrays;

import java.util.HashSet;

/**
 * @author Devil
 * @since 2022-06-17-13:19
 * <p>
 * 国际摩尔斯密码定义一种标准编码方式，将每个字母对应于一个由一系列点和短线组成的字符串，比如:
 * <p>
 * 'a' 对应 ".-" ，
 * 'b' 对应 "-..." ，
 * 'c' 对应 "-.-." ，以此类推。
 * <p>
 * 给你一个字符串数组 words ，每个单词可以写成每个字母对应摩尔斯密码的组合。
 * <p>
 * 例如，"cab" 可以写成 "-.-..--..." ，(即 "-.-." + ".-" + "-..." 字符串的结合)。我们将这样一个连接过程称作 单词翻译 。
 * 对 words 中所有单词进行单词翻译，返回不同 单词翻译 的数量。
 */
@SuppressWarnings("all")
public class L804唯一摩尔斯密码词 {
    String[] mors = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-",
            ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-",
            "-.--", "--.."};

    public static void main(String[] args) {
        System.out.println(new L804唯一摩尔斯密码词().uniqueMorseRepresentations(new String[]{"gin", "zen", "gig", "msg"}));
    }

    /**
     * 使用hashset集合去重的特性 首先初始化一个数组用来对应26个字母的摩尔字段 然后遍历单词的每一个字符找到对应的摩尔字段然后拼凑起来最后加入set自动去重
     * 最后返回集合大小
     *
     * @param words
     * @return
     */
    public int uniqueMorseRepresentations(String[] words) {
        HashSet<String> set = new HashSet<>();

        int length = words.length;
        for (int i = 0; i < length; i++) {
            StringBuffer sb = new StringBuffer("");
            for (int j = 0; j < words[i].length(); j++) {
                sb.append(mors[words[i].charAt(j) - 'a']);
            }
            set.add(sb.toString());
        }


        return set.size();
    }
}
