package com.feng.newline.array;

import com.feng.draft.SegmentTreeDynamic;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.array
 * @className: L307区域和检索_数组可修改
 * @author: Ladidol
 * @description:
 * 示例 1：
 *
 * 输入：
 * ["NumArray", "sumRange", "update", "sumRange"]
 * [[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
 * 输出：
 * [null, 9, null, 8]
 *
 * 解释：
 * NumArray numArray = new NumArray([1, 3, 5]);
 * numArray.sumRange(0, 2); // 返回 1 + 3 + 5 = 9
 * numArray.update(1, 2);   // nums = [1,2,5]
 * numArray.sumRange(0, 2); // 返回 1 + 2 + 5 = 8
 *
 * @date: 2022/7/21 21:44
 * @version: 1.0
 */
public class L307区域和检索_数组可修改 {

    //方法一：动态开点
    class NumArray1 {

        //提示数组的长度是固定的.
        public NumArray1(int[] nums) {
            N = nums.length;
            for (int i = 0; i < N; i++) {
                update(root,0,N,i,i,nums[i]);//动态建表只能同时加入一样的值,所以变范围为一个点.
            }
        }

        public void update(int index, int val) {
            update(root,0,N,index,index,val);//变范围为一个点.
        }

        public int sumRange(int left, int right) {
            return query(root,0,N,left,right);//查询范围内的和.
        }

        /*模板*/



        class Node {
            Node left, right;
            int val, lazy;
        }

        private int N;
        private Node root = new Node();
        public void update(Node node, int start, int end, int l, int r, int val) {
            if (l <= start && end <= r) {
                node.val = (end - start + 1) * val;//区间和.
                node.lazy = val;//2022/7/21 为啥这里是等号而不是加号.本题中是对值的改变,不是在原有值上面增加或者减少.
                return ;
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
            if (node.lazy == 0) return ;
            node.left.val = node.lazy * leftNum;
            node.right.val = node.lazy * rightNum;
            // 对区间进行「加减」的更新操作，下推懒惰标记时需要累加起来，不能直接覆盖
            node.left.lazy = node.lazy;
            node.right.lazy = node.lazy;
            node.lazy = 0;
        }

    }

    //方法二：静态开点
    class NumArray {

        int[] nums;

        //提示数组的长度是固定的.
        public NumArray(int[] nums) {
            this.nums = nums;
            buildTree(root,0,nums.length-1,nums);
        }

        public void update(int index, int val) {
            update(root,0,nums.length-1,index,index,val);
        }

        public int sumRange(int left, int right) {
            return query(root,0,nums.length-1,left,right);
        }

        /*模板*/



        class Node {
            Node left, right;
            int val, lazy;//都可以随机应变
        }

        private Node root = new Node();

        public void buildTree(Node node, int start, int end, int[] nums) {
            // 到达叶子节点
            if (start == end) {
                node.val = nums[start];
                return;
            }
            int mid = (start + end) >> 1;
            if (node.left==null) node.left = new Node();
            if (node.right==null) node.right = new Node();
            buildTree(node.left, start, mid, nums);
            buildTree(node.right, mid + 1, end, nums);
            // 向上更新
            pushUp(node);
        }

        public void update(Node node, int start, int end, int l, int r, int val) {
            if (l <= start && end <= r) {
                node.val = (end - start + 1) * val;//这里逻辑根据题意改变
                node.lazy = val;//这里也是
                return ;
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
            if (node.lazy == 0) return ;
            node.left.val = node.lazy * leftNum;
            node.right.val = node.lazy * rightNum;
            // 对区间进行「加减」的更新操作，下推懒惰标记时需要累加起来，不能直接覆盖
            node.left.lazy = node.lazy;
            node.right.lazy = node.lazy;
            node.lazy = 0;
        }
    }
}
