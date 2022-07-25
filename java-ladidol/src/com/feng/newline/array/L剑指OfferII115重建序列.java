package com.feng.newline.array;


/**
 * @projectName: leetcode
 * @package: com.feng.newline.array
 * @className: L剑指OfferII115重建序列
 * @author: Ladidol
 * @description:
 * @date: 2022/7/23 14:36
 * @version: 1.0
 */
public class L剑指OfferII115重建序列 {
    // 2022/7/23 待做。
//    class Solution {
//        public boolean sequenceReconstruction(int[] nums, int[][] sequences) {
//            //转化成边
//            Map<Integer, Set<Integer>> edge = new HashMap<>();
//            //记录入度
//            int[] inDegree = new int[nums.length + 1];
//            for (int[] sequence : sequences) {
//                //注意这里是一个子序列，有多个元素，不是两个
//                for (int i = 1; i < sequence.length; i++) {
//                    int from = sequence[i - 1];
//                    int to = sequence[i];
//                    //判断是否有此条边
//                    if (edge.containsKey(from) && edge.get(from).contains(to)) {
//                        continue;
//                    }
//                    edge.putIfAbsent(from, new HashSet<>());
//                    edge.get(from).add(to);
//                    inDegree[to]++;
//                }
//            }
//            //记录入度为0的点
//            Queue<Integer> queue = new ArrayDeque<>();
//            for (int i = 1; i <= nums.length; i++) {
//                if (inDegree[i] == 0) {
//                    queue.offer(i);
//                }
//            }
//            while (!queue.isEmpty()) {
//                //存在多个入度为0的点 会有多个超序列 直接返回false
//                if (queue.size() > 1) {
//                    return false;
//                }
//                int from = queue.poll();
//                Set<Integer> set = edge.get(from);
//                if (set == null) {
//                    continue;
//                }
//                //和此点连通的点入度减一
//                for (int point : set) {
//                    inDegree[point]--;
//                    if (inDegree[point] == 0) {
//                        queue.add(point);
//                    }
//                }
//            }
//            return true;
//        }
//    }
}
