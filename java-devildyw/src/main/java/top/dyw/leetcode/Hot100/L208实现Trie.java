package top.dyw.leetcode.Hot100;

public class L208实现Trie {
    private class TrieNode {
        private TrieNode[] children;
        private boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i<word.length(); i++) {
            char c = word.charAt(i);
            int index = c - 'a';
            if (node.children[index]==null) {
                node.children[index] = new TrieNode();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = searchPrefix(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = searchPrefix(prefix);
        return node!=null;
    }

    public TrieNode searchPrefix(String prefix) {
        TrieNode node = root;
        for (int i =0; i<prefix.length(); i++) {
            int index = prefix.charAt(i) - 'a';
            if (node.children[index]==null) {
                return null;
            }
            node = node.children[index];
        }
        return node;
    }
}
