package dfs.and.bfs._116PopulatingNextRightPointersInEachNode;

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution2 {
    public Node connect(Node root) {
        connectNode(root, null);
        return root;
    }

    private void connectNode(Node currentNode, Node nextNode) {
        if (currentNode == null) {
            return;
        }
        currentNode.next = nextNode;
        connectNode(currentNode.left, currentNode.right);
        Node node = currentNode.next == null ? null : currentNode.next.left;
        connectNode(currentNode.right, node);
        return;
    }
}
