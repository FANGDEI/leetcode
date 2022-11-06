package com.feng.newline.string;

/**
 * @author: ladidol
 * @date: 2022/11/6 16:05
 * @description: 请你设计一个可以解释字符串 command 的 Goal 解析器 。command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成。
 * Goal 解析器会将 "G" 解释为字符串 "G"、"()" 解释为字符串 "o" ，"(al)" 解释为字符串 "al" 。然后，按原顺序将经解释得到的字符串连接成一个字符串。
 * 给你字符串 command ，返回 Goal 解析器 对 command 的解释结果。
 * 示例 1：
 * <p>
 * 输入：command = "G()(al)"
 * 输出："Goal"
 * 解释：Goal 解析器解释命令的步骤如下所示：
 * G -> G
 * () -> o
 * (al) -> al
 * 最后连接得到的结果是 "Goal"
 * 示例 2：
 * <p>
 * 输入：command = "G()()()()(al)"
 * 输出："Gooooal"
 * 示例 3：
 * <p>
 * 输入：command = "(al)G(al)()()G"
 * 输出："alGalooG"
 * 提示：
 * <p>
 * 1 <= command.length <= 100
 * command 由 "G"、"()" 和/或 "(al)" 按某种顺序组成
 */
public class L1678设计Goal解析器 {

    //简单的字符串遍历。
    class Solution {
        public String interpret(String command) {
            int n = command.length();
            StringBuilder ans = new StringBuilder();
            for (int i = 0; i < n; i++) {
                if (command.charAt(i) == 'G') ans.append('G');
                else if (command.charAt(i) == '(' && command.charAt(i + 1) == ')') ans.append('o');
                else if (command.charAt(i) == '(' && command.charAt(i + 1) != ')') {
                    ans.append("al");
                    i += 2;
                }
            }
            return ans.toString();
        }
    }
}