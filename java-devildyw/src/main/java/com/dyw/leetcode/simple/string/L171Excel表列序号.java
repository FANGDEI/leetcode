package com.dyw.leetcode.simple.string;

/**
 * @author Devil
 * @since 2022-06-20-15:44
 *
 * 给你一个字符串 columnTitle ，表示 Excel 表格中的列名称。返回 该列名称对应的列序号 。
 */
@SuppressWarnings("all")
public class L171Excel表列序号 {
    public static void main(String[] args) {
        System.out.println(new L171Excel表列序号().titleToNumber("A"));
    }

    /**
     * 类似于L168的逆转题
     * @param columnTitle
     * @return
     */
    public int titleToNumber(String columnTitle) {
        int res = 0;
        int length = columnTitle.length();
        for (int i = 0; i < length; i++) {
            res += (columnTitle.charAt(i)-'A'+1)*Math.pow(26,length-i-1);
        }
        return res;

    }
}
