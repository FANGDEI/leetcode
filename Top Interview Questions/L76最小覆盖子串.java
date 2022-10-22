import java.util.HashMap;

public class L76最小覆盖子串 {
    class Solution {
        public String minWindow(String s, String t) {
            HashMap<Character, Integer> hs = new HashMap<Character, Integer>();
            HashMap<Character, Integer> ht = new HashMap<Character, Integer>();
            for (int i = 0; i < t.length(); i++) {
                ht.put(t.charAt(i), ht.getOrDefault(t.charAt(i), 0) + 1);
            }
            String ans = "";
            int len = 0x3f3f3f3f, cnt = 0;  //有多少个元素符合
            for (int i = 0, j = 0; i < s.length(); i++) {
                hs.put(s.charAt(i), hs.getOrDefault(s.charAt(i), 0) + 1);
                if (ht.containsKey(s.charAt(i)) && hs.get(s.charAt(i)) <= ht.get(s.charAt(i))) cnt++;
                while (j < i && (!ht.containsKey(s.charAt(j)) || hs.get(s.charAt(j)) > ht.get(s.charAt(j)))) {
                    int count = hs.get(s.charAt(j)) - 1;
                    hs.put(s.charAt(j), count);
                    j++;
                }
                if (cnt == t.length() && i - j + 1 < len) {
                    len = i - j + 1;
                    ans = s.substring(j, i + 1);
                }
            }
            return ans;
        }
    }

}
