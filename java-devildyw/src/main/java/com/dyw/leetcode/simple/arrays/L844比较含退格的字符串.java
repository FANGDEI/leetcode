package com.dyw.leetcode.simple.arrays;

/**
 * @author Devil
 * @since 2022-08-29-11:41
 * <p>
 * 给定 s 和 t 两个字符串，当它们分别被输入到空白的文本编辑器后，如果两者相等，返回 true 。# 代表退格字符。
 * <p>
 * 注意：如果对空文本输入退格字符，文本继续为空。
 */
@SuppressWarnings("all")
public class L844比较含退格的字符串 {
    public static void main(String[] args) {

    }

    /**
     * 双指针  倒序遍历 如果遇到退格符则表示前面有元素要被删除
     * <p>
     * <strong>推荐画图理解</strong>
     *
     * @param s
     * @param t
     * @return
     */
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1, j = t.length() - 1;
        //记录两个字符遍历过程中的#退格符
        int skipS = 0, skipT = 0;

        //遍历
        while (i >= 0 || j >= 0) {
            //循环遍历 找到第一个有效字符
            while (i >= 0) {
                //如果遇到# 退格符数量++
                if (s.charAt(i) == '#') {
                    skipS++;
                    i--;
                }//如果不是退格符 但是退格符数量不为0 则需要将该字符忽略 因为退格符
                else if (skipS > 0) {
                    skipS--;//退格符数量减一
                    i--;
                }//既不是退格符 退格符的存有数量也没有大于0 则表示该字符有效 退出该层循环
                else {
                    break;
                }
            }

            //同理
            while (j >= 0) {
                if (t.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }

            //判断 两个有效字符是否相等 不相等就返回false
            if (i >= 0 && j >= 0) {
                if (s.charAt(i) != t.charAt(j)) {
                    return false;
                }
            }//如果其中一个因为走到末尾而跳出循环了 而另一个还找到一个有效字符 那么就返回false
            else {
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }

            j--;
            i--;
        }
        return true;
    }
}
