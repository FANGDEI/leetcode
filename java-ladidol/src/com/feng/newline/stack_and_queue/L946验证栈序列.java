package com.feng.newline.stack_and_queue;

import java.util.Stack;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.stack_and_queue
 * @className: L946验证栈序列
 * @author: Ladidol
 * @description: 给定pushed和popped两个序列，每个序列中的 值都不重复，只有当它们可能是在最初空栈上进行的推入 push 和弹出 pop 操作序列的结果时，返回 true；否则，返回 false。
 * <p>
 * 示例 1：
 * <p>
 * 输入：pushed = [1,2,3,4,5], popped = [4,5,3,2,1]
 * 输出：true
 * 解释：我们可以按以下顺序执行：
 * push(1), push(2), push(3), push(4), pop() -> 4,
 * push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1
 * 示例 2：
 * <p>
 * 输入：pushed = [1,2,3,4,5], popped = [4,3,5,1,2]
 * 输出：false
 * 解释：1 不能在 2 之前弹出。
 * @date: 2022/8/31 12:57
 * @version: 1.0
 */
public class L946验证栈序列 {
    class Solution {
        // 很简单，一点一点放进去push数组，碰见该弹出来就弹出，不相等就不弹出继续放push。
        public boolean validateStackSequences(int[] pushed, int[] popped) {
            Stack<Integer> stack = new Stack<>();
            for (int i = 0, j = 0; i < pushed.length; i++) {
                stack.push(pushed[i]);
                while (!stack.isEmpty() && stack.peek() == popped[j]) {
                    stack.pop();
                    j++;
                }
            }
            return stack.isEmpty();
        }
    }
}
