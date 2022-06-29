package com.dyw.leetcode.simple.string;

/**
 * @author Devil
 * @since 2022-06-29-11:56
 * <p>
 * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
 */
@SuppressWarnings("all")
public class L459重复的子字符串 {
    public static void main(String[] args) {
        System.out.println(new L459重复的子字符串().repeatedSubstringPattern("ababab"));
    }

    /**
     * 简单方法 通过规律发现如果一个字符串包括重复的子字符串 那么将这个字符串重复拼接 去掉头和尾后 一定包含该字符串本身
     *
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {
        String str = s + s;
        return str.substring(1, str.length() - 2).contains(s);
    }

    /**
     * <img src="https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/image-20220629122502976.png" alt="题解">
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern01(String s) {
        int n = s.length();

        for (int i = 1; i*2 <= n; i++) {
            //因为n是n'的n倍 这里通过n%i通过倍数关系判断 找到子串
            if (n%i==0){
                boolean match = true;
                for (int j = i; j < n; j++) {
                    //比较字符从两段子串的相同位置比较
                    if (s.charAt(j)!=s.charAt(j-i)){
                        //不相等就跳出该层循环.说明该字串不是整个字符串的重复子串 则寻找下一个子串
                        match = false;
                        break;
                    }
                }
                //如果满足就返回true
                if (match){
                    return true;
                }
            }
        }
        //如果上述循环都没有找到一个满足条件的子串那么就返回false
        return false;
    }
}
