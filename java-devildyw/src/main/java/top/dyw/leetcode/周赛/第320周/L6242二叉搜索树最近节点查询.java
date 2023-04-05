package top.dyw.leetcode.周赛.第320周;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Devil
 * @since 2022-11-20-12:36
 */
@SuppressWarnings("all")
public class L6242二叉搜索树最近节点查询 {
    public static void main(String[] args) {

    }

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        List<List<Integer>> result = new ArrayList<>();

        List<Integer> treeNodes = new ArrayList<>();
        //树的中序遍历 将二叉搜索树转换为有序数组
        inorderTraversal(root,treeNodes);

        for (Integer query : queries) {
            //通过二分查找 查找到对应的元素
            ArrayList<Integer> list = new ArrayList<>();
            list.add(help1(treeNodes,query));
            list.add(help2(treeNodes,query));
            result.add(list);
        }
        return result;

    }

    private void inorderTraversal(TreeNode root,List<Integer> treeNodes) {
        if (root==null){
            return;
        }
        inorderTraversal(root.left,treeNodes);
        treeNodes.add(root.val);
        inorderTraversal(root.right,treeNodes);
    }

    private int help1(List<Integer> nums, int target) {
        int i = 0, j = nums.size() - 1;
        while (i < j) {
            int mid = i + (j - i+1) / 2;
            if (nums.get(mid) > target) {
                j = mid - 1;
            } else {
                i = mid;
            }
        }
        return nums.get(i) <= target ? nums.get(i) : -1;
    }
    private int help2(List<Integer> nums, int target) {
        int i = 0, j = nums.size() - 1;
        while (i < j) {
            int mid = i + (j - i) / 2;
            if (nums.get(mid) < target) {
                i = mid + 1;
            } else {
                j = mid;
            }
        }
        return nums.get(i) >= target ? nums.get(i) : -1;
    }


    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
