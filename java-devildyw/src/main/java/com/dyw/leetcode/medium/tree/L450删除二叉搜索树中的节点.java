package com.dyw.leetcode.medium.tree;

import sun.reflect.generics.tree.Tree;

/**
 * @author Devil
 * @since 2022-08-11-9:24
 * <p>
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的key对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 * <p>
 * 一般来说，删除节点可分为两个步骤：
 * <p>
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 */
@SuppressWarnings("all")
public class L450删除二叉搜索树中的节点 {
    public static void main(String[] args) {

    }

    /**
     * 递归 因为这是二叉搜索树又因为节点值唯一 所以只会存在一个节点的值等于key
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {
        //终止条件 遇到节点为空的情况直接返回
        if (root==null){
            return null;
        }
        if (root.val>key){
            //如果当前节点值大于key了 由二叉搜索树性质可知 根节点左边的值小于根节点的值 右边的值大于根节点的值
            //所以这里我们要查找根节点左边的值才能找到 再返回已经删除节点后的子树
            root.left =deleteNode(root.left,key);
        }
        if (root.val<key){
            //与上面同理
            root.right = deleteNode(root.right,key);
        }

        //如果该节点的值等于key 那么要删除该节点。
        if (root.val == key){
            //如果该节点没有左右子树 那么直接返回该节点为空即可代表删除 因为该递归的结果可能就作为上一层的左子树或者右子树返回
            if (root.left==null&&root.right==null){
                return null;
            }
            //因为 二叉搜索树中的每一个子树也都满足二叉搜索树的性质 在另一颗子树不存在的情况下 另一子树可以直接替换原来的根节点 依然满足二叉搜索树的性质
            //如果右子树为空 那么左子树就作为结果返回
            if (root.right==null){
                return root.left;
            }
            //如果左子树为空 那么右子树就作为结果返回
            if (root.left==null){
                return root.right;
            }
            //如果左右子树都存在
            //则需要找到右子树中较小的一个节点来充当新的根节点 否则会破坏二叉搜索树的有序性
            //比如 去了右子树的根节点作为新的根节点 那么可能会出现比根节点小的值出现在右子树上
            TreeNode right = root.right;
            //遍历查找到右子树上最小的节点 即最左边的叶子节点
            //right 保存了这个节点的信息
            while (right.left!=null){
                right = right.left;
            }
            //借助deleeteNode这个方法在根节点的右子树上删除掉这个最小节点
            //返回的右子树就为没有原来最小节点的子树
            root.right = deleteNode(root.right,right.val);
            //由于现在right保存着原来最小节点的信息 现在要将其替换原来的根节点
            //将根节点的左右子树赋值给新的根节点 完成替换
            right.right = root.right;
            right.left = root.left;
            return right;
        }
        //返回结果
        return root;
    }

    public TreeNode deleteNode01(TreeNode root, int key) {
        if (root==null){
            return null;
        }

        if (root.val>key){
            root.left = deleteNode01(root.left,key);
        }

        if (root.val<key){
            root.right = deleteNode01(root.right,key);
        }

        if (root.val==key){
            if (root.left==null&&root.right==null){
                return null;
            }
            if (root.right==null){
                return root.left;
            }
            if (root.left==null){
                return root.right;
            }
            //如果左右子树都存在 找出右子树中最小节点 代替根节点
            TreeNode right = root.right;
            while (right.left!=null){
                right = right.left;
            }

            root.right = deleteNode01(root.right, right.val);
            right.right = root.right;
            right.left = root.left;
            return right;
        }
        return root;
    }

    public TreeNode deleteNode02(TreeNode root, int key) {
        if (root==null){
            return null;
        }

        //利用二叉搜索树的性质
        if (root.val<key){
            root.right = deleteNode02(root.right,key);
        }

        if (root.val>key){
            root.left = deleteNode02(root.left,key);
        }

        if (root.val==key){
            if (root.left==null&&root.right==null){
                return null;
            }
            if (root.left==null){
                return root.right;
            }
            if (root.right==null){
                return root.left;
            }

            //如果左右都存在
            TreeNode right = root.right;
            while (right.left!=null){
                right = right.left;
            }
            //以右子树中的最小值的节点作为新的根节点 因为该节点既大于左子树 又小于右子树
            root.right = deleteNode02(root.right,right.val);
            right.right = root.right;
            right.left = root.left;
            //将新节点返回到上层
            return right;
        }
        return root;
    }

    /**
     * 递归
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode03(TreeNode root, int key) {
        //如果根节点为空 则直接返回
        if (root==null){
            return null;
        }

        //根节点不为空的情况
        //如果当前节点值小于 key 的值 则应该在该节点的右子树中寻找要删除的节点 并将新的右节点返回给当前节点
        if (root.val< key){
            root.right = deleteNode03(root.right,key);
        }

        //大于 同理
        if (root.val>key){
            root.left = deleteNode03(root.left,key);
        }

        //如果等于 此时就要进行删除操作了
        //但是删除也要分情况 如果当前节点的左右子树都为空 即当前节点是叶子节点 则直接返回空给上层 即代表删除
        if (root.val == key){
            if (root.left==null&&root.right==null){
                return null;
            }
            //如果该节点不是叶子节点并且 右子树/左子树 为空 则直接返回 左子树/右子树 作为子树 因为二叉搜索树的子树也是二叉搜索树 所以不需要特别调整
            if (root.right==null){
                return root.left;
            }

            if (root.left==null){
                return root.right;
            }

            if (root.right!=null&&root.left!=null){
                TreeNode right = root.right;
                while (right.left!=null){
                    right = right.left;
                }
                right.right = deleteNode03(root.right,right.val);
                right.left = root.left;
                return right;
            }
        }
        return root;
    }
}
