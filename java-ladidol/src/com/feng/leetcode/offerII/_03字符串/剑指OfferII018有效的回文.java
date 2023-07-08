package com.feng.leetcode.offerII._03字符串;

public class 剑指OfferII018有效的回文 {

    class Solution {
        public boolean isPalindrome(String s) {
            s = s.toLowerCase();//需要全部变小
            char[] chars = s.toCharArray();
            int left = 0, right = chars.length - 1;
            while (left < right) {
                char l = chars[left];
                char r = chars[right];
                if (!isRight(l)) {//靠拢
                    left++;
                    continue;
                }
                if (!isRight(r)) {
                    right--;
                    continue;
                }
                if (l != r) {
                    return false;
                }
                left++;
                right--;

            }
            return true;
        }

        boolean isRight(char ch) {
            if ((ch > 'z' || ch < 'a') && (ch < '0' || ch > '9'))
                return false;
            return true;
        }


    }
}
