package com.feng.newline.string;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.string
 * @className: L640求解方程
 * @author: Ladidol
 * @description: 求解一个给定的方程，将x以字符串 "x=#value" 的形式返回。该方程仅包含 '+' ， '-' 操作，变量 x 和其对应系数。
 * 如果方程没有解，请返回 "No solution" 。如果方程有无限解，则返回 “Infinite solutions” 。
 * 题目保证，如果方程中只有一个解，则 'x' 的值是一个整数。
 *  
 * 示例 1：
 * 输入: equation = "x+5-3+x=6+x-2"
 * 输出: "x=2"
 * 示例 2:
 * 输入: equation = "x=x"
 * 输出: "Infinite solutions"
 * 示例 3:
 * 输入: equation = "2x=x"
 * 输出: "x=0"
 * @date: 2022/8/10 22:25
 * @version: 1.0
 */
public class L640求解方程 {
    //先用一下京城打工仔的题解。
    class Solution {
        //存放x的个数
        private int xSum;
        //存放值
        private int valSum;

        public String solveEquation(String equation) {
            //按照等号分割
            String[] str = equation.split("=");
            //解析左边表达式
            parseString(str[0], 1);
            //解析右边表达式
            parseString(str[1], -1);
            if (xSum == 0) {
                return valSum == 0 ? "Infinite solutions" : "No solution";
            } else {
                return "x=" + (-valSum / xSum);
            }
        }

        /**
         * 解析表达式
         *
         * @param equation 表达式
         * @param sign     符号 左边表达式为1 右边表达式为-1
         */
        public void parseString(String equation, int sign) {
            int i = 0, curSign = 1;
            while (i < equation.length()) {
                char c = equation.charAt(i);
                //分类讨论
                if (c == 'x') {
                    if (sign * curSign == 1) {
                        xSum++;
                    } else {
                        xSum--;
                    }
                    i++;
                } else if (c == '-' || c == '+') {
                    curSign = c == '-' ? -1 : 1;
                    i++;
                } else {
                    //数字
                    int num = 0;
                    while (i < equation.length() && Character.isDigit(equation.charAt(i))) {
                        num = num * 10 + equation.charAt(i) - '0';
                        i++;
                    }
                    num = num * sign * curSign;
                    //数字后边跟的是不是x
                    if (i < equation.length() && equation.charAt(i) == 'x') {
                        xSum += num;
                        i++;
                    } else {
                        valSum += num;
                    }
                }
            }
        }
    }
}
