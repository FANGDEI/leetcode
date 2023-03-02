package com.dyw.nowcoder.top100;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

/**
 * @author Devil
 * @since 2023-01-13-13:51
 */
@SuppressWarnings("all")
public class BM38在二叉树中找到两个节点的最近公共祖先 {

    public static void main(String[] args) {

    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
    }

    //记录是否找到o的路径
    public boolean flag = false;

    public int lowestCommonAncestor(TreeNode root, int o1, int o2) {
        // write code here
        ArrayList<Integer> path1 = new ArrayList<>();
        ArrayList<Integer> path2 = new ArrayList<>();
        //求根节点到两个节点的路径
        dfs(root, path1, o1);
        //重置flag
        flag = false;
        dfs(root, path2, o2);
        int res = 0;
        //比较两个路径，找到第一个不同的点 ，最后一个相同的点就是最近公共祖先
        for (int i = 0; i < path1.size() && i < path2.size(); i++) {
            int x = path1.get(i);
            int y = path2.get(i);
            if (x==y){
                //最后一个相同的节点就是最近公共祖先
                res = x;
            }else {
                break;
            }
        }
        return res;

    }

    private void dfs(TreeNode root, ArrayList<Integer> path, int o) {
        if (flag||root == null) { //这里判断flag 是优化性能 防止不必要的查询
            return;
        }
        path.add(root.val);
        //节点值都不同，可以直接用值比较
        if (root.val == o) {
            flag = true;
            return;
        }
        //如果没有匹配上继续查找左右子树
        dfs(root.left, path, o);
        dfs(root.right, path, o); //上面的flag能优化这里 如果在左子树上找到了 这里就可以避免查找了
        if (flag) {
            return;
        }
        //回溯
        path.remove(path.size() - 1);
    }
}
