package top.dyw.nowcoder.top100;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Devil
 * @since 2023-01-09-23:02
 */
@SuppressWarnings("all")
public class BM27按之字形顺序打印二叉树 {

    public static void main(String[] args) {

    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> roots = new ArrayList<>();
        if (pRoot==null){
            return roots;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(pRoot);
        boolean flag = true; // 标识是否反转 反转来达到交替遍历的效果
        while (!deque.isEmpty()){
            int size = deque.size();
            ArrayList<Integer> temp = new ArrayList<>();
            //奇数行不反转 偶数行反转
            flag =!flag;
            while (size-->0){
                TreeNode poll = deque.poll();
                temp.add(poll.val);

                if (poll.left!=null){
                    deque.offer(poll.left);
                }
                if (poll.right!=null){
                    deque.offer(poll.right);
                }
            }
            if (flag){
                Collections.reverse(temp);
            }
            roots.add(temp);

        }

        return roots;
    }

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
}
