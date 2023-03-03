package com.feng.review.stack_queue;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.stack_and_queue
 * @className: L1047删除字符串中的所有相邻重复项
 * @author: Ladidol
 * @description: 给出由小写字母组成的字符串 S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * <p>
 * 示例：
 * <p>
 * 输入："abbaca"
 * 输出："ca"
 * 解释：例如，在 "abbaca" 中，我们可以删除 "bb" 由于两字母相邻且相同，这是此时唯一可以执行删除操作的重复项。
 * 之后我们得到字符串 "aaca"，其中又只有 "aa" 可以执行重复项删除操作，所以最后的字符串为 "ca"。
 * 提示：
 * <p>
 * 1 <= S.length <= 20000
 * S 仅由小写英文字母组成。
 * @date: 2022/7/27 22:16 2023年3月3日10:47:04
 * @version: 1.0
 */
public class L1047删除字符串中的所有相邻重复项 {

    public static void main(String[] args) {
//        System.out.println(new Solution().removeDuplicates("abbaca"));
    }

    class Solution {
        public String removeDuplicates(String s) {
//            Stack<Character> stack = new Stack<>();
            Deque<Character> stack = new LinkedList<>();
            for (char ch : s.toCharArray()) {
                //主要都可以看作每次循环最多只进行一次抵消.
                if (!stack.isEmpty()&&stack.peek() == ch){
                    stack.pop();
                }else {
                    stack.push(ch);
                }
            }
            StringBuilder str = new StringBuilder();//用StringBuilder拼接的时候会快一些.
            int n = stack.size();
            for (int i = 0; i < n; i++) {
                str.insert(0, stack.pop());//在原来字符串前面添加弹出来的元素.
            }
            return str.toString();
        }
    }

}


