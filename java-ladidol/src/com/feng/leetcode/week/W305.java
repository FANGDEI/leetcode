package com.feng.leetcode.week;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @projectName: leetcode
 * @package: com.feng.leetcode.week
 * @className: W305
 * @author: Ladidol
 * @description:
 * @date: 2022/8/7 11:02
 * @version: 1.0
 */
public class W305 {

    class 算术三元组的数目 {
        public int arithmeticTriplets(int[] nums, int diff) {
            Map<Integer, Integer> map = new HashMap<>();
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                map.put(nums[i], i);
            }
            for (int i = 0; i < nums.length - 2; i++) {
                if (map.containsKey(nums[i] + diff) && map.containsKey(nums[i] + diff + diff)) {
                    count++;
                }
            }
            return count;
        }
    }

    //输入：s = "acfgbd", k = 2
    //输出：4
    //解释：最长理想字符串是 "acbd" 。该字符串长度为 4 ，所以返回 4 。
    //注意 "acfgbd" 不是理想字符串，因为 'c' 和 'f' 的字母表位次差值为 3 。
    public static void main(String[] args) {
//        System.out.println(" = " + new Solution().longestIdealString("eduktdb" , 15));
    }
    //"eduktdb" , 15 ======》"edkdb";
//sb = edkt
//sb = dkt
//sb = ukt
//sb = kt
//sb = t
//sb = db
// = 4
//有个坑就是这里，前面相同，中间有分叉的情况，
//class Solution {
//    public int longestIdealString(String s, int k) {
//        int maxSize = 0;
//        char[] chars = s.toCharArray();
//        for (int i = 0; i < chars.length - 1; i++) {
//            char temp = chars[i];
//            int count = 1;
//            for (int j = i + 1; j < chars.length; j++) {
//                if (Math.abs(chars[j] - temp) > k) continue;
//                temp = chars[j];
//                count++;
//            }
//            maxSize = Math.max(maxSize, count);
//        }
//        return maxSize;
//    }
//}


}
