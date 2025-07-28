package top.dyw.leetcode.simple.arrays;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

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
        System.out.println(new L844比较含退格的字符串().backspaceCompare02("y#fo##f", "y#f#o##f"));
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

    public boolean backspaceCompare01(String s, String t) {
        int sCount = s.length() - 1, tCount= t.length() - 1;
        boolean flag = true;
        int sSkip = 0, tSkip = 0;
        // 循环内已经处理了边界条件了 所以这里需要放开才能得到正确答案
        while (sCount >=0 || tCount >=0){
            while (sCount >= 0) {
                if (s.charAt(sCount)=='#'){
                    sCount--;
                    sSkip++;
                } else if (sSkip != 0){
                    sCount--;
                    sSkip--;
                } else {
                    break;
                }
            }

            while (tCount >= 0) {
                if (t.charAt(tCount) == '#'){
                    tCount--;
                    tSkip++;
                } else if (tSkip != 0){
                    tCount--;
                    tSkip--;
                } else {
                    break;
                }

            }

            if (tCount >= 0 && sCount >= 0){
                if (s.charAt(sCount) != t.charAt(tCount)){
                    flag = false;
                    break;
                }
            } else {
                if (sCount >= 0 || tCount >= 0){
                    flag = false;
                    break;
                }
            }
            sCount--;
            tCount--;
        }
        return flag;
    }

    public boolean backspaceCompare02(String s, String t) {
        Deque<Character> stack1 = new LinkedList<>();
        Deque<Character> stack2 = new LinkedList<>();

        for (int i = 0; i < s.toCharArray().length; i++) {
            if (s.charAt(i) == '#') {
                if (stack1.size() > 0) {
                    stack1.pop();
                }
            } else {
                stack1.push(s.charAt(i));
            }
        }

        for (int i = 0; i < t.toCharArray().length; i++) {
            if (t.charAt(i) == '#') {
                if (stack2.size() > 0){
                    stack2.pop();
                }
            } else {
                stack2.push(t.charAt(i));
            }
        }

        StringBuilder sNew =  new StringBuilder();
        stack1.descendingIterator().forEachRemaining(sNew::append);
        StringBuilder tNew =  new StringBuilder();
        stack2.descendingIterator().forEachRemaining(tNew::append);

        return sNew.toString().equals(tNew.toString());
    }
}
