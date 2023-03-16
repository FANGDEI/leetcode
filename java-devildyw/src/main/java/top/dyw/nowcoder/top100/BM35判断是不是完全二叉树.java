package top.dyw.nowcoder.top100;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author Devil
 * @since 2023-01-12-10:33
 */
@SuppressWarnings("all")
public class BM35判断是不是完全二叉树 {

    public static void main(String[] args) {
        System.out.println((false ^ false) ^ true);
    }

    /*
    什么是完全二叉树：一棵深度为k的有n个结点的二叉树，对树中的结点按从上至下、
    从左到右的顺序进行编号，如果编号为i（1≤i≤n）的结点与满二叉树中编号为i的
    结点在二叉树中的位置相同，则这棵二叉树称为完全二叉树。
     */

    //todo:复习
    /**
     * 注意完全二叉树 和满二叉树是不完全一样的 满二叉树一定是完全二叉树 反之则不一定
     * 层次遍历，如果出现空节点#且后续还出现非空节点的话就不满足完全二叉树定义
     *
     * @param root
     * @return
     */
    public boolean isCompleteTree(TreeNode root) {
        // write code here
        if (root == null) {
            return true;
        }
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);

        //定义一个每一层首次出现的标记位
        boolean flag = false;
        while (!deque.isEmpty()) {
            TreeNode poll = deque.poll();
            //标记第一次遇到空节点
            if (poll == null) {
                flag = true;
                continue;
            }
            //到这一步说明当前节点不为空，而前面又访问到了空节点 按理说如果时完全二叉树应当是后续节点全为空节点 所以这里返回false
            if (flag) {
                return false;
            }
            deque.offer(poll.left);
            deque.offer(poll.right);

        }
        return true;
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
