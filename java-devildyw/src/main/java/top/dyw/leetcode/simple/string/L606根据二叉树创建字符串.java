package top.dyw.leetcode.simple.string;


/**
 * @author Devil
 * @since 2022-07-02-15:32
 * <p>
 * 给你二叉树的根节点 root ，请你采用前序遍历的方式，将二叉树转化为一个由括号和整数组成的字符串，返回构造出的字符串。
 * <p>
 * 空节点使用一对空括号对 "()" 表示，转化后需要省略所有不影响字符串与原始二叉树之间的一对一映射关系的空括号对。
 */
@SuppressWarnings("all")
public class L606根据二叉树创建字符串 {
    public static void main(String[] args) {

    }

    /**
     * todo:学完树后再做一遍
     * 四种情况:
     * 1. 如果当前节点有两个孩子，那我们在递归时，需要在两个孩子的结果外都加上一层括号；
     * 2. 如果当前节点没有孩子，那我们不需要在节点后面加上任何括号；
     * 3. 如果当前节点只有左孩子，那我们在递归时，只需要在左孩子的结果外加上一层括号，而不需要给右孩子加上任何括号；
     * 4. 如果当前节点只有右孩子，那我们在递归时，需要先加上一层空的括号 \text{`()'}‘()’ 表示左孩子为空，再对右孩子进行递归，并在结果外加上一层括号。
     * <p>
     * <p>
     * 遍历
     *
     * @param root
     * @return
     */
    public String tree2str(TreeNode root) {
        if (root == null) {
            return "";
        }
        //如果两个子树都为空  那么直接返回当前节点值
        if (root.right == null && root.left == null) {
            return Integer.toString(root.val);
        }
        if (root.right == null) {
            //如果右子树为空 遍历用括号保住遍历左子树后的值
            return new StringBuffer().append(root.val).append("(").append(tree2str(root.left)).append(")").toString();
        }
        return new StringBuffer().append(root.val).append("(").append(tree2str(root.left)).append(")(").append(tree2str(root.right)).append(")").toString();
    }


}

