package com.feng.newline.string;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.string
 * @className: L344反转字符串
 * @author: Ladidol
 * @description:
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 s 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 * @date: 2022/7/26 15:33
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

    //优雅的
    class Solution {
        public void reverseString(char[] s) {
            int l = 0;
            int r = s.length - 1;
            while (l < r) {
                s[l] ^= s[r];  //构造 a ^ b 的结果，并放在 a 中
                s[r] ^= s[l];  //将 a ^ b 这一结果再 ^ b ，存入b中，此时 b = a, a = a ^ b
                s[l] ^= s[r];  //a ^ b 的结果再 ^ a ，存入 a 中，此时 b = a, a = b 完成交换
                l++;
                r--;
            }
        }
    }
}
