package com.feng.review.双指针;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.string
 * @className: L344反转字符串
 * @author: Ladidol
 * @description:
 * @date: 2022/7/26 15:33 2023年3月2日14:50:53
 * @version: 1.0
 */
public class L344反转字符串 {

    //简单的双指针
    class Solution1 {
        public void reverseString(char[] s) {
            int left = 0;
            int right = s.length-1;
            while(left<right){
                char ch = s[left];
                s[left++] = s[right];
                s[right--] = ch;
            }
        }
    }
}
