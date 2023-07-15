package top.dyw.leetcode.剑指Offer;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Stack;

/**
 * @author Devildyw
 * @date 2023/07/13 11:25
 **/
@SuppressWarnings("all")
public class OII037小行星碰撞 {

    public static void main(String[] args) {

    }

    /**
     * 栈模拟
     * @param asteroids
     * @return
     */
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (int asteroid : asteroids) {
            boolean alive = true; //记录asteroid在碰撞后是否存在
            while (alive&&asteroid<0&&!stack.isEmpty()&&stack.peek()>0){ //这里只模拟当前元素向右，栈内元素向左的情况 反之也可 总之要确定一个方向
                alive = stack.peek() < -asteroid; //判断asteroid是否存在
                if (stack.peek()<=-asteroid){
                    stack.pop();
                }
            }
            if (alive){ //存在则将其入栈
                stack.push(asteroid);
            }
        }

        int size = stack.size();
        int[] ans = new int[size];

        for (int i = size - 1; i>=0; i--){
            ans[i] = stack.pop();
        }
        return ans;

    }
}
