package com.feng.review.string;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.string
 * @className: L28实现strStr
 * @author: Ladidol
 * @description:
 * @date: 2022/7/26 18:37 2023年3月2日15:23:01 有用到kmp，现在就像不看了。
 * @version: 1.0
 */
public class L28实现strStr {
    class Solution2 {
        public int strStr(String haystack, String needle) {
            return haystack.indexOf(needle);
        }
    }

    class Solution {
        //前缀表（不减一, 也不后移）Java实现
        public int strStr(String haystack, String needle) {

            //用的是kmp，这里就不用了
            return 1;
        }

    }

}
