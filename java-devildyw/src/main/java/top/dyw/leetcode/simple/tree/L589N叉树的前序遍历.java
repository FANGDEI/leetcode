package top.dyw.leetcode.simple.tree;

import java.util.*;

/**
 * 给定一个 n叉树的根节点 root，返回 其节点值的 前序遍历 。
 * <p>
 * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 *
 * @author Devil
 * @since 2022-09-22-11:20
 */
@SuppressWarnings("all")
public class L589N叉树的前序遍历 {

    class Node {
        public int val;
        public List<Node> children;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, List<Node> _children) {
            val = _val;
            children = _children;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, String> map = new HashMap<>();
        HashMap<Integer, Integer> tempMap = new HashMap<>();
        while (true) {
            String line = scanner.nextLine();
            if (line.equals("END")) {
                break;
            }
            String[] split = line.split("#");
            Integer jinzhi = Integer.valueOf(split[0]);
            String num = split[1];


            int sum = 0;
            for (int i = num.length() - 1; i >= 0; i--) {
                char c = num.charAt(i);
                int temp = 0;
                switch (c) {
                    case 'A':
                        temp = 10;
                        break;
                    case 'B':
                        temp = 11;
                        break;
                    case 'C':
                        temp = 12;
                        break;
                    case 'D':
                        temp = 13;
                        break;
                    case 'E':
                        temp = 14;
                        break;
                    case 'F':
                        temp = 15;
                        break;
                    default:
                        temp = c - '0';
                        break;
                }
                sum += temp * Math.pow(jinzhi, num.length() - i - 1);
            }

            map.put(sum, line);
            tempMap.put(sum, tempMap.getOrDefault(sum, 0) + 1);
        }

        Set<Integer> set = tempMap.keySet();
        boolean flag = true;
        for (Integer i : set) {
            if (tempMap.get(i).equals(1)) {
                flag = false;
                System.out.println(map.get(i));
            }
        }

        if (flag) {
            System.out.println("None");
        }

    }

    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        preorderRecursion(root, result);
        return result;
    }

    /**
     * 递归法 中 左 右
     */
    public void preorderRecursion(Node node, List<Integer> result) {
        if (node == null) {
            return;
        }
        result.add(node.val);
        List<Node> children = node.children;
        for (Node child : children) {
            preorderRecursion(child, result);
        }
    }


    /**
     * 迭代法
     *
     * @param root
     * @return
     */
    public List<Integer> preorder01(Node root) {
        List<Integer> result = new ArrayList<>();
        Deque<Node> deque = new LinkedList<>();
        if (root==null){
            return result;
        }
        deque.push(root);
        while (!deque.isEmpty()){
            Node node = deque.peek();
            if (node!=null){
                deque.pop();
                List<Node> children = node.children;
                for (int i = children.size()-1; i>=0; i--) {
                    deque.push(children.get(i));
                }
                deque.push(node);
                deque.push(null);
            }else{
                deque.pop();
                node = deque.pop();
                result.add(node.val);
            }
        }
        return result;
    }
}