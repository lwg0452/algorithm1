package LRU.cache;

class LRUCache {
    class MemoryNode {
        int key;
        int value;
        MemoryNode pre;
        MemoryNode next;
    }

    MemoryNode head;
    MemoryNode tail;
    int cap;
    int len;

    public LRUCache(int capacity) {
        head = new MemoryNode();
        tail = new MemoryNode();
        head.next = tail;
        tail.pre = head;
        cap = capacity;
        len = 0;
    }

    private boolean removeNode(MemoryNode rNode) {
        boolean res = false;
        MemoryNode node = head;
        for (int i = 0; i < len; i++) {
            node = node.next;
            if (node.key == rNode.key) {
                res = true;
                rNode.value = node.value;
                rNode.pre = node.pre;
                rNode.next = node.next;
                //删除
                node.pre.next = node.next;
                node.next.pre = node.pre;
                len--;
                break;
            }
        }
        return res;
    }

    private void addNode(MemoryNode node) {
        if (len == cap) {
            MemoryNode tailNode = tail.pre;
            tailNode.pre.next = tail;
            tail.pre = tailNode.pre;
            len--;
        }
        node.pre = head;
        node.next = head.next;
        head.next.pre = node;
        head.next = node;
        len++;
    }

    public int get(int key) {
        MemoryNode node = new MemoryNode();
        node.key = key;
        boolean exist = removeNode(node);
        if (exist == false) {
            return -1;
        }
        addNode(node);
        return node.value;
    }

    public void put(int key, int value) {
        MemoryNode node = new MemoryNode();
        node.key = key;
        removeNode(node);
        node.value = value;
        addNode(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */