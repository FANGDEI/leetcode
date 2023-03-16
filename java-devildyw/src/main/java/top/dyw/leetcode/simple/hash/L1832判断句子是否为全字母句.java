package top.dyw.leetcode.simple.hash;

/**
 * @author Devil
 * @since 2022-12-13-11:09
 */
@SuppressWarnings("all")
public class L1832判断句子是否为全字母句 {

    public static void main(String[] args) {

    }

    public boolean checkIfPangram(String sentence) {
        int[] hash = new int[26];
        for (int i = 0; i < sentence.length(); i++) {
            hash[sentence.charAt(i)-'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (hash[i]==0){
                return false;
            }
        }
        return true;
    }
}
