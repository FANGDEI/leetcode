package com.dyw.nowcoder.top100;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Devil
 * @since 2023-01-29-13:22
 */
@SuppressWarnings("all")
public class BM39序列化二叉树 {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.right.left = new TreeNode(6);
        treeNode.right.right = new TreeNode(7);

        System.out.println(new BM39序列化二叉树().Serialize(treeNode));
    }


    /**
     * 前序遍历将树结构转化为字符串
     * @param root
     * @return
     */
    String Serialize(TreeNode root) {
        return rserialize(root,"");
    }

    private String rserialize(TreeNode root, String s) {
        if (root==null){
            return s+"#,";
        }else{
            s+=String.valueOf(root.val)+",";
            s = rserialize(root.left,s);
            s = rserialize(root.right,s);
        }

        return s;
    }

    TreeNode Deserialize(String str) {
        String[] dataArrays = str.split(",");
        LinkedList<String> dataList = new LinkedList<>(Arrays.asList(dataArrays));
        return rdeserialize(dataList);
    }

    /**
     * 递归 由树的前序遍历生成树 反向生成
     * @param dataList
     * @return
     */
    private TreeNode rdeserialize(LinkedList<String> dataList) {
        //头结点为空
        if (dataList.get(0).equals("#")){
            dataList.remove(0);
            return null;
        }

        TreeNode root = new TreeNode(Integer.valueOf(dataList.get(0)));
        dataList.remove();
        root.left = rdeserialize(dataList);
        root.right = rdeserialize(dataList);
        return root;
    }

    public static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
