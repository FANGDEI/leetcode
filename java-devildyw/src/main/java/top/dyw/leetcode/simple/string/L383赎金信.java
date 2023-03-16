package top.dyw.leetcode.simple.string;

/**
 * @author Devil
 * @since 2022-07-16-10:12
 * <p>
 * 给你两个字符串：ransomNote 和 magazine ，判断 ransomNote 能不能由 magazine 里面的字符构成。
 * <p>
 * 如果可以，返回 true ；否则返回 false 。
 * <p>
 * magazine 中的每个字符只能在 ransomNote 中使用一次。
 */
@SuppressWarnings("all")
public class L383赎金信 {
    public static void main(String[] args) {
        boolean b = new L383赎金信().canConstruct("aa", "aab");
    }

    public boolean canConstruct(String ransomNote, String magazine) {
        int[] res = new int[26];
        for (int i = 0; i < ransomNote.length(); i++) {
            res[ransomNote.charAt(i) - 'a']++;
        }
        for (int i = 0; i < magazine.length(); i++) {
            int index = magazine.charAt(i) - 'a';
            if (res[index] != 0) {
                res[index]--;
            }
        }
        for (int re : res) {
            if (re > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 官方题解
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct01(String ransomNote, String magazine) {
        //如果ransomNote的长度大于magazine那就永远成功构成
        if (ransomNote.length() != magazine.length()) {
            return false;
        }
        int[] cnt = new int[26];
        //先将magazine的字符出现次数存入cnt中
        for (int i = 0; i < magazine.length(); i++) {
            cnt[magazine.charAt(i) - 'a']++;
        }
        //再遍历ransomNote 出现过同样的单词就将对应数组中字符出现次数减一
        for (int i = 0; i < ransomNote.length(); i++) {
            cnt[ransomNote.charAt(i) - 'a']--;
            //如果出现对应数组位置出现次数小于0了 代表ransomNote该字符出现的次数大于magazine
            if (cnt[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
