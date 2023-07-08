package com.feng.leetcode.offerII._03字符串;

public class 剑指OfferII017含有所有字符的最短字符串_没做 {

//    public static void main(String[] args) {
//        new Solution().minWindow("ADOBECODEBANC","ABC");
//    }



    //左边界收缩错误
//    static class Solution {
//
//        public String minWindow(String s, String t) {
//            //找到下标，然后进行数组截取。
//            int[] targets = new int['z' - 'A' + 1];//有大小写
//            int[] map = new int['z' - 'A' + 1];
//            int begin = -1, end = -1;
//
//            //初始化targets
//            for (int i = 0; i < t.length(); i++) {
//                targets[t.charAt(i) - 'A']++;
//            }
//
//            System.out.println("targets = " + Arrays.toString(targets));
//
//
//            int left = 0, right = 0;
//            int n = s.length();
//            int minLen = 0;
//            while (right < n) {
//                map[s.charAt(right) - 'A']++;
//
//                System.out.println("map = " + Arrays.toString(map));
//
//                if (Arrays.equals(targets, map)) {
//
//                    if ((right - left) < minLen) {
//                        begin = left;
//                        end = right;
//                        minLen = end - begin;
//                    }
//                }
//                while (right < n && map[s.charAt(right) - 'A'] > targets[s.charAt(right) - 'A']) {
//                    map[s.charAt(left) - 'A']--;
//                    left++;
//                }
//                right++;
//            }
//            return begin == -1 ? "" : new String(s.toCharArray(), begin, end - begin);
//        }
//    }


}
