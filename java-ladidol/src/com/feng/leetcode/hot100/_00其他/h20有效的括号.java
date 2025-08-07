/*
 * Copyright (c) 2025. 贝壳找房（北京）科技有限公司
 */
package com.feng.leetcode.hot100._00其他;

import java.util.Stack;

/**
 *
 * @author fengxiaoqiang
 * @since 2025/8/7 11:13
 */
public class h20有效的括号 {


  static class Solution {

    public boolean isValid(String s) {
      Stack<Character> stack = new Stack<>();
      // 栈里面只存左边括号，把一类括号符号统一，方便消除
      for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
        if (c == '(') stack.push(')');
        else if (c == '[') stack.push(']');
        else if (c == '{') stack.push('}');
        else if (stack.isEmpty()) {
          // 以右括号开始的，就有问题
          return false;
        }
        else {
          // 右括号，就需要和弹出栈顶比较
          char peek = stack.pop();
          if (peek!=c) return false;
        }

      }
      return stack.isEmpty();
    }
  }

  public static void main(String[] args) {
    Solution solution = new Solution();
    solution.isValid("()");
  }


}
