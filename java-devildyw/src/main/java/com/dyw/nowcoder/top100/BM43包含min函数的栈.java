package com.dyw.nowcoder.top100;

import javax.lang.model.element.VariableElement;
import java.util.Stack;

/**
 * @author Devil
 * @since 2023-01-30-11:40
 */
@SuppressWarnings("all")
public class BM43包含min函数的栈 {

    public static void main(String[] args) {

    }

    Stack<Integer> stack1 = new Stack<>();
    //用于存储最小值的栈
    Stack<Integer> stack2 = new Stack<>();

    public void push(int node) {
        stack1.push(node);
        //如果stack2为空或者栈顶元素大于node 则将node入栈
        if (stack2.isEmpty()||stack2.peek()>node){
            stack2.push(node);
        }else{
            //否则重复加入项
            //重复加入项 可以防止栈空的情况 也避免了出栈时多一步判断的情况而且也避免了重复最小值入栈但是只保存一次的情况
            stack2.push(stack2.peek());
        }
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
