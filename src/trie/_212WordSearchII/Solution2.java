package trie._212WordSearchII;

import java.util.LinkedList;
import java.util.List;

class Solution2 {
    class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        public boolean isWord = false;

        public TrieNode() {
        }
    }

    public int[] dx = {1, -1, 0, 0};
    public int[] dy = {0, 0, 1, -1};

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new LinkedList<>();
        if (board == null || words == null) {
            return res;
        }
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.children[c - 'a'] == null) {
                    node.children[c - 'a'] = new TrieNode();
                }
                node = node.children[c - 'a'];
            }
            node.isWord = true;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, root, new String(), new boolean[board.length][board[0].length], res, i, j);
            }
        }
        return res;
    }

    public void dfs(char[][] board, TrieNode root, String str, boolean[][] hasUsed, List res, int x, int y) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
            return;
        }
        if (hasUsed[x][y] == true) {
            return;
        }
        if (root.children[board[x][y] - 'a'] == null) {
            return;
        }
        str += board[x][y];
        if (root.children[board[x][y] - 'a'].isWord) {
            if (!res.contains(str)) {
                res.add(str);
            }
        }
        hasUsed[x][y] = true;
        dfs(board, root.children[board[x][y] - 'a'], str, hasUsed, res, x + dx[0], y + dy[0]);
        dfs(board, root.children[board[x][y] - 'a'], str, hasUsed, res, x + dx[1], y + dy[1]);
        dfs(board, root.children[board[x][y] - 'a'], str, hasUsed, res, x + dx[2], y + dy[2]);
        dfs(board, root.children[board[x][y] - 'a'], str, hasUsed, res, x + dx[3], y + dy[3]);
        hasUsed[x][y] = false;

        return;
    }
}