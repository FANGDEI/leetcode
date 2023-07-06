package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/07/06 10:38
 **/
public class OII032有效的变位词 {

    public static void main(String[] args) {

    }

    public boolean isAnagram(String s, String t) {
        if (s.equals(t)){
            return false;
        }

        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c-'a']++;
        }

        for (char c : t.toCharArray()) {
            count[c-'a']--;
        }

        for (int i : count) {
            if (i!=0){
                return false;
            }
        }
        return true;
    }

}
