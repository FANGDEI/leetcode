package com.feng.newline.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: ladidol
 * @date: 2022/10/1 17:51
 * @description: 给你一个字符串形式的电话号码 number 。number 由数字、空格 ' '、和破折号 '-' 组成。
 * <p>
 * 请你按下述方式重新格式化电话号码。
 * <p>
 * 首先，删除 所有的空格和破折号。
 * 其次，将数组从左到右 每 3 个一组 分块，直到 剩下 4 个或更少数字。剩下的数字将按下述规定再分块：
 * 2 个数字：单个含 2 个数字的块。
 * 3 个数字：单个含 3 个数字的块。
 * 4 个数字：两个分别含 2 个数字的块。
 * 最后用破折号将这些块连接起来。注意，重新格式化过程中 不应该 生成仅含 1 个数字的块，并且 最多 生成两个含 2 个数字的块。
 * <p>
 * 返回格式化后的电话号码。
 * <p>
 * 示例 1：
 * <p>
 * 输入：number = "1-23-45 6"
 * 输出："123-456"
 * 解释：数字是 "123456"
 * 步骤 1：共有超过 4 个数字，所以先取 3 个数字分为一组。第 1 个块是 "123" 。
 * 步骤 2：剩下 3 个数字，将它们放入单个含 3 个数字的块。第 2 个块是 "456" 。
 * 连接这些块后得到 "123-456" 。
 * <p>
 * 输入：number = "12"
 * 输出："12"
 * 示例 5：
 * <p>
 * 输入：number = "--17-5 229 35-39475 "
 * 输出："175-229-353-94-75"
 */
public class L1694重新格式化电话号码 {
    // 第一感觉就是，直接分类讨论。
    class Solution {
        /*
         * 参数：[number]
         * 返回值：java.lang.String
         * 作者： ladidol
         * 描述：余数1,2,0
         */
        public String reformatNumber(String number) {
            char[] chars = number.toCharArray();
            List<Character> list = new ArrayList<>();
            for (int i = 0; i < chars.length; i++) {
                if (!Character.isDigit(chars[i])) continue;
                list.add(chars[i]);
            }
            int n = list.size();
            StringBuilder ans = new StringBuilder();
            System.out.println("list = " + list);
            if (n % 3 == 0 || n % 3 == 2) {//整除和余数为二。
                for (int i = 0; i < n; i += 3) {
                    int tmp = 0;
                    while (i + tmp < n && tmp < 3) {
                        ans.append(list.get(i + tmp));
                        tmp++;
                    }
                    if (i + tmp < n)
                        ans.append("-");

                }
            } else if (n % 3 == 1) {
                for (int i = 0; i < n - 4; i += 3) {
                    int tmp = 0;
                    while (i + tmp < n && tmp < 3) {
                        ans.append(list.get(i + tmp));
                        tmp++;
                    }
                    ans.append("-");
                }
                //在拼接最后四个
                ans
                        .append(list.get(n - 4)).append(list.get(n - 3))
                        .append("-")
                        .append(list.get(n - 2)).append(list.get(n - 1));
            }
            return ans.toString();

        }
    }
}