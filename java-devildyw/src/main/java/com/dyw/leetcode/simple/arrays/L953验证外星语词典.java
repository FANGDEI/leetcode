package com.dyw.leetcode.simple.arrays;

/**
 * @author Devil
 * @since 2022-07-09-11:28
 * <p>
 * 某种外星语也使用英文小写字母，但可能顺序 order 不同。字母表的顺序（order）是一些小写字母的排列。
 * <p>
 * 给定一组用外星语书写的单词 words，以及其字母表的顺序 order，只有当给定的单词在这种外星语中按字典序排列时，返回 true；否则，返回 false。
 */
@SuppressWarnings("all")
public class L953验证外星语词典 {
    public static void main(String[] args) {
        System.out.println(new L953验证外星语词典().isAlienSorted(new String[]{"apple", "app"}, "abcdefghijklmnopqrstuvwxyz"));
    }

    /**
     * 直接遍历
     *
     * @param words
     * @param order
     * @return
     */
    public boolean isAlienSorted(String[] words, String order) {
        //初始化一个数组用于存储 order中的单个字符与其在order中的下标的关系 当作字典
        int[] index = new int[26];
        for (int i = 0; i < order.length(); i++) {
            index[order.charAt(i) - 'a'] = i;
        }
        //遍历字符串数组 从下标一开始 与其前一个相对比
        for (int i = 1; i < words.length; i++) {
            //初始化标识符
            boolean vaild = false;
            //与前一个字符串相对比  注意下标的最大范围为两个字符串中最小的那个长度
            for (int j = 0; j < words[i - 1].length() && j < words[i].length(); j++) {
                //获取字典中的顺序
                int prev = index[words[i - 1].charAt(j) - 'a'];
                int curr = index[words[i].charAt(j) - 'a'];
                //如果前几个字符是按字典升序 那么标识符为true 跳出循环
                if (prev < curr) {
                    vaild = true;
                    break;
                } else if (prev > curr) {//如果不是按字典升序 不符合条件返回false
                    return false;
                }
            }
            //如果两个字符串在一定的范围内相等 那么比较长度 如果长度大的 那么字符串就大
            if (!vaild) {
                if (words[i - 1].length() > words[i].length()) {
                    //降序 返回false
                    return false;
                }
            }
        }
        //如果符合条件返回true
        return true;
    }
}
