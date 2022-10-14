package com.feng.newline.binarytree;

import java.util.*;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L297二叉树的序列化与反序列化
 * @author: Ladidol
 * @description: 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 * <p>
 * 输入：root = [1,2]
 * 输出：[1,2]
 * @date: 2022/9/6 17:01
 * @version: 1.0
 */
public class L297二叉树的序列化与反序列化 {
    public class Codec1 {

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if (root == null) return "null";
            String ans = dfs1(root);//ans = 1,2,null,null,3,4,null,null,5,null,null
            return ans;
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            Queue<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
            return dfs2(queue);
        }

        // 序列化
        String dfs1(TreeNode root) {
            if (root == null) return "null";
            StringBuilder sb = new StringBuilder();
            sb.append(root.val).append(",").append(dfs1(root.left)).append(",").append(dfs1(root.right));
            return sb.toString();
        }

        // 反序列化（逆着走回去）
        TreeNode dfs2(Queue<String> queue) {
            String val = queue.poll();
            if ("null".equals(val)) {
                return null;
            }
            TreeNode root = new TreeNode(Integer.parseInt(val));
            root.left = dfs2(queue);
            root.right = dfs2(queue);
            return root;
        }
    }

    //层序遍历。
    public class Codec {//2022年10月14日11:52:54再来做一遍。

        /**
         * 参数：[root]
         * 返回值：java.lang.String
         * 作者： ladidol
         * 描述：第一感觉是，通过层序遍历。
         */
        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {

            Deque<TreeNode> queue = new LinkedList<>();
            List<Integer> res = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int tmpSize = queue.size();
                while (tmpSize > 0) {
                    TreeNode cur = queue.poll();
                    if (cur != null) {
                        res.add(cur.val);
                        queue.offer(cur.left);
                        queue.offer(cur.right);
                    } else {
                        res.add(null);
                    }
                    tmpSize--;
                }
            }
            //虽然后面有null的节点，但是似乎不影响答案的正确性。
            return Arrays.toString(res.toArray());
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            data = data.replace("[", "").replace("]", "").replace(" ", "");
            String[] nodes = data.split(",");
            if (nodes.length==0) return null;
            if (nodes.length==1) {
                if (nodes[0].equals("")||nodes[0].equals("null")) return null;
                return new TreeNode(Integer.parseInt(nodes[0]));
            }
            //split = [1,  2,  3,  null,  null,  4,  5,  null,  null,  null,  null]
            Deque<TreeNode> queue = new LinkedList<>();
            TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
            queue.offer(root);
            int index = 0;
            while (!queue.isEmpty()) {
                int tmpSize = queue.size();
                while (tmpSize > 0) {
                    TreeNode cur = queue.poll();
                    if (!nodes[++index].equals("null")) {
                        cur.left = new TreeNode(Integer.parseInt(nodes[index]));
                        queue.offer(cur.left);
                    }
                    if (!nodes[++index].equals("null")) {
                        cur.right = new TreeNode(Integer.parseInt(nodes[index]));
                        queue.offer(cur.right);
                    }

                    tmpSize--;
                }
            }
            return root;

        }
    }

}
