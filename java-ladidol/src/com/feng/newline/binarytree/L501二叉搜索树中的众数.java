package com.feng.newline.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L501二叉搜索树中的众数
 * @author: Ladidol
 * @description: 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
 * 如果树中有不止一个众数，可以按 任意顺序 返回。
 * 假定 BST 满足如下定义：
 * 结点左子树中所含节点的值 小于等于 当前节点的值
 * 结点右子树中所含节点的值 大于等于 当前节点的值
 * 左子树和右子树都是二叉搜索树
 * @date: 2022/8/3 21:43
 * @version: 1.0
 */
public class L501二叉搜索树中的众数 {


    //这是一个比较特殊的二叉搜索树。这题直接把它当成普通二叉树硬解就行。
    class Solution1 {
        public int[] findMode(TreeNode root) {
            //像遍历一遍全部二叉树，用map记录count选出最大值。即可
            Map<Integer, Integer> map = new HashMap<>();
            List<Integer> list = new ArrayList<>();
            if (root == null) return list.stream().mapToInt(Integer::intValue).toArray();
            // 获得频率 Map
            searchBST(root, map);
            List<Map.Entry<Integer, Integer>> mapList = map.entrySet().stream()
                    .sorted((c1, c2) -> c2.getValue().compareTo(c1.getValue()))
                    .collect(Collectors.toList());
            list.add(mapList.get(0).getKey());
            // 把频率最高的加入 list
            for (int i = 1; i < mapList.size(); i++) {
                if (mapList.get(i).getValue() == mapList.get(i - 1).getValue()) {
                    list.add(mapList.get(i).getKey());
                } else {
                    break;
                }
            }
            return list.stream().mapToInt(Integer::intValue).toArray();
        }

        void searchBST(TreeNode curr, Map<Integer, Integer> map) {
            if (curr == null) return;
            map.put(curr.val, map.getOrDefault(curr.val, 0) + 1);
            searchBST(curr.left, map);
            searchBST(curr.right, map);
        }
    }


    //主要看一下这个方法。
    //利用二叉搜索树是有顺序的性质，直接记录前一个节点和当前节点。
    class Solution {
        int count = 0;
        int maxCount = Integer.MIN_VALUE;
        TreeNode preNode;
        List<Integer> res;

        public int[] findMode(TreeNode root) {
            res = new ArrayList<>();
            searchBST(root);
            int[] ans = new int[res.size()];
            for (int i = 0; i < res.size(); i++) {
                ans[i] = res.get(i);
            }
            return ans;

        }
        void searchBST(TreeNode cur){
            if (cur == null) return;
            searchBST(cur.left);//左
                                //中
            if (preNode == null) count = 1;
            else if (preNode.val == cur.val) count++ ;
            else count = 1 ;

            preNode = cur;

            if (count == maxCount){//一定不会出现list里面add重复的情况，这是特点。
                res.add(cur.val);
            }else if (count > maxCount){
                maxCount = count;
                res.clear();
                res.add(cur.val);
            }
            searchBST(cur.right);
        }
    }
}
