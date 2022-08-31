package com.feng.newline.string;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.string
 * @className: L1736替换隐藏数字得到的最晚时间
 * @author: Ladidol
 * @description: 给你一个字符串 time ，格式为 hh:mm（小时：分钟），其中某几位数字被隐藏（用 ? 表示）。
 * 有效的时间为 00:00 到 23:59 之间的所有时间，包括 00:00 和 23:59 。
 * 替换time 中隐藏的数字，返回你可以得到的最晚有效时间。
 * 示例 1：
 * <p>
 * 输入：time = "2?:?0"
 * 输出："23:50"
 * 解释：以数字 '2' 开头的最晚一小时是 23 ，以 '0' 结尾的最晚一分钟是 50 。
 * 示例 2：
 * <p>
 * 输入：time = "0?:3?"
 * 输出："09:39"
 * 示例 3：
 * <p>
 * 输入：time = "1?:22"
 * 输出："19:22"
 * @date: 2022/8/31 16:29
 * @version: 1.0
 */
public class L1736替换隐藏数字得到的最晚时间 {
    class Solution {
        public String maximumTime(String time) {
            char[] times = new char[4];
            for (int i = 0; i < 4; i++) {
                times[i] = time.charAt(i < 2 ? i : i + 1);//巧妙的跳过了冒号
            }
            for (int i = 0; i < 4; i++) {//由于第0位和第1位有一点牵连的的关系，我们来操作。
                if (times[i]=='?'){//是问号才走这条路
                    switch (i) {
                        case 0: times[0] = (times[1] > '3' && times[1] <= '9') ? '1' : '2'; break;//如果如果个位是‘？’或者比‘3’的，就取视为最大数‘2’
                        case 1: times[1] = times[0] == '2' ? '3' : '9'; break;
                        case 2: times[2] = '5'; break;
                        case 3: times[3] = '9'; break;
                    }
                }
            }
            StringBuilder res = new StringBuilder();
            for (int i = 0; i < 4; i++) {
                if (i == 2){
                    res.append(":");
                }
                res.append(times[i]);
            }
            return res.toString();
        }
    }
}
