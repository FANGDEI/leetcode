package com.feng.newline.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.array
 * @className: L699掉落的方块
 * @author: Ladidol
 * @description: 在二维平面上的 x 轴上，放置着一些方块。
 * 给你一个二维整数数组 positions ，其中 positions[i] = [lefti, sideLengthi] 表示：第 i 个方块边长为 sideLengthi ，其左侧边与 x 轴上坐标点 lefti 对齐。
 * 每个方块都从一个比目前所有的落地方块更高的高度掉落而下。方块沿 y 轴负方向下落，直到着陆到 另一个正方形的顶边 或者是 x 轴上 。一个方块仅仅是擦过另一个方块的左侧边或右侧边不算着陆。一旦着陆，它就会固定在原地，无法移动。
 * 在每个方块掉落后，你必须记录目前所有已经落稳的 方块堆叠的最高高度 。
 * 返回一个整数数组 ans ，其中 ans[i] 表示在第 i 块方块掉落后堆叠的最高高度。
 * <p>
 * 输入：positions = [[1,2],[2,3],[6,1]]
 * 输出：[2,5,5]
 * 解释：
 * 第 1 个方块掉落后，最高的堆叠由方块 1 组成，堆叠的最高高度为 2 。
 * 第 2 个方块掉落后，最高的堆叠由方块 1 和 2 组成，堆叠的最高高度为 5 。
 * 第 3 个方块掉落后，最高的堆叠仍然由方块 1 和 2 组成，堆叠的最高高度为 5 。
 * 因此，返回 [2, 5, 5] 作为答案。
 * @date: 2022/7/22 16:49
 * @version: 1.0
 */
public class L699掉落的方块 {


    //线段树,最值
    class Solution {
        //这题注意默认左闭右开；
        //每一次加入新的正方形就可以这样想：默认固定后的下面为实心
        public List<Integer> fallingSquares(int[][] positions) {
            List<Integer> ans = new ArrayList<>();
            for (int[] position : positions) {
                int x = position[0];
                int h = position[1];//边长
                //查询出[x, x + h - 1 ]的最高值
                int cur = query(root, 0, N, x, x + h - 1);
                //更新[x, x + h - 1]为cur + h；
                update(root, 0, N, x, x + h - 1, cur + h);
                ans.add(root.val);//加入最大值。
            }
            return ans;
        }


        class Node {
            Node left, right;
            int val, lazy;//都可以随机应变
        }

        private int N = (int) 1e9;//这里也是哦
        private Node root = new Node();

        public void update(Node node, int start, int end, int l, int r, int val) {
            if (l <= start && end <= r) {
                node.val = val;//这里逻辑根据题意改变
                node.lazy = val;//这里也是
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
            if (l <= mid) ans = query(node.left, start, mid, l, r);
            if (r > mid) ans = Math.max(ans, query(node.right, mid + 1, end, l, r));
            return ans;
        }

        private void pushUp(Node node) {
            node.val = Math.max(node.left.val, node.right.val);
        }

        private void pushDown(Node node, int leftNum, int rightNum) {
            if (node.left == null) node.left = new Node();
            if (node.right == null) node.right = new Node();
            if (node.lazy == 0) return;
            node.left.val = node.lazy;
            node.right.val = node.lazy;
            // 对区间进行「加减」的更新操作，下推懒惰标记时需要累加起来，不能直接覆盖
            node.left.lazy = node.lazy;
            node.right.lazy = node.lazy;
            node.lazy = 0;
        }
    }
}
