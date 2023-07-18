package top.dyw.leetcode.剑指Offer;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author Devildyw
 * @date 2023/07/18 10:50
 **/
@SuppressWarnings("all")
public class OII042最近请求次数 {
    public static void main(String[] args) {

    }

    class RecentCounter {
        Deque<Integer> queue;

        public RecentCounter() {
            queue = new ArrayDeque<>();
        }

        public int ping(int t) {
            while (!queue.isEmpty()&&t-queue.peekFirst()>3000){
                queue.poll();
            }
            queue.offer(t);
            return queue.size();
        }
    }

}
