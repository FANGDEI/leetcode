package top.dyw.leetcode.Hot100;

import java.util.*;
public class L394字符串解码 {
    public String decodeString(String s) {
        Deque<StringBuilder> strStack = new ArrayDeque<>();
        Deque<Integer> numStack = new ArrayDeque<>();
        int k =0;
        StringBuilder cur = new StringBuilder();
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <= '9') {
                k = k*10 + (c-'0');
            } else if (c == '[') {
                strStack.push(cur);
                numStack.push(k);

                cur = new StringBuilder();
                k = 0;
            } else if (c==']') {
                StringBuilder prev = strStack.pop();
                int repeatCount = numStack.pop();
                while (repeatCount-->0) {
                    prev.append(cur);
                }
                cur = prev;
            } else {
                cur.append(c);
            }
        }
        return cur.toString();
    }
}
