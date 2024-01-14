package top.dyw.leetcode.DataStructure.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 树的迭代遍历
 *
 * @author Devil
 * @since 2022-09-19-11:14
 */
@SuppressWarnings("all")
public class TreeIterateTraverse {

    /**
     * 前序遍历迭代版本 使用栈来模拟递归
     *
     * <img src="https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/202209191152436.gif">
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root==null){
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            //取出根节点 将其结果记录进结果集中 同时将根节点的右子树左子树 按 右左的顺序加入栈中 取出时就可以按 左右的顺序了 与前序遍历相符
            TreeNode node = stack.pop();
            result.add(node.val);

            if (node.right!=null){
                stack.push(node.right);
            }
            if (node.left!=null){
                stack.push(node.left);
            }
        }
        return result;
    }

    /**
     * 中序遍历迭代版本
     *
     * <img src="https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/202209191153971.gif">
     *
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root==null){
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur!=null||!stack.isEmpty()){
            if (cur!=null){ //指针来访问节点，直到最底层
                stack.push(cur); //将访问的节点放入栈中
                cur = cur.left; //继续向下访问左节点
            }else{              //如果到最低层
                cur = stack.pop();  //取出栈顶元素 也就是最底层的左节点
                result.add(cur.val);  //加入结果集
                cur = cur.right; //将其右节点加入栈中 去访问右子树下的左节点
            }
        }
        return result;
    }


    /**
     * 后序遍历迭代法
     *
     * 再来看后序遍历，先序遍历是中左右，后续遍历是左右中，那么我们只需要调整一下先序遍历的代码顺序，就变成中右左的遍历顺序，然后在反转result数组，输出的结果顺序就是左右中了
     *
     * <img src="https://ding-blog.oss-cn-chengdu.aliyuncs.com/images/202209191142711.png">
     *
     * @param root
     * @return
     */
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root==null){
            return result;
        }

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            TreeNode node = stack.pop();
            result.add(node.val);

            if (node.left!=null){
                stack.push(node.left);
            }
            if (node.right!=null){
                stack.push(node.right);
            }
        }

        Collections.reverse(result);

        return result;
    }

}


