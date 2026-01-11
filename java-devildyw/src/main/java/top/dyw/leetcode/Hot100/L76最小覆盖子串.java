package top.dyw.leetcode.Hot100;

import java.util.HashMap;

// 忘了又忘 哎
public class L76最小覆盖子串 {
    public String minWindow(String s, String t) {
        HashMap<Character,Integer> sHash = new HashMap();
        HashMap<Character,Integer> tHash = new HashMap();
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        int matchCount = 0;
        for(int i = 0; i<tChars.length; i++) {
            tHash.put(tChars[i], tHash.getOrDefault(tChars[i], 0) + 1);
        }

        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int start = -1;
        for(int i=0; i<sChars.length; i++) {
            if (tHash.containsKey(sChars[i])){
                sHash.put(sChars[i], sHash.getOrDefault(sChars[i], 0) + 1);
                if (sHash.get(sChars[i]).equals(tHash.get(sChars[i]))) {
                    matchCount++;
                }
            }
            // 当所有字符都满足了 尝试收缩边界
            while (matchCount==tHash.size()) {
                if (i-left+1 < minLen) {
                    start = left;
                    minLen = i-left +1;
                }

                if (tHash.containsKey(sChars[left])) {
                    if (sHash.get(sChars[left]).equals(tHash.get(sChars[left]))) {
                        matchCount--;
                    }
                    sHash.put(sChars[left], sHash.get(sChars[left])-1);
                }
                left++;
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(start, start+minLen);
    }
}
