package com.feng.newline.array;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.array
 * @className: L715Range模块
 * @author: Ladidol
 * @description:
 * @date: 2022/7/20 17:38
 * @version: 1.0
 */
public class L715Range模块线段树 {


    class RangeModule {

        public RangeModule() {

        }

        //根据题意: 数字是从1开始的.
        public void addRange(int left, int right) {
            update(root,1,N,left,right-1,1);
        }

        public boolean queryRange(int left, int right) {
            return query(root,1,N,left,right-1);
        }

        public void removeRange(int left, int right) {
            update(root, 1, N,left, right-1, -1);
        }

        class Node {
            Node left, right;
            boolean cover;
            int lazy;
        }
        private int N = (int) 1e9;
        private Node root = new Node();
        public void update(Node node, int start, int end, int l, int r, int val) {
            if (l <= start && end <= r) {
                // 1 表示覆盖; -1 表示取消覆盖
                node.cover = val == 1;
                node.lazy = val;
                return ;
            }
            int mid = (start + end) >> 1;
            pushDown(node, mid - start + 1, end - mid);
            if (l <= mid) update(node.left, start, mid, l, r, val);
            if (r > mid) update(node.right, mid + 1, end, l, r, val);
            pushUp(node);
        }
        public boolean query(Node node, int start, int end, int l, int r) {
            if (l <= start && end <= r) return node.cover;
            int mid = (start + end) >> 1;
            boolean ans = true;
            pushDown(node, mid - start + 1, end - mid);
            if (l <= mid) ans = ans && query(node.left, start, mid, l, r);
            if (r > mid) ans = ans && query(node.right, mid + 1, end, l, r);//跨中线的话,左右两边都要覆盖才能true
            return ans;
        }
        private void pushUp(Node node) {
            node.cover = node.left.cover && node.right.cover;//并集
        }
        private void pushDown(Node node, int leftNum, int rightNum) {
            if (node.left == null) node.left = new Node();
            if (node.right == null) node.right = new Node();
            if (node.lazy == 0) return ;
            node.left.cover = node.lazy == 1;
            node.right.cover = node.lazy == 1;
            // 对区间进行「加减」的更新操作，下推懒惰标记时需要累加起来，不能直接覆盖
            node.left.lazy = node.lazy;
            node.right.lazy = node.lazy;
            node.lazy = 0;
        }
    }





}
