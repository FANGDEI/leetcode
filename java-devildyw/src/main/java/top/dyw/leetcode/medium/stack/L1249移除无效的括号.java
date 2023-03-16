package top.dyw.leetcode.medium.stack;

import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * @author Devil
 * @since 2022-08-09-11:51
 * <p>
 * 给你一个由 '('、')' 和小写字母组成的字符串 s。
 * <p>
 * 你需要从字符串中删除最少数目的 '(' 或者 ')'（可以删除任意位置的括号)，使得剩下的「括号字符串」有效。
 * <p>
 * 请返回任意一个合法字符串。
 * <p>
 * 有效「括号字符串」应当符合以下任意一条要求：
 * <p>
 * 空字符串或只包含小写字母的字符串
 * 可以被写作AB（A连接B）的字符串，其中A和B都是有效「括号字符串」
 * 可以被写作(A)的字符串，其中A是一个有效的「括号字符串」
 */
@SuppressWarnings("all")
public class L1249移除无效的括号 {
    public static void main(String[] args) {
        System.out.println(new L1249移除无效的括号().minRemoveToMakeValid("))(("));
    }

    /**
     * 使用辅助栈记录不匹配的括号的下标
     *
     * 从前往后遍历,栈中存储'('只 遇到')' 检查栈空 不为空就出栈(两个栈一起出) 为空则将下标记录到辅助栈中
     *
     * 到最后只会留下不匹配的括号 而辅助栈则会记录这些不匹配的栈的索引
     *
     */
    public String minRemoveToMakeValid(String s) {
        StringBuffer sb = new StringBuffer();
        Deque<Character> stack = new LinkedList<>();
        Deque<Integer> indexStack = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                //遇到'('直接添加到栈中
                stack.push(c);
                indexStack.push(i);
            } else if (c == ')') {
                //遇到')' 判断栈是否为空 如果不为空代表里面有'(' 所以栈pop 且辅助栈也pop
                if (!stack.isEmpty()) {
                    stack.pop();
                    indexStack.pop();
                } else {
                    //如果栈已经为空 那么就当前索引就是不匹配的括号 将其索引添加进辅助栈中
                    indexStack.push(i);
                }
            }
        }
        //对于"))(("这样的字符串 前两个字符是')'因为栈中为空所以辅助栈中所以算作多余括号 而元素栈中不会存储')' 所以后面遇到'('会直接添加到元素栈和辅助栈中 因为后续没有元素了 所以最后辅助栈就是整个字符串中每个字符的索引

        HashSet<Integer> set = new HashSet<>();
        while (!indexStack.isEmpty()){
            set.add(indexStack.pop());
        }
        for (int i = 0; i < s.length(); i++) {
            if (!set.contains(i)){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
