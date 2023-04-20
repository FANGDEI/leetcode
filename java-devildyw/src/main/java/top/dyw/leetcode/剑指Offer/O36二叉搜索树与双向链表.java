package top.dyw.leetcode.剑指Offer;

/**
 * @author Devildyw
 * @date 2023/04/20 20:08
 **/
@SuppressWarnings("all")
public class O36二叉搜索树与双向链表 {

    public static void main(String[] args) {

    }

    Node pre,head;

    public Node treeToDoublyList(Node root) {
        if (root==null) return null;
        dfs(root);
        //最后将头尾相接
        head.left = pre;
        pre.right = head;
        return head;
    }

    /**
     * 中序遍历，记录三个节点 pre、cur、head
     * 1. 如果此时pre为空则代表还没有前驱节点，则当前节点就为头节点 当前节点的前驱指针left指向pre 更新pre
     * 2. 如果pre不为空则代表head不为空正在构建双向链表了,将前驱节点的后继指针指向cur
     * @param cur
     */
    private void dfs(Node cur) {
        if (cur==null){
            return;
        }
        dfs(cur.left);
        if (head!=null){
            pre.right = cur;
        }else{
            head = cur;
        }
        cur.left = pre;
        pre = cur;
        dfs(cur.right);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
}
