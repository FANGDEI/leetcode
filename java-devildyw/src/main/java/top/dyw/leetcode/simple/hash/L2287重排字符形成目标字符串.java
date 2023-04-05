package top.dyw.leetcode.simple.hash;

/**
 * @author Devil
 * @since 2023-01-13-13:38
 */
@SuppressWarnings("all")
public class L2287重排字符形成目标字符串 {

    public static void main(String[] args) {

    }

    public int rearrangeCharacters(String s, String target) {
        int[] hash = new int[26];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            hash[s.charAt(i)-'a']++;
        }

        while (true){
            for (int i = 0; i < target.length(); i++) {
                if (hash[target.charAt(i)-'a']>0){
                    hash[target.charAt(i)-'a']--;
                }else{
                    return count;
                }
            }
            count++;
        }
    }
}
