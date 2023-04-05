package top.dyw.nowcoder.top100;

import java.util.Stack;

/**
 * @author Devil
 * @since 2023-01-30-11:25
 */
@SuppressWarnings("all")
public class BM42用两个栈实现队列 {

    public static void main(String[] args) {
        BM42用两个栈实现队列 test = new BM42用两个栈实现队列();
        test.push(1);
        test.push(2);
        test.push(3);

        System.out.println(test.pop());
        System.out.println(test.pop());
    }

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    /**
     * stack1 负责队列的元素入队 stack2负责队列的元素出队
     * 添加元素时按照栈的特性入栈相当于就是在队列的末尾添加元素 此时将元素push到stack1中 并且将stack1中的元素按照出栈顺序push进stack2中
     * pop时 操作stack2 将栈顶元素pop 并且将pop后的元素同步到stack1中 保证数据的一致性
     */

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        Integer pop = stack2.pop();

        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        return pop;
    }
}
