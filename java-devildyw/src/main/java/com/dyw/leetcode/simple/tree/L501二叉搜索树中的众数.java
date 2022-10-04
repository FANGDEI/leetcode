package com.dyw.leetcode.simple.tree;

import com.sun.org.apache.bcel.internal.generic.RET;

import java.util.*;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;

/**
 * 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
 *
 * 如果树中有不止一个众数，可以按 任意顺序 返回。
 *
 * 假定 BST 满足如下定义：
 *
 * 结点左子树中所含节点的值 小于等于 当前节点的值
 * 结点右子树中所含节点的值 大于等于 当前节点的值
 * 左子树和右子树都是二叉搜索树
 *
 * @author Devil
 * @since 2022-10-04-10:21
 */
@SuppressWarnings("all")
public class L501二叉搜索树中的众数 {

    public static void main(String[] args) {

    }

    Map<Integer,Integer> map = new HashMap<>();
    /**
     * 暴力法 使用map 存储元素以及出现次数
     * @param root
     * @return
     */
    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversal(root);
        List<Map.Entry<Integer, Integer>> mapList = map.entrySet().stream().sorted(new Comparator<Map.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        }).collect(Collectors.toList());
        list.add(mapList.get(0).getKey());

        //遍历查看是否还有于第一个元素一样频率最高的元素
        for (int i = 1; i < mapList.size(); i++) {
            if (mapList.get(i).getValue()==mapList.get(0).getValue()){
                list.add(mapList.get(i).getKey());
            }else{
                break;
            }
        }
        return list.stream().mapToInt(Integer::intValue).toArray();
    }

    private void traversal(TreeNode root) {
        if (root==null){
            return;
        }
        traversal(root.left);
        map.put(root.val,map.getOrDefault(root.val,0)+1);
        traversal(root.right);
    }
}
