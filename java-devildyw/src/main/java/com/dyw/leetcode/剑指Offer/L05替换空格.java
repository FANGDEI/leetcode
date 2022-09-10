package com.dyw.leetcode.剑指Offer;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * @author Devil
 * @since 2022-09-10-11:33
 */
@SuppressWarnings("all")
public class L05替换空格 {

    public static void main(String[] args) {

    }

    /**
     * 常规做法
     * @param s
     * @return
     */
    public String replaceSpace(String s) {
        if (s == null){
            return null;
        }

        StringBuffer res = new StringBuffer();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)==' '){
                res.append("%20");
            }else{
                res.append(s.charAt(i));
            }
        }

        return res.toString();
    }

    /**
     * 双指针
     * @param s
     * @return
     */
    public String replaceSpace01(String s) {
        //条件判断
        if (s == null || s.length()==0){
            return s;
        }

        //扩充空间，空格数量2两倍
        StringBuffer str = new StringBuffer();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' '){
                str.append("  ");
            }
        }

        //若是没有空格直接返回
        if (str.length() == 0){
            return s;
        }

        //有空格情况 定义两个指针
        int left = s.length() - 1; //左指针：指向原始字符最后一个位置
        //注意这里一定要加上新的空间后取right的指针位置 这样才能实现填充
        s += str.toString();
        int right = s.length() - 1; //右指针：指向原始字符最后一个位置
        char[] chars = s.toCharArray();

        while (left>=0){
            if (chars[left]==' '){
                chars[right--] = '0';
                chars[right--] = '2';
                chars[right] = '%';
            }else{
                chars[right] = chars[left];
            }
            left--;
            right--;
        }

        return new String(chars);
    }
}
