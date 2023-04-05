package top.dyw.leetcode.medium.hash;

/**
 * @author Devil
 * @since 2022-12-12-18:09
 */
@SuppressWarnings("all")
public class L1781所有子字符串美丽值之和 {

    public static void main(String[] args) {
        System.out.println(new L1781所有子字符串美丽值之和().beautySum("aabcbaa"));
    }


    /**
     * 暴力 双重for 遍历出所有子串然后计算子串中单词出现最小的和最大次数 最后返回差值
     * @param s
     * @return
     */
    public int beautySum(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] cnt = new int[26];
            int maxFreq = 0;
            for (int j = i; j < s.length(); j++) {
                cnt[s.charAt(j)-'a']++;
                maxFreq = Math.max(maxFreq,cnt[s.charAt(j)-'a']);
                int minFreq = s.length();
                for (int k = 0; k < 26; k++) {
                    if (cnt[k]>0){
                        minFreq = Math.min(minFreq,cnt[k]);
                    }
                }
                res+=maxFreq-minFreq;
            }
        }
        return res;
    }


}
