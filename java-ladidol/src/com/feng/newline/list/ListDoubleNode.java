package com.feng.newline.list;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.list
 * @className: ListDoubleNode
 * @author: Ladidol
 * @description:
 * @date: 2022/6/21 23:19
 * @version: 1.0
 */
public class ListDoubleNode {
    // 结点的数据域
    int val;

    // 下一个结点的地址
    ListDoubleNode next;

    ListDoubleNode pre;

    // 节点的构造函数(无参)
    public ListDoubleNode() {

    }

    // 节点的构造函数(有一个参数)
    public ListDoubleNode(int val) {
        this.val = val;
    }
}