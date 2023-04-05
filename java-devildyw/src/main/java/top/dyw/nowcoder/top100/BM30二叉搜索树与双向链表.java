package top.dyw.nowcoder.top100;

import javafx.scene.transform.Rotate;

/**
 * @author Devil
 * @since 2023-01-10-22:21
 */
@SuppressWarnings("all")
public class BM30二叉搜索树与双向链表 {

    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public static void main(String[] args) {

    }

    public TreeNode head = null;
    //中序遍历当前值的上一位，初值为最小值，先定为null
    public TreeNode pre = null;
    /**
     * 中序遍历 改变节点指向
     * @param root
     * @return
     */
    public TreeNode Convert(TreeNode root) {
        if (root==null){
            //中序递归，叶子为空则返回
            return null;
        }
        //首先递归到最左最小值
        Convert(root.left);
        //找到最小值，初始化head与pre
        if (pre==null){
            head = root;
            pre = root;
        }
        //当前节点与上一个节点建立连接，将pre设置为当前值
        else{
            pre.right = root;
            root.left = pre;
            pre = root;
        }
        Convert(root.right);
        return head;
    }



    public TreeNode ConvertTest(TreeNode root) {
        if (root==null){
            return null;
        }

        //由最小的节点开始建立链表 遵循中序遍历顺序
        ConvertTest(root.left);

        if (pre==null){
            //如果为空 初始化为头结点和当前节点的上一个节点
            pre = root;
            head = root;
        }else{
            pre.right = root;
            root.left = pre;
            pre = root; //移动指针
        }
        ConvertTest(root.right);
        return head;
    }



}
