package top.dyw.leetcode.medium.stack;

/**
 * 只有满足下面几点之一，括号字符串才是有效的：
 * <p>
 * 它是一个空字符串，或者
 * 它可以被写成AB（A与B连接）, 其中A 和B都是有效字符串，或者
 * 它可以被写作(A)，其中A是有效字符串。
 * 给定一个括号字符串 s ，移动N次，你就可以在字符串的任何位置插入一个括号。
 * <p>
 * 例如，如果 s = "()))" ，你可以插入一个开始括号为 "(()))" 或结束括号为 "())))" 。
 * 返回 为使结果字符串 s 有效而必须添加的最少括号数。
 *
 * @author Devil
 * @since 2022-10-04-11:31
 */
@SuppressWarnings("all")
public class L921使括号有效的最少添加 {

    public static void main(String[] args) {

    }

    public int minAddToMakeValid(String s) {
        int ans = 0;
        int leftCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                leftCount++;
            } else {
                /**
                 * 如果左括号的个数大于 0，则前面有左括号可以匹配，因此将左括号的个数减 1，表示有一个左括号和当前右括号匹配；
                 *
                 * 如果左括号的个数等于 0，则前面没有左括号可以匹配，需要添加一个左括号才能匹配，因此将添加次数加 1。
                 */
                if (leftCount > 0) {
                    leftCount--;
                } else {
                    ans++;
                }
            }
        }
        ans += leftCount;
        return ans;
    }

}
