package com.dyw.leetcode.hard.tree;

import javax.swing.*;
import java.util.*;

/**
 * @author Devil
 * @since 2022-08-13-9:56
 * <p>
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 */
@SuppressWarnings("all")
public class L297二叉树的序列化与反序列化 {

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            return rserialize(root,"");
        }

        /**
         * 前序遍历将 树结构转化为字符串
         * @param root
         * @param s
         * @return
         */
        private String rserialize(TreeNode root, String s) {
            if (root==null){
                s+="null,";
            }
            else{
                s+=String.valueOf(root.val)+",";
                s = rserialize(root.left,s);
                s = rserialize(root.right,s);
            }


            return s;

        }


        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            String[] dataArrays = data.split(",");
            LinkedList<String> dataList = new LinkedList<>(Arrays.asList(dataArrays));
            return rdeserialize(dataList);
        }

        /**
         * 递归 由树的前序遍历生成树
         * @param dataList
         * @return
         */
        private TreeNode rdeserialize(LinkedList<String> dataList) {
            if (dataList.get(0).equals("null")){
                dataList.remove(0);
                return null;
            }
            TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
            dataList.remove();
            root.left = rdeserialize(dataList);
            root.right = rdeserialize(dataList);

            return root;
        }
    }
}
