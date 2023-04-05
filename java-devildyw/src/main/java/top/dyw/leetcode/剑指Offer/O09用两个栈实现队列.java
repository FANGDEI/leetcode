package top.dyw.leetcode.剑指Offer;

import java.util.Iterator;
import java.util.Stack;

/**
 * @author Devil
 * @since 2023-02-28-10:38
 */
@SuppressWarnings("all")
public class O09用两个栈实现队列 {

    class CQueue {

        private final Stack<Integer> stack1;
        private final Stack<Integer> stack2;

        public CQueue() {
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void appendTail(int value) {
            stack1.push(value);
        }

        public int deleteHead() {
            //当出栈不为空时，deleteHead 就一直在stack2中出栈
            if (!stack2.isEmpty()){
                return stack2.pop();
            }else{
                //如果stack2为空了，才将stack1中的元素加入到stack2中 即减少了对两个栈的操作次数又可以避免顺序紊乱的情况
                while (!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
            //最后在判断一次stack2是否空（可能stack1也为空）
            return stack2.isEmpty()?-1:stack2.pop();
        }
    }
}
