package com.feng.newline.datastructure;

import java.util.*;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.datastructure
 * @className: L385迷你语法分析器
 * @author: Ladidol
 * @description: 给定一个字符串 s 表示一个整数嵌套列表，实现一个解析它的语法分析器并返回解析的结果NestedInteger 。
 * 列表中的每个元素只可能是整数或整数嵌套列表
 * 示例 1：
 * <p>
 * 输入：s = "324",
 * 输出：324
 * 解释：你应该返回一个 NestedInteger 对象，其中只包含整数值 324。
 * 示例 2：
 * <p>
 * 输入：s = "[123,[456,[789]]]",
 * 输出：[123,[456,[789]]]
 * 解释：返回一个 NestedInteger 对象包含一个有两个元素的嵌套列表：
 * 1. 一个 integer 包含值 123
 * 2. 一个包含两个元素的嵌套列表：
 * i.  一个 integer 包含值 456
 * ii. 一个包含一个元素的嵌套列表
 * a. 一个 integer 包含值 789
 * @date: 2022/9/12 22:48
 * @version: 1.0
 */
@SuppressWarnings("All")// 只能说这题我也是整吐了。
public class L385迷你语法分析器 {

    // 自己没有模拟出来。
//    // 栈
//    class Solution {
//        // 看到对于括号嵌套的一半都是用栈来解决。
//        // 先加入栈中，然后如果碰到
//        public NestedInteger deserialize(String s) {
//            // 单个数字
//            if (s.charAt(0) != '[') return new NestedInteger(Integer.valueOf(s));
//            Stack<Character> stack = new Stack<>();
////            Stack<NestedInteger> NtStack = new Stack<>();
//            LinkedList<NestedInteger> NtStack = new LinkedList<>();
//
//            char[] chars = s.toCharArray();
//            for (char c : chars) {
//                if (c == ']') {
//                    StringBuilder num = new StringBuilder();
//                    NestedInteger integer = null;
//                    while (!stack.isEmpty()) {
//                        if (stack.peek() >= '0' && stack.peek() <= '9' || stack.peek() == '-') {
//                            num.append(stack.pop());//加入数字。
//                        } else if (stack.peek() == '[') {
//                            stack.pop();
//                            num.reverse();//变成正序。
//                            System.out.println("num = " + num.toString());
//                            integer = new NestedInteger(Integer.valueOf(num.toString()));//包括负数。
//                        } else if (!stack.isEmpty() && stack.peek() == ',') {
//                            stack.pop();
//                            break;
//                        }
//                    }
//                    NtStack.push(integer);//先把NestedInteger从内部一层一层加入stack中。
//                } else {
//                    stack.push(c);
//                }
//            }
//            System.out.println("NtStack = " + Arrays.toString(NtStack.toArray()));
//            NestedInteger nestedInteger = NtStack.peek();
//            for (int i = NtStack.size() - 2; i >= 0; i--) {
//                nestedInteger.add(NtStack.get(i));
//                nestedInteger = NtStack.get(i);
//            }
//            return NtStack.peek();
//        }
//    }


    // 栈模拟(这个嵌套Integer可以类比他就是list)
    // 可以通过示例："[123,[456,[789]],[456,[789]],[1000],123455]"来好好理解一下
    class Solution {
        // 从括号嵌套很容易发现要用到栈来模拟。
        // 这里需要压入栈的东西是NestedInteger。


        // 三叶姐的理解：
        // {栈
        // 每个 [ 的出现意味着存在一个嵌套类型的 NestedInteger 实例，同时每个 NestedInteger 实例（无论是嵌套类型还是数值类型）都归属于其最近一个左边的嵌套类型的 NestedInteger 实例（即其左边最近一个 [），
        // 因此我们可以使用栈来处理。
        // 对出现的几类字符进行简单分情况讨论：
        //  , ：跳过即可；
        //  - ： 或 数字：将连续段代表数值的字符串取出；
        //  [ ：创建一个嵌套类型的 NestedInteger 实例并压入栈中（未初始化）
        //  ] ：
        // 按照上述逻辑处理完整个 s，最终栈顶元素即是答案。}


        public NestedInteger deserialize(String s) {

            // 单个数字
            if (s.charAt(0) != '[') return new NestedInteger(Integer.parseInt(s));
            Deque<NestedInteger> stack = new ArrayDeque<>();
            int num = 0, fuhao = 1;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '-') fuhao = -1;
                else if (Character.isDigit(c)) num = num * 10 + (c - '0');//构造数字
                else if (c == '[') stack.push(new NestedInteger());//放入一层NestedInteger（未初始化）；
                else if (c == ',' || c == ']') {
                    //开始初始化这一层的NestedInteger；可能会往list中add很多的NestedInteger
                    if (Character.isDigit(s.charAt(i - 1))) {// 说实话这里为啥要用前一个来判断加不加入呢，有点模糊。我猜是为了如果前面是数字的话，就直接加进来。
                        stack.peek().add(new NestedInteger(num * fuhao));
                    }
                    // 完成了一个数字的加入list，初始化num和符号
                    num = 0;
                    fuhao = 1;
                    if (c == ']' && stack.size()>1) {//大小不小于一
                        NestedInteger cur = stack.pop();
                        stack.peek().add(cur);
                    }
                }
            }
            return stack.pop();
        }
    }

    // TODO: 2022/9/13 把这个递归方法看一下。 

    // 递归方法。
    //1. 首先判断s是否为空，为空直接返回；
    //2. s不为空的话看首字符是否为’[’，不是的话说明s为一个整数，我们直接返回结果。
    //3. 如果s中首字符是’[’，且s长度小于等于2，说明没有内容，直接返回结果。（’[‘或’[]’）
    //4. 如果s长度大于2，我们从i=1开始遍历，我们需要一个变量start来记录某一层的真实位置，用cnt来记录跟真实位置是否为同一深度，cnt=0表示同一深度，
    // 由于中间每段都是由逗号隔开，所以当我们判断当cnt为0，且当前字符是逗号或者已经到字符串末尾了，我们把start到当前位置之间的字符串取出来递归调用函数，把返回结果加入res中，
    // 然后start更新为i+1。如果遇到’[’，计数器cnt自增1，若遇到’]’，计数器cnt自减1。
    public NestedInteger deserialize(String s) {
        if (s == null || s.length() == 0) return new NestedInteger();
        if (s.charAt(0) != '[') return new NestedInteger(Integer.valueOf(s));// 只有一个数字的时候。
        if (s.length() <= 2) return new NestedInteger();//不要忘记s还可以只是个[]的空
        int start = 1, floor = 0;
        NestedInteger res = new NestedInteger();
        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (floor == 0 && (ch == ',' || i == s.length() - 1)) {
                res.add(deserialize(s.substring(start, i)));
                start = i + 1;
            }
            if (ch == '[') floor++;
            if (ch == ']') floor--;
        }
        return res;
    }



    /*↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓题中条件↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓*/


    // This is the interface that allows for creating nested lists.
    // You should not implement it, or speculate about its implementation
    class NestedInteger {
        // Constructor initializes an empty nested list.
        public NestedInteger() {

        }// 无参构造方法

        //         Constructor initializes a single integer.
        public NestedInteger(int value) {

        }// 有参构造方法

        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        public boolean isInteger() {
            return true;
        }

        ;

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        public Integer getInteger() {
            return 1;
        }

        // Set this NestedInteger to hold a single integer.
        public void setInteger(int value) {

        }

        // Set this NestedInteger to hold a nested list and adds a nested integer to it.
        public void add(NestedInteger ni) {

        }

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return empty list if this NestedInteger holds a single integer
        public List<NestedInteger> getList() {
            return new ArrayList<>();
        }
    }
}
