package trie._212WordSearchII;

import java.util.LinkedList;
import java.util.List;

class Solution3 {
    class TrieNode {
        String word;
        public TrieNode[] children = new TrieNode[26];

        public TrieNode() {
        }
    }

    public void buildTrie(TrieNode root, String word) {
        for (char c : word.toCharArray()) {
            if (root.children[c - 'a'] == null) {
                root.children[c - 'a'] = new TrieNode();
            }
            root = root.children[c - 'a'];
        }
        root.word = word;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new LinkedList<>();
        if (board == null || words == null) {
            return res;
        }
        TrieNode root = new TrieNode();
        for (String word : words) {
            buildTrie(root, word);
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, root, res, i, j);
            }
        }
        return res;
    }

    public void dfs(char[][] board, TrieNode root, List res, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return;
        }
        if (board[x][y] == '$') {
            return;
        }
        root = root.children[board[x][y] - 'a'];
        if (root == null) {
            return;
        }
        if (root.word != null) {
            res.add(root.word);
            root.word = null;
        }
        char temp = board[x][y];
        board[x][y] = '$';
        dfs(board, root, res, x + 1, y);
        dfs(board, root, res, x - 1, y);
        dfs(board, root, res, x, y + 1);
        dfs(board, root, res, x, y - 1);
        board[x][y] = temp;

        return;
    }
}
