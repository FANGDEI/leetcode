package top.dyw.leetcode.剑指Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author Devildyw
 * @date 2023/07/27 11:02
 **/
@SuppressWarnings("all")
public class OII048序列化与反序列化二叉树 {

    public class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            return rserialize(root,"");
        }

        /**
         * 先序遍历
         * @param root
         * @param s
         * @return
         */
        private String rserialize(TreeNode root, String s) {
            if (root==null){
                s += "null,";
            }else{
                s += root.val+",";
                s = rserialize(root.left,s);
                s = rserialize(root.right,s);
            }
            return s;
        }

        /**
         * 根据先序遍历的数组将其转化为树 递归处理
         * @param data
         * @return
         */
        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            //首先将data转换为list方便操作
            String[] split = data.split(",");
            LinkedList<String> dataList = new LinkedList<>(Arrays.asList(split));
            return rdeserialize(dataList);
        }

        /**
         * 按照先序遍历构建二叉树
         * @param dataList
         * @return
         */
        private TreeNode rdeserialize(LinkedList<String> dataList) {
            if (dataList.get(0).equals("null")){
                dataList.remove(0);
                return null;
            }else {
                TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
                dataList.remove(0);
                //根左右
                root.left = rdeserialize(dataList);
                root.right = rdeserialize(dataList);
                return root;
            }
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
