package trie._212WordSearchII;

import java.util.LinkedList;
import java.util.List;

class Solution {
    class Trie {
        class TrieNode {
            public TrieNode[] children = new TrieNode[26];
            public boolean isWord = false;

            public TrieNode() {
            }
        }

        TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode();
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] != null) {
                    node = node.children[c - 'a'];
                    continue;
                }
                return false;
            }
            return node.isWord;
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.isWord = true;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode node = root;
            for (char c : prefix.toCharArray()) {
                if (node.children[c - 'a'] != null) {
                    node = node.children[c - 'a'];
                    continue;
                }
                return false;
            }
            return true;
        }
    }

    public int[] dx = {1, -1, 0, 0};
    public int[] dy = {0, 0, 1, -1};

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new LinkedList<>();
        if (board == null || words == null) {
            return res;
        }
        Trie trie = new Trie();
        for (String str : words) {
            trie.insert(str);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, trie, new boolean[board.length][board[0].length], new String(), res, i, j);
            }
        }
        return res;
    }

    public void dfs(char[][] board, Trie dict, boolean[][] hasUsed, String str, List res, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return;
        }
        if (hasUsed[x][y] == true) {
            return;
        }
        str += board[x][y];
        if (!dict.startsWith(str)) {
            return;
        }
        if (dict.search(str)) {
            if (!res.contains(str)) {
                res.add(str);
            }
        }
        hasUsed[x][y] = true;
        dfs(board, dict, hasUsed, str, res, x + dx[0], y + dy[0]);
        dfs(board, dict, hasUsed, str, res, x + dx[1], y + dy[1]);
        dfs(board, dict, hasUsed, str, res, x + dx[2], y + dy[2]);
        dfs(board, dict, hasUsed, str, res, x + dx[3], y + dy[3]);
        hasUsed[x][y] = false;

        return;
    }
}
