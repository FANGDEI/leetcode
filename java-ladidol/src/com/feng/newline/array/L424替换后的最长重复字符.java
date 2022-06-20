package com.feng.newline.array;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.array
 * @className: L424替换后的最长重复字符 右边无脑滑动，左边看情况收缩
 * @author: Ladidol
 * @description: s 和一个整数 k 。你可以选择字符串中的任一字符，并将其更改为任何其他大写英文字符。该操作最多可执行 k 次。
 * 在执行上述操作后，返回包含相同字母的最长子字符串的长度。
 * @date: 2022/5/22 12:42
 * @version: 1.0
 */
public class L424替换后的最长重复字符 {
    public static void main(String[] args) {
        System.out.println(new L424().characterReplacement("AAABBBAAAAB",2));
    }
}
class L424 {
    public int characterReplacement(String s, int k) {
        int[] map = new int[26];//模仿map的数组, 主要是只有这个26个字母
        int left = 0;
        int right = 0;
        int sameMaxLetter = 0;
        int len = s.length();
        while (right<len){
            char c = s.charAt(right);
            map[c-'A']++;
            sameMaxLetter = Math.max(sameMaxLetter,map[c-'A']);//这里面的map[a]的值是 范围是窗口里面的
            if (right - left + 1 - sameMaxLetter > k){//查看区间大小, 如果区间符合k+最大相同字母数(sameMaxLetter)<len, 就可以收缩左边了
                map[s.charAt(left)-'A'] --;//将窗口中的map[a]给去掉
                left++;
            }
            //每次循环都要无脑右滑动
            //走完这里的时候，其实right会多走一步
            right++;
        }
        //为啥最后要用right - left 而不用sameMaxLetter, right - left只会增大或者缩小,不会负增长
        //因为right多走一步，结果为(right-1)-left+1==right-left
        return right - left;
    }
}