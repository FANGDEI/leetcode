package top.dyw.leetcode.hard.string;

/**
 * @author dingyangwei001
 * @description 描述
 * @date 2025/03/13 09:55
 **/
@SuppressWarnings("all")
public class L76最小覆盖子串 {

    public static void main(String[] args) {
        System.out.println(new L76最小覆盖子串().minWindow("ADOBECODEBANC", "ABC"));
    }

    public String minWindow(String s, String t) {
        int ansLeft = -1, ansRight = s.length();
        int left = 0;
        int[] tCount = new int[128];
        int[] sCount = new int[128];

        for (char c : t.toCharArray()) {
            tCount[c]++;
        }

        for (int right = 0; right < s.length(); right++) {
            sCount[s.charAt(right)]++;
            while (checkStr(sCount, tCount)) {
                if (right - left < ansRight - ansLeft){
                    ansLeft = left;
                    ansRight = right;
                }
                sCount[s.charAt(left)]--;
                left++;
            }
        }
        return ansLeft < 0 ? "" : s.substring(ansLeft, ansRight + 1);

    }

    private boolean checkStr(int[] s, int[] t) {

        for (int i = 'A'; i <= 'Z'; i++) {
            if (t[i] > s[i]){
                return false;
            }
        }

        for (int i = 'a'; i <= 'z'; i++) {
            if (t[i] > s[i]){
                return false;
            }
        }

        return true;
    }
}
