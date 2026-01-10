class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        Set<Character> set = new HashSet();
        int result = 0;

        for (int i = 0; i<s.length(); i++) {
            while(set.contains(s.charAt(i))) {
                set.remove(s.charAt(start));
                start++;
            }
            set.add(s.charAt(i));
            result = Math.max(result, i-start+1);
        }

        return result;
    }
}