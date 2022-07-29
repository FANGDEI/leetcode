![img.png](https://figurebed-ladidol.oss-cn-chengdu.aliyuncs.com/img/202207281617834.png)


# 二叉树分类
## 满二叉树
满二叉树：如果一棵二叉树只有度为0的结点和度为2的结点，并且度为0的结点在同一层上，则这棵二叉树为满二叉树。
![img_1.png](https://figurebed-ladidol.oss-cn-chengdu.aliyuncs.com/img/202207281616924.png)

## 完全二叉树
完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~ 2^(h-1)  个节点。
之前我们刚刚讲过优先级队列其实是一个堆，堆就是一棵完全二叉树，同时保证父子节点的顺序关系。
![img_2.png](https://figurebed-ladidol.oss-cn-chengdu.aliyuncs.com/img/202207281616690.png)


## 二叉搜索树
前面介绍的树，都没有数值的，而二叉搜索树是有数值的了，二叉搜索树是一个有序树。
若它的左子树不空，则左子树上所有结点的值均小于它的根结点的值；
若它的右子树不空，则右子树上所有结点的值均大于它的根结点的值；
它的左、右子树也分别为二叉排序树
下面这两棵树都是搜索树

![img_3.png](https://figurebed-ladidol.oss-cn-chengdu.aliyuncs.com/img/202207281616575.png)
## 平衡二叉搜索树
平衡二叉搜索树：又被称为AVL（Adelson-Velsky and Landis）树，且具有以下性质：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
如图：
![img_4.png](https://figurebed-ladidol.oss-cn-chengdu.aliyuncs.com/img/202207281616462.png)


# 二叉树遍历方式

1. 深度优先遍历
   - 前序遍历（递归法，迭代法）
   - 中序遍历（递归法，迭代法）
   - 后序遍历（递归法，迭代法）
2. 广度优先遍历
   - 层次遍历（迭代法）

## 递归遍历

>  1. **确定递归函数的参数和返回值：** 确定哪些参数是递归的过程中需要处理的，那么就在递归函数里加上这个参数， 并且还要明确每次递归的返回值是什么进而确定递归函数的返回类型。
   2. **确定终止条件：** 写完了递归算法, 运行的时候，经常会遇到栈溢出的错误，就是没写终止条件或者终止条件写的不对，操作系统也是用一个栈的结构来保存每一层递归的信息，如果递归没有终止，操作系统的内存栈必然就会溢出。
   3. **确定单层递归的逻辑：** 确定每一层递归需要处理的信息。在这里也就会重复调用自己来实现递归的过程。

**以下以前序遍历为例：**

1. **确定递归函数的参数和返回值**：因为要打印出前序遍历节点的数值，所以参数里需要传入vector在放节点的数值，除了这一点就不需要在处理什么数据了也不需要有返回值，所以递归函数返回类型就是void，代码如下：

```cpp
        void preorder(TreeNode root, List<Integer> res) 
```

1. **确定终止条件**：在递归的过程中，如何算是递归结束了呢，当然是当前遍历的节点是空了，那么本层递归就要要结束了，所以如果当前遍历的这个节点是空，就直接return，代码如下：

```cpp
            if (root == null) return;
```

1. **确定单层递归的逻辑**：前序遍历是中左右的循序，所以在单层递归的逻辑，是要先取中节点的数值，代码如下：

```cpp
            res.add(root.val);//中
            preorder(root.left, res);//前
            preorder(root.right, res);//后
```

单层递归的逻辑就是按照中左右的顺序来处理的，这样二叉树的前序遍历，基本就写完了，再看一下完整代码：



前序遍历：

```cpp
        void preorder(TreeNode root, List<Integer> res) {
            if (root == null) return;
            res.add(root.val);//中
            preorder(root.left, res);//前
            preorder(root.right, res);//后
        }
```

那么前序遍历写出来之后，中序和后序遍历就不难理解了，代码如下：

中序遍历：

```cpp
        void inorder(TreeNode root, List<Integer> res) {
            if (root == null) return;
            inorder(root.left, res);//前
            res.add(root.val);//中
            inorder(root.right, res);//后
        }
```

后序遍历：

```cpp
        void postorder(TreeNode root, List<Integer> res){
            if (root == null) return;
            postorder(root.left, res);//前
            postorder(root.right, res);//后
            res.add(root.val);//中
        }
```

## 迭代遍历

> **递归的实现就是：每一次递归调用都会把函数的局部变量、参数值和返回地址等压入调用栈中**，然后递归返回的时候，从栈顶弹出上一次递归的各项参数，所以这就是递归为什么可以返回上一层位置的原因。
>
> 此时大家应该知道我们用栈也可以是实现二叉树的前后中序遍历了。

前序遍历:

```java
    // 迭代遍历
    //通过栈来实现
    /*前序遍历是中左右，每次先处理的是中间节点，
    那么先将根节点放入栈中，然后将右孩子加入栈，再加入左孩子。
    为什么要先加入 右孩子，再加入左孩子呢？
    因为这样出栈的时候才是中左右的顺序。*/
    // 前序遍历顺序：中-左-右，入栈顺序：中-右-左，出栈顺序：中-左-右
    class Solution {
        public List<Integer> preorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            ArrayDeque<TreeNode> stack = new ArrayDeque<>();
            if (root == null) return res;
            stack.push(root);//将根节点放入栈
            while (!stack.isEmpty()) {
                TreeNode cur = stack.pop();
                res.add(cur.val);
                if (cur.right != null) stack.push(cur.right);
                if (cur.left != null) stack.push(cur.left);
            }
            return res;
        }
    }
```

中序遍历:

```java
    //通过栈实现迭代中序遍历
    //因为中序遍历的特殊性, 不是前序遍历简单就能转化过来的,需要多加修改.
    // 中序遍历顺序: 左-中-右 入栈顺序： 左-右
    class Solution {
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            ArrayDeque<TreeNode> stack = new ArrayDeque<>();
            TreeNode cur = root;
            while (cur != null || !stack.isEmpty()) {//判断条件多了一个当前节点不为空, 是因为可能左边最大子树遍历完后的情况
                if (cur != null){
                    stack.push(cur);//压栈
                    cur = cur.left;//继续深入   //左
                }else{
                    //开始返回了
                    cur = stack.pop();// 从栈里弹出的数据，就是要处理的数据（放进result数组里的数据）
                    res.add(cur.val);//中
                    cur = cur.right;//右
                }
            }
            return res;
        }
    }
```

后序遍历:

```java
    //后序遍历迭代方式
    //和前序遍历有点瓜葛, 可以通过前序遍历演变而来

    // 后序遍历顺序 左-右-中 入栈顺序：中-左-右 出栈顺序：中-右-左， 最后翻转结果
    class Solution {
        public List<Integer> postorderTraversal(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            ArrayDeque<TreeNode> stack = new ArrayDeque<>();
            if (root == null) return res;
            stack.push(root);

            while(!stack.isEmpty()){
                TreeNode cur = stack.pop();
                res.add(cur.val);
                if (cur.left != null) stack.push(cur.left);
                if (cur.right != null) stack.push(cur.right);
            }
            Collections.reverse(res);
            return res;
        }
    }
```

## 层序遍历

学会二叉树的层序遍历，可以一口气打完以下十题：

- [2022年7月29日17:18:46 - 二叉树的层序遍历 - 力扣（LeetCode）](https://leetcode.cn/problems/binary-tree-level-order-traversal/solution/2022nian-7yue-29ri-171846-by-ladidol-0ozc/)
- [2022年7月29日17:28:09 - 二叉树的层序遍历 II - 力扣（LeetCode）](https://leetcode.cn/problems/binary-tree-level-order-traversal-ii/solution/2022nian-7yue-29ri-172809-by-ladidol-qc38/)
- [2022年7月29日20:10:07 - 二叉树的右视图 - 力扣（LeetCode）](https://leetcode.cn/problems/binary-tree-right-side-view/solution/by-ladidol-gd2a/)
- [2022年7月29日20:28:32 - 二叉树的层平均值 - 力扣（LeetCode）](https://leetcode.cn/problems/average-of-levels-in-binary-tree/solution/2022nian-7yue-29ri-202832-by-ladidol-bn15/)
- [2022年7月29日20:51:52 - N 叉树的层序遍历 - 力扣（LeetCode）](https://leetcode.cn/problems/n-ary-tree-level-order-traversal/solution/2022nian-7yue-29ri-205152-by-ladidol-z1mh/)
- [2022年7月29日20:57:56 - 在每个树行中找最大值 - 力扣（LeetCode）](https://leetcode.cn/problems/find-largest-value-in-each-tree-row/solution/2022nian-7yue-29ri-205756-by-ladidol-8xet/)
- [2022年7月29日21:19:17 - 填充每个节点的下一个右侧节点指针 - 力扣（LeetCode）](https://leetcode.cn/problems/populating-next-right-pointers-in-each-node/solution/2022nian-7yue-29ri-211917-by-ladidol-lh05/)
- [2022年7月29日21:23:47 - 填充每个节点的下一个右侧节点指针 II - 力扣（LeetCode）](https://leetcode.cn/problems/populating-next-right-pointers-in-each-node-ii/solution/2022nian-7yue-29ri-212347-by-ladidol-yfws/)
- [2022年7月29日21:28:54 - 二叉树的最大深度 - 力扣（LeetCode）](https://leetcode.cn/problems/maximum-depth-of-binary-tree/solution/2022nian-7yue-29ri-212854-by-ladidol-093w/)
- [2022年7月29日21:46:06 - 二叉树的最小深度 - 力扣（LeetCode）](https://leetcode.cn/problems/minimum-depth-of-binary-tree/solution/2022nian-7yue-29ri-214606-by-ladidol-cap6/)

前面的一些前中后徐遍历：

- [2022年7月29日14:55:38 - 二叉树的前序遍历 - 力扣（LeetCode）](https://leetcode.cn/problems/binary-tree-preorder-traversal/solution/2022nian-7yue-29ri-145538-by-ladidol-0077/)
- [2022年7月29日15:00:52 - 二叉树的后序遍历 - 力扣（LeetCode）](https://leetcode.cn/problems/binary-tree-postorder-traversal/solution/2022nian-7yue-29ri-150052-by-ladidol-cfdt/)
- [2022年7月29日15:03:10 - 二叉树的中序遍历 - 力扣（LeetCode）](https://leetcode.cn/problems/binary-tree-inorder-traversal/solution/2022nian-7yue-29ri-150310-by-ladidol-kzeu/)
- [2022年7月30日00:19:45 - N 叉树的前序遍历 - 力扣（LeetCode）](https://leetcode.cn/problems/n-ary-tree-preorder-traversal/solution/2022nian-7yue-30ri-001945-by-ladidol-4saa/)
- [2022年7月30日00:22:18 - N 叉树的后序遍历 - 力扣（LeetCode）](https://leetcode.cn/problems/n-ary-tree-postorder-traversal/solution/2022nian-7yue-30ri-002218-by-ladidol-bz4d/)

> 需要借用一个辅助数据结构即队列来实现，**队列先进先出，符合一层一层遍历的逻辑，而是用栈先进后出适合模拟深度优先遍历也就是递归的逻辑。而这种层序遍历方式就是图论中的广度优先遍历，只不过我们应用在二叉树上。**使用队列实现二叉树广度优先遍历

图示:

![102二叉树的层序遍历](https://figurebed-ladidol.oss-cn-chengdu.aliyuncs.com/img/202207291659646.gif)

# 总结

层序遍历确实简单。



