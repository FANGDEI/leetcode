package com.feng.newline.array;


import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.array
 * @className: L933最近的请求次数
 * @author: Ladidol
 * @description: 写一个 RecentCounter 类来计算特定时间范围内最近的请求。
 * <p>
 * 请你实现 RecentCounter 类：
 * <p>
 * RecentCounter() 初始化计数器，请求数为 0 。
 * int ping(int t) 在时间 t 添加一个新请求，其中 t 表示以毫秒为单位的某个时间，并返回过去 3000 毫秒内发生的所有请求数（包括新请求）。确切地说，返回在 [t-3000, t] 内发生的请求数。
 * 保证 每次对 ping 的调用都使用比之前更大的 t 值。
 * <p>
 * 输入：
 * ["RecentCounter", "ping", "ping", "ping", "ping"]
 * [[], [1], [100], [3001], [3002]]
 * 输出：
 * [null, 1, 2, 3, 3]
 * <p>
 * 解释：
 * RecentCounter recentCounter = new RecentCounter();
 * recentCounter.ping(1);     // requests = [1]，范围是 [-2999,1]，返回 1
 * recentCounter.ping(100);   // requests = [1, 100]，范围是 [-2900,100]，返回 2
 * recentCounter.ping(3001);  // requests = [1, 100, 3001]，范围是 [1,3001]，返回 3
 * recentCounter.ping(3002);  // requests = [1, 100, 3001, 3002]，范围是 [2,3002]，返回 3
 * @date: 2022/7/22 16:20
 * @version: 1.0
 */
public class L933最近的请求次数 {


    //队列模拟
    class RecentCounter {
        private Deque<Integer> deque;

        //有题意可知：保证 每次对 ping 的调用都使用比之前更大的 t 值。
        //可以直接删除查询过得
        public RecentCounter() {
            deque = new ArrayDeque<>();
        }

        public int ping(int t) {
            int past = t - 3000;
            deque.add(t);
            while(deque.getFirst()<past){
                deque.removeFirst();
            }
            return deque.size();
        }
    }



    //线段树
    class RecentCounter2 {

        public RecentCounter2() {

        }

        public int ping(int t) {
            update(root,-2999,N,t,t,1);
            return query(root, -2999, N, t - 3000, t);
        }


        class Node {
            Node left, right;
            int val, lazy;//都可以随机应变
        }

        private int N = (int) 1e9;//这里也是哦
        private Node root = new Node();

        public void update(Node node, int start, int end, int l, int r, int val) {
            if (l <= start && end <= r) {
                node.val += (end - start + 1) * val;//这里逻辑根据题意改变
                node.lazy += val;//这里也是
                return;
            }
            int mid = (start + end) >> 1;
            pushDown(node, mid - start + 1, end - mid);
            if (l <= mid) update(node.left, start, mid, l, r, val);
            if (r > mid) update(node.right, mid + 1, end, l, r, val);
            pushUp(node);
        }

        public int query(Node node, int start, int end, int l, int r) {
            if (l <= start && end <= r) return node.val;
            int mid = (start + end) >> 1, ans = 0;
            pushDown(node, mid - start + 1, end - mid);
            if (l <= mid) ans += query(node.left, start, mid, l, r);
            if (r > mid) ans += query(node.right, mid + 1, end, l, r);
            return ans;
        }

        private void pushUp(Node node) {
            node.val = node.left.val + node.right.val;
        }

        private void pushDown(Node node, int leftNum, int rightNum) {
            if (node.left == null) node.left = new Node();
            if (node.right == null) node.right = new Node();
            if (node.lazy == 0) return;
            node.left.val += node.lazy * leftNum;
            node.right.val += node.lazy * rightNum;
            // 对区间进行「加减」的更新操作，下推懒惰标记时需要累加起来，不能直接覆盖
            node.left.lazy += node.lazy;
            node.right.lazy += node.lazy;
            node.lazy = 0;
        }
    }
}
