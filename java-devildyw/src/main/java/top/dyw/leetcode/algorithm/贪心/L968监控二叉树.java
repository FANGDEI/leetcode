package top.dyw.leetcode.algorithm.贪心;

/**
 * 给定一个二叉树，我们在树的节点上安装摄像头。
 * <p>
 * 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。
 * <p>
 * 计算监控树的所有节点所需的最小摄像头数量。
 *
 * @author Devil
 * @since 2022-10-29-15:06
 */
@SuppressWarnings("all")
public class L968监控二叉树 {

    int res = 0;
    /**
     * 想要最少的摄像头监视所有节点，我们可以从底向上遍历叶子节点不放置摄像头（避免浪费 因为一个摄像头最多可以监视三层）
     * <p>
     * 所以有如下三种状态
     * <p>
     * 1.该节点无覆盖 0
     * <p>
     * 2.本节点有摄像头 1
     * <p>
     * 3.本节点有覆盖 2
     * <p>
     * 并且将空节点是为有覆盖的情况
     * <p>
     * 贪心：所以我们要从下往上看，局部最优：让叶子节点的父节点安摄像头，所用摄像头最少，整体最优：全部摄像头数量所用最少！
     *
     * @param root
     * @return
     */
    public int minCameraCover(TreeNode root) {
        //最后对根节点做判断 防止根节点无覆盖
        if (minCame(root)==0){
            res++;
        }
        return res;

    }

    private int minCame(TreeNode root) {
        //空节点视为有覆盖的情况 避免在叶子节点上防止摄像头
        if (root==null){
            return 2;
        }

        //后续遍历 左右中 从下往上遍历
        int left = minCame(root.left);
        int right =minCame(root.right);

        //中 处理当前层逻辑
        //如果左右子节点都覆盖了的话，那么本节点就应该是无覆盖，没有摄像头
        if (left==2&&right==2){
            return 0;//返回无覆盖 示意上一层节点防止摄像头 以覆盖该层
        } else if (left == 0 || right == 0) {
            //如果左右子树有一个覆盖 那么该节点处应当防止摄像头
            res++;
            return 1;
        }else {
            //除上述情况外 还有(1,1) (1,2) (2,1) //该节点都是覆盖
            return 2;
        }
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
