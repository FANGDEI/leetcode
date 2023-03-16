package top.dyw.leetcode.algorithm.贪心;

import java.util.LinkedList;
import java.util.List;

/**
 * 字符串 S 由小写字母组成。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。返回一个表示每个字符串片段的长度的列表。
 *
 * @author Devil
 * @since 2022-10-25-10:34
 */
@SuppressWarnings("all")
public class L763划分字母区间 {

    public static void main(String[] args) {

    }


    /**
     * 统计每一个字符最后出现的位置
     * <p>
     * 从头遍历字符，并更新字符的最远出现下标，如果找到字符最远出现位置下标和当前下标相等了，则找到了分割点
     *
     * @param s
     * @return
     */
    public List<Integer> partitionLabels(String s) {
        List<Integer> list = new LinkedList<>();
        //记录字母的出现位置
        int[] edge = new int[26];
        char[] chars = s.toCharArray();

        //遍历字符串 更新字母出现的位置
        for (int i = 0; i < chars.length; i++) {
            edge[chars[i]-'a'] = i;
        }

        //分割的终止位置
        int idx = 0;
        //分割的起始位置
        int last = -1;

        for (int i = 0; i < chars.length; i++) {
            //更新字符的最远出现下标
            idx = Math.max(idx,edge[chars[i]-'a']);
            //如果当前遍历的下标恰好等于idx 那么代表该位置就是字符串之间的分割点了（即该字符串中所有字母中能到达的最远下标）。
            if (i==idx){
                list.add(i-last);
                //更新
                last = i;
            }
        }
        return list;


    }
}
