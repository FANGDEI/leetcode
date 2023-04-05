package top.dyw.nowcoder.top100;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;


/**
 * @author Devil
 * @since 2023-01-31-11:24
 */
@SuppressWarnings("all")
public class BM45滑动窗口的最大值 {

    public static void main(String[] args) {

    }

    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        if (num.length<size||size==0){
            return result;
        }

        //双向队列
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        //先遍历一个窗口
        for (int i = 0; i < size; i++) {
            //去掉比自己先进栈且小于自己的值
            while (!dq.isEmpty()&&num[dq.peekLast()]<num[i]){
                dq.pollLast();
            }

            dq.offerLast(i);
        }

        //遍历后续数组元素 窗口开始滑动
        for (int i = size; i < num.length; i++) {
            //取窗口内最大值
            result.add(num[dq.peekFirst()]);
            //窗口滑动
            while (!dq.isEmpty()&&dq.peekFirst()<(i-size+1)){ //判断是否有窗口滑动之前的值 有则需要出队
                //弹出窗口移动后的值
                dq.pollFirst();
            }
            //加入新值之前，去掉比自己先进队列且小于自己的值
            while (!dq.isEmpty()&&num[dq.peekLast()]<num[i]){
                dq.pollLast();
            }
            dq.offerLast(i);
        }
        result.add(num[dq.pollFirst()]);
        return result;
    }

}
