class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        // 我理解在p的长度 就是我们滑动窗口的长度 在这个窗口内不断用字母异位词来判断就行
        if (p.length() == 0) {
            return new ArrayList<Integer>();
        }

        int start = 0;
        int windowSize = p.length();
        List<Integer> result = new ArrayList();
        int[] pHash = new int[26];
        int[] sHash = new int[26];
        for(int i = 0; i<p.length(); i++) {
            pHash[p.charAt(i)-'a']++;
        }

        for(int i=0; i<s.length(); i++) {
            sHash[s.charAt(i)-'a']++;
            while ((i-start+1) >= windowSize) {
                if (findAnagramsHelper(sHash, pHash)) {
                    result.add(start);
                }
                sHash[s.charAt(start)-'a']--;
                start++;

            }
        }

        return result;
    }

    public boolean findAnagramsHelper(int[] sHash, int[] pHash) {
        for(int i=0; i<26; i++) {
            if (sHash[i] != pHash[i]) {
                return false;
            }
        }

        return true;
    }
}