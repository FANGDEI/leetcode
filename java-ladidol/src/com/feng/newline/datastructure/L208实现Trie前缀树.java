package com.feng.newline.datastructure;

import java.util.Arrays;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.datastructure
 * @className: L208实现Trie前缀树
 * @author: Ladidol
 * @description: Trie（发音类似 "try"）或者说 前缀树 是一种树形数据结构，用于高效地存储和检索字符串数据集中的键。这一数据结构有相当多的应用情景，例如自动补完和拼写检查。
 * 请你实现 Trie 类：
 * Trie() 初始化前缀树对象。
 * void insert(String word) 向前缀树中插入字符串 word 。
 * boolean search(String word) 如果字符串 word 在前缀树中，返回 true（即，在检索之前已经插入）；否则，返回 false 。
 * boolean startsWith(String prefix) 如果之前已经插入的字符串 word 的前缀之一为 prefix ，返回 true ；否则，返回 false 。
 * <p>
 * 示例：
 * <p>
 * 输入
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * 输出
 * [null, null, true, false, true, null, true]
 * <p>
 * 解释
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // 返回 True
 * trie.search("app");     // 返回 False
 * trie.startsWith("app"); // 返回 True
 * trie.insert("app");
 * trie.search("app");     // 返回 True
 * @date: 2022/9/4 19:43
 * @version: 1.0
 */
public class L208实现Trie前缀树 {

    public static void main(String[] args) {
//        Trie trie = new Trie();
//        trie.insert("boy");
//        trie.search("apple");   // 返回 True
//        trie.search("app");     // 返回 False
//        trie.startsWith("app"); // 返回 True
//        trie.insert("app");
//        trie.search("app");     // 返回 True
//
//        int[][] tries = trie.trie;
//        for (int i = 0; i < tries.length; i++) {
//            System.out.println(Arrays.toString(tries[i]));
//        }
//        System.out.println("trie.count = " + Arrays.toString(trie.count));

    }

    // 二维数组
    class Trie1 {
        // 以下可以 static 成员独一份，被创建的多个 Trie 共用
        int N = 9; // 直接设置为十万级，trie[]来存储我们所有的单词字符
        int[][] trie = new int[N][26];// 自增记录我们到底用了多少个格子（相当于给被用到格子进行编号）
        int[] count = new int[N];// 记录某个格子被「被标记为结尾的次数」（当 idx编号的格子被标记了 n次，则有 cnt[idx] = n
        int index = 0;

        // 在构造方法中完成重置 static 成员数组的操作
        // 这样做的目的是为减少 new 操作（无论有多少测试数据，上述 static 成员只会被 new 一次）
        public Trie1() {
            for (int[] row : trie) {
                Arrays.fill(row, 0);
            }
            Arrays.fill(count, 0);
            index = 0;
        }

        public void insert(String word) {
            int p = 0;// 结尾格子
            char[] chars = word.toCharArray();
            for (char c : chars) {
                int u = c - 'a';
                if (trie[p][u] == 0) trie[p][u] = ++index;
                p = trie[p][u];
            }
            count[p]++;
        }

        public boolean search(String word) {
            int p = 0;// 结尾格子
            char[] chars = word.toCharArray();
            for (char c : chars) {
                int u = c - 'a';
                if (trie[p][u] == 0) return false;
                p = trie[p][u];
            }
            return count[p] != 0;
        }

        public boolean startsWith(String prefix) {
            int p = 0;// 结尾格子
            char[] chars = prefix.toCharArray();
            for (char c : chars) {
                int u = c - 'a';
                if (trie[p][u] == 0) return false;
                p = trie[p][u];
            }
            return true;
        }
    }


    // TireNode节点
    class Trie2 {

        // trie树节点
        class TrieNode {
            boolean isWord;
            TrieNode[] next = new TrieNode[26];
        }

        TrieNode root;

        public Trie2() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode cur = root;
            char[] chars = word.toCharArray();
            for (char c : chars) {// 如链表一样一个接一个。
                int idx = c - 'a';
                if (cur.next[idx] == null) cur.next[idx] = new TrieNode();
                cur = cur.next[idx];
            }
            cur.isWord = true;// 更新当前节点可以作为结束。
        }

        public boolean search(String word) {
            TrieNode cur = root;
            char[] chars = word.toCharArray();
            for (char c : chars) {
                int idx = c - 'a';
                if (cur.next[idx] == null) return false;
                cur = cur.next[idx];
            }
            return cur.isWord;// 查看当前节点是不是可以作为结束。
        }

        public boolean startsWith(String prefix) {
            TrieNode cur = root;
            char[] chars = prefix.toCharArray();
            for (char c : chars) {
                int idx = c - 'a';
                if (cur.next[idx] == null) return false;
                cur = cur.next[idx];
            }
            return true;// 只要前面都没有问题，就是prefix。
        }
    }


    //2022年9月25日19:06:43 再做这一题
    class Trie {

        class TrieNode {
            boolean isWord;
            TrieNode[] nextLetter = new TrieNode[26];
        }

        TrieNode root;//必须存在一个根节点。

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode curNode = root;
            char[] chars = word.toCharArray();
            for (char c : chars) {
                int index = c - 'a';
                if (curNode.nextLetter[index] == null) curNode.nextLetter[index] = new TrieNode();
                curNode = curNode.nextLetter[index];//维护当前节点指针。
            }

            curNode.isWord = true;//插入的时候需要，将其命名为单词哦。


        }

        public boolean search(String word) {
            TrieNode curNode = root;
            char[] chars = word.toCharArray();
            for (char c : chars) {
                int index = c - 'a';
                if (curNode.nextLetter[index] == null) return false;//说明不匹配咯。
                curNode = curNode.nextLetter[index];//继续维护当前节点指针。
            }
            return curNode.isWord;//看看有没有在这里结尾的单词咯
        }

        public boolean startsWith(String prefix) {
            TrieNode curNode = root;
            char[] chars = prefix.toCharArray();
            for (char c : chars) {
                int index = c - 'a';
                if (curNode.nextLetter[index] == null) return false;
                curNode = curNode.nextLetter[index];
            }
            return true;//前缀判定通过。
        }
    }

}




