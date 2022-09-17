package com.feng.newline.datastructure;

import java.util.*;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.datastructure
 * @className: L726原子的数量
 * @author: Ladidol
 * @description: 给你一个字符串化学式 formula ，返回 每种原子的数量 。
 * 原子总是以一个大写字母开始，接着跟随 0 个或任意个小写字母，表示原子的名字。
 * 如果数量大于 1，原子后会跟着数字表示原子的数量。如果数量等于 1 则不会跟数字。
 * 例如，"H2O" 和 "H2O2" 是可行的，但 "H1O2" 这个表达是不可行的。
 * 两个化学式连在一起可以构成新的化学式。
 * 例如 "H2O2He3Mg4" 也是化学式。
 * 由括号括起的化学式并佐以数字（可选择性添加）也是化学式。
 * 例如 "(H2O2)" 和 "(H2O2)3" 是化学式。
 * 返回所有原子的数量，格式为：第一个（按字典序）原子的名字，跟着它的数量（如果数量大于 1），然后是第二个原子的名字（按字典序），跟着它的数量（如果数量大于 1），以此类推。
 * 示例 1：
 * <p>
 * 输入：formula = "H2O"
 * 输出："H2O"
 * 解释：原子的数量是 {'H': 2, 'O': 1}。
 * 示例 2：
 * <p>
 * 输入：formula = "Mg(OH)2"
 * 输出："H2MgO2"
 * 解释：原子的数量是 {'H': 2, 'Mg': 1, 'O': 2}。
 * @date: 2022/9/14 12:23
 * @version: 1.0
 */
public class L726原子的数量 {
//    class Solution {
//        public String countOfAtoms(String formula) {
//            Stack<Character> stack = new Stack<>();
//            TreeMap<Character, Integer> map = new TreeMap<>(new Comparator<Character>() {
//                @Override
//                public int compare(Character o1, Character o2) {
//                    return o1.compareTo(o2);//字典序。
//                }
//            });
//
//            char[] chars = formula.toCharArray();
//            for (int i = 0; i < chars.length; i++) {
//                char c = chars[i];
//
//                if (c == ')') {
//                    int k = chars[i + 1] - '0';
//                    while (!stack.isEmpty() && stack.peek() != '(') {
//                        map.put(stack.peek(), map.getOrDefault(stack.peek(), 0) + k - 1);//往回走一遍。
//                        stack.pop();
//                    }
//                    if (stack.peek() == '(') {
//                        stack.pop();
//                    }
//
//
//                } else if (Character.isDigit(c)) {
//                    for (int j = 1; j < c - '0'; j++) {//这里有个字符数组转换操作。
//                        stack.push(stack.peek());//重复加入。
//                        map.put(stack.peek(), map.get(stack.peek()) + 1);
//                    }
//                } else if (c == '(') {
//                    stack.push(c);
//                } else {
//                    stack.push(c);
//                    map.put(stack.peek(), map.getOrDefault(stack.peek(), 0) + 1);//初始化加入
//                }
//            }
//
//
//            return String.valueOf(map);
//        }
//    }

    // cv的一个
    class Solution {
        private char[] formula;

        private int index;

        /**
         * 给定一个化学式，输出所有原子的数量。
         * 格式为：第一个（按字典序）原子的名子，跟着它的数量（如果数量大于 1），
         * 然后是第二个原子的名字（按字典序），跟着它的数量（如果数量大于 1），
         * 以此类推。
         *
         * @param formula 化学式
         * @return java.lang.String
         */
        public String countOfAtoms(String formula) {
            Map<String, Integer> total = new HashMap<>(formula.length() / 2);
            this.formula = formula.toCharArray();
            this.index = 0;
            countOfAtoms(total);
            return atomsToString(new TreeMap<>(total));
        }

        private void countOfAtoms(Map<String, Integer> total) {
            int length = formula.length;
            while (index < length) {
                if (formula[index] == '(') {
                    HashMap<String, Integer> temporary = new HashMap<>((length - index) / 2);
                    index++;
                    countOfAtoms(temporary);
                    int tempCount = getCount();
                    temporary.forEach((key, value) -> {
                        int count = total.getOrDefault(key, 0);
                        count += value * tempCount;
                        total.put(key, count);
                    });
                } else if (formula[index] == ')') {
                    index++;
                    return;
                } else {
                    String atom = getAtom();
                    int count = getCount();
                    count += total.getOrDefault(atom, 0);
                    total.put(atom, count);
                }
            }
        }

        private String getAtom() {
            int length = formula.length;
            StringBuilder atom = new StringBuilder();
            atom.append(formula[index++]);
            while (index < length && Character.isLowerCase(formula[index])) {
                atom.append(formula[index++]);
            }
            return atom.toString();
        }

        private int getCount() {
            int length = formula.length;
            int count = 0;
            while (index < length && Character.isDigit(formula[index])) {
                count = count * 10 + (formula[index++] - '0');
            }
            return count == 0 ? 1 : count;
        }

        private String atomsToString(Map<String, Integer> countOfAtoms) {
            StringBuilder result = new StringBuilder();
            countOfAtoms.forEach((key, value) -> {
                result.append(key);
                int count = value;
                if (count != 1) {
                    result.append(count);
                }
            });
            return result.toString();
        }
    }

}
