## 不同数据的差异
大致曲线：

![时间复杂度，不同数据规模的差异](https://figurebed-ladidol.oss-cn-chengdu.aliyuncs.com/img/202205161029620.png)

现在计算机大致计算规模：

![程序超时1](https://figurebed-ladidol.oss-cn-chengdu.aliyuncs.com/img/202205161031585.png)

基本内存空间分配:
c++
![image-20220516141534230](https://figurebed-ladidol.oss-cn-chengdu.aliyuncs.com/img/202205161415387.png)


2022年6月24日22:43:13
注意面试的时候，面试官可能会让你手写，一些基本的数据结构哈！

单链表：
```java
public class ListNode {
    // 结点的值
    int val;
    // 下一个结点
    ListNode next;
    // 节点的构造函数(无参)
    public ListNode() {
    }
    // 节点的构造函数(有一个参数)
    public ListNode(int val) {
        this.val = val;
    }
    // 节点的构造函数(有两个参数)
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
```


二叉树：
```java
public class TreeNode {
    int val;
  	TreeNode left;
  	TreeNode right;
  	TreeNode() {}
  	TreeNode(int val) { this.val = val; }
  	TreeNode(int val, TreeNode left, TreeNode right) {
    		this.val = val;
    		this.left = left;
    		this.right = right;
  	}
}
```