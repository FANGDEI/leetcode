package com.feng.newline.binarytree;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.binarytree
 * @className: L558四叉树交集
 * @author: Ladidol
 * @description:
 * class Node {
 *     public boolean val;
 *     public boolean isLeaf;
 *     public Node topLeft;
 *     public Node topRight;
 *     public Node bottomLeft;
 *     public Node bottomRight;
 * }
 *
 * 示例:
 * 输入：
 * quadTree1 = [[0,1],[1,1],[1,1],[1,0],[1,0]]
 * quadTree2 = [[0,1],[1,1],[0,1],[1,1],[1,0],null,null,null,null,[1,0],[1,0],[1,1],[1,1]]
 * 输出：[[0,0],[1,1],[1,1],[1,1],[1,0]]
 * 解释：quadTree1 和 quadTree2 如上所示。由四叉树所表示的二进制矩阵也已经给出。
 * 如果我们对这两个矩阵进行按位逻辑或运算，则可以得到下面的二进制矩阵，由一个作为结果的四叉树表示。
 * 注意，我们展示的二进制矩阵仅仅是为了更好地说明题意，你无需构造二进制矩阵来获得结果四叉树。
 *
 *
 * 提示, 这题主要理解题意, 不需要看示例.
 * @date: 2022/7/15 9:51
 * @version: 1.0
 */
//2022年7月15日10:16:02每日一题
public class L558四叉树交集 {


    class Solution {
        public Node intersect(Node quadTree1, Node quadTree2) {
            //树一为叶子结点
            if (quadTree1.isLeaf){
                if (quadTree1.val){//如果为真, 或运算机制.
                    return quadTree1;
                }
                return quadTree2;
            }
            //树二为叶子结点
            if (quadTree2.isLeaf){
                if (quadTree2.val){
                    return quadTree2;
                }
                return quadTree1;
            }
            //对四个子节点进行递归遍历
            Node topLeft = intersect(quadTree1.topLeft,quadTree2.topLeft);
            Node bottomLeft = intersect(quadTree1.bottomLeft,quadTree2.bottomLeft);
            Node bottomRight = intersect(quadTree1.bottomRight,quadTree2.bottomRight);
            Node topRight = intersect(quadTree1.topRight,quadTree2.topRight);
            //如果到底了就返回到底的样子咯
            if (topLeft.isLeaf&bottomLeft.isLeaf&bottomRight.isLeaf&topRight.isLeaf
                    && topLeft.val == topRight.val && topLeft.val == bottomLeft.val && topLeft.val == bottomRight.val){
                //如果符合题中给的合并子节点的选项的话
                return new Node(topLeft.val,true,null,null,null,null);
            }
            return new Node(false,false,topLeft,topRight,bottomLeft,bottomRight);
        }
    }
}
