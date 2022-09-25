package com.feng.newline.datastructure;

/**
 * @projectName: leetcode
 * @package: com.feng.newline.datastructure
 * @className: L1032字符流
 * @author: Ladidol
 * @description: 设计一个算法：接收一个字符流，并检查这些字符的后缀是否是字符串数组 words 中的一个字符串。
 * <p>
 * 例如，words = ["abc", "xyz"] 且字符流中逐个依次加入 4 个字符 'a'、'x'、'y' 和 'z' ，你所设计的算法应当可以检测到"axyz" 的后缀 "xyz" 与words 中的字符串 "xyz" 匹配。
 * 按下述要求实现 StreamChecker 类：
 * StreamChecker(String[] words) ：构造函数，用字符串数组words 初始化数据结构。
 * boolean query(char letter)：从字符流中接收一个新字符，如果字符流中的任一非空后缀能匹配 words 中的某一字符串，返回 true ；否则，返回 false。
 * 示例：
 * <p>
 * 输入：
 * ["StreamChecker", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query", "query"]
 * [[["cd", "f", "kl"]], ["a"], ["b"], ["c"], ["d"], ["e"], ["f"], ["g"], ["h"], ["i"], ["j"], ["k"], ["l"]]
 * 输出：
 * [null, false, false, false, true, false, true, false, false, false, false, false, true]
 * <p>
 * 解释：
 * StreamChecker streamChecker = new StreamChecker(["cd", "f", "kl"]);
 * streamChecker.query("a"); // 返回 False
 * streamChecker.query("b"); // 返回 False
 * streamChecker.query("c"); // 返回n False
 * streamChecker.query("d"); // 返回 True ，因为 'cd' 在 words 中
 * streamChecker.query("e"); // 返回 False
 * streamChecker.query("f"); // 返回 True ，因为 'f' 在 words 中
 * streamChecker.query("g"); // 返回 False
 * streamChecker.query("h"); // 返回 False
 * streamChecker.query("i"); // 返回 False
 * streamChecker.query("j"); // 返回 False
 * streamChecker.query("k"); // 返回 False
 * streamChecker.query("l"); // 返回 True ，因为 'kl' 在 words 中
 * 提示：
 * 1 <= words.length <= 2000
 * 1 <= words[i].length <= 200
 * words[i] 由小写英文字母组成
 * letter 是一个小写英文字母
 * 最多调用查询 4 * 104 次
 * @date: 2022/9/4 14:34
 * @version: 1.0
 */
public class L1032字符流 {

    // 小小来是试一试暴力解法
    class StreamChecker1 {

        String[] words;
        String str = "";

        public StreamChecker1(String[] words) {
            this.words = words;
        }

        public boolean query(char letter) {
            str = str + letter;
            for (String word : words) {
                if (str.endsWith(word)) return true;
            }
            return false;
        }
    }


    // Tries树
    class StreamChecker2 {
        // 一般字典树用来解决某个字符串或其前缀是否存在于一个字符串集合中
        //但本题这里是检查后缀是否存在于集合中，因此只需要反向添加字符串到字典树中，然后判断的时候也反向从后往前判断即可。
        TrieNode root = new TrieNode();
        //        String str = "";
        StringBuilder sb = new StringBuilder();//用StringBuilder就是快！！！

        public StreamChecker2(String[] words) {
            for (String word : words) {
                reverseInsert(word);
            }
        }

        public boolean query(char letter) {
            sb = sb.append(letter);
            TrieNode cur = root;

            for (int i = sb.length() - 1; i >= 0; i--) {
                int idx = sb.charAt(i) - 'a';
                if (cur.next[idx] == null) return false;
                else if (cur.next[idx].isWord) return true;
                cur = cur.next[idx];
            }
            return cur.isWord;// 必须找到是里面的单词。
        }


        // trie树节点
        class TrieNode {
            boolean isWord;
            TrieNode[] next = new TrieNode[26];
        }


        //倒序插入
        public void reverseInsert(String word) {
            TrieNode cur = root;
            for (int i = word.length() - 1; i >= 0; i--) {
                int idx = word.charAt(i) - 'a';
                if (cur.next[idx] == null) cur.next[idx] = new TrieNode();
                cur = cur.next[idx];
            }
            cur.isWord = true;// 更新当前节点可以作为结束。
        }
    }

    // 2022年9月25日19:25:54再做这一题
    class StreamChecker {

        StringBuilder liu = new StringBuilder();

        public StreamChecker(String[] words) {
            for (String word : words) {
                reverseInsert(word);
            }
        }

        public boolean query(char letter) {//注意查询是查询words中有没有是liu中的前缀的。需要加一步判断isWord。
            liu.append(letter);
            TrieNode cur = root;
//            char[] chars = liu.toString().toCharArray();
            for (int i = liu.length() - 1; i >= 0; i--) {
//                int index = chars[i] - 'a';
                int index = liu.charAt(i) - 'a';//直接用StringBuilder.charAt（）会快一点。
                if (cur.nextLetter[index] == null) return false;
                else if (cur.nextLetter[index].isWord) return true;//找到一个前缀。
                cur = cur.nextLetter[index];//维护当前节点指针。
            }
            return cur.isWord;//看一下是不是一个前缀。
        }

        class TrieNode {
            boolean isWord;
            TrieNode[] nextLetter = new TrieNode[26];
        }

        TrieNode root = new TrieNode();

        void reverseInsert(String word) {
            TrieNode cur = root;
            char[] chars = word.toCharArray();
            for (int i = word.length() - 1; i >= 0; i--) {
                int index = chars[i] - 'a';
                if (cur.nextLetter[index] == null) cur.nextLetter[index] = new TrieNode();
                cur = cur.nextLetter[index];//维护当前节点指针。
            }
            cur.isWord = true;
        }
    }


}
