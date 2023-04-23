package top.dyw.leetcode.剑指Offer;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author Devildyw
 * @date 2023/04/23 09:48
 **/

@SuppressWarnings("all")
public class O37序列化二叉树 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        Codec codec = new Codec();
        System.out.println(codec.serialize(root));

    }

    static class Codec {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root==null){
                return "[]";
            }
            StringBuilder result = new StringBuilder("[");
            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()){
                int size = queue.size();
                while (size-->0){
                    TreeNode node = queue.poll();
                    if (node!=null){
                        result.append(node.val+",");
                        queue.add(node.left);
                        queue.add(node.right);
                    }else result.append("null,");
                }
            }
            //去除最后一个逗号
            result.deleteCharAt(result.length()-1);
            result.append("]");
            return result.toString();

        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if (data.equals("[]")){
                return null;
            }
            String[] vals = data.substring(1, data.length() - 1).split(",");
            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode root = new TreeNode(Integer.valueOf(vals[0]));
            queue.add(root);
            int i = 1;
            //逆向
            while (!queue.isEmpty()){
                int size = queue.size();
                while (size-->0){
                    TreeNode node = queue.poll();
                    if (!vals[i].equals("null")){
                        node.left = new TreeNode(Integer.valueOf(vals[i]));
                        queue.add(node.left);
                    }
                    i++;
                    if (!vals[i].equals("null")){
                        node.right = new TreeNode(Integer.valueOf(vals[i]));
                        queue.add(node.right);
                    }
                    i++;
                }
            }
            return root;
        }
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
