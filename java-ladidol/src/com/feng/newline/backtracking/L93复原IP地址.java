package com.feng.newline.backtracking;

import java.util.*;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.backtracking
 * @className: L93复原IP地址
 * @author: Ladidol
 * @description: 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 * <p>
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，这些地址可以通过在 s 中插入 '.' 来形成。
 * 你 不能重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案。
 * 示例 1：
 * 输入：s = "25525511135"
 * 输出：["255.255.11.135","255.255.111.35"]
 * 示例 2：
 * 输入：s = "0000"
 * 输出：["0.0.0.0"]
 * 示例 3：
 * 输入：s = "101023"
 * 输出：["1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3"]
 * @date: 2022/8/11 15:07
 * @version: 1.0
 */
public class L93复原IP地址 {

    public static void main(String[] args) {
//        System.out.println(new Solution().restoreIpAddresses("25525511135"));
    }

    class Solution {

        List<String> res = new ArrayList<>();
        StringBuilder cur = new StringBuilder();
        String s;

        public List<String> restoreIpAddresses(String s) {
            this.s = s;
            backtracking(0, 0);
            return res;
        }

        void backtracking(int startIndex, int numCount) {//numCount表示已经分割的个数。
            if (startIndex == s.length() && numCount == 4) {//当分成了四个网段后，且到底了，就是最棒的。
                res.add(new String(cur));
                return;
            }
            if (numCount == 4 || startIndex == s.length()) {//只满足其一都不行
                return;
            }
            for (int i = startIndex; i < s.length() && i - startIndex < 3; i++) {//for循环剪枝
//            if (i - startIndex >= 4) return;//提前结束比赛！
                if (!validNum(startIndex, i)) {//如果条件满足失败
                    return;
                }
                String sub = s.substring(startIndex, i + 1);
//            if (numCount == 0) {
//                cur.append(sub);
//            } else {
//                cur.append(".").append(sub);
//            }
                cur.append(sub);
                if (numCount<3){//采用这种加在尾部的判定方法似乎会更好，上面注释掉的有bug
                    cur.append(".");
                }
                numCount++;
                backtracking(i + 1, numCount);
                numCount--;//回溯
                cur.delete(startIndex + numCount, i + numCount + 2);//删除和截取sub函数一样，前闭后开！！！！
            }
        }
        //段位以0为开头的数字不合法
        //段位里有非正整数字符不合法
        //段位如果大于255了不合法
        boolean validNum(int start, int end) {
            if (start > end) return false;
            if (s.charAt(start) == '0' && start != end) return false;
            int numValue = 0;
            for (int i = start; i <= end; i++) {
                if (s.charAt(i) > '9' || s.charAt(i) < '0') return false;
                numValue = numValue * 10 + (s.charAt(i) - '0');
                if (numValue > 255) return false;
            }
            return true;
        }
    }

}

