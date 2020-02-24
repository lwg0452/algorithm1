package stack.and.queque._225ImplementStackUsingQueues;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    Queue<Integer> queue;
    int len;
    /** Initialize your data structure here. */
    public MyStack() {
        this.queue = new LinkedList<>();
        len = 0;
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.offer(x);
        len++;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        len--;
        for (int i = 0; i < len; i++){
            queue.offer(queue.poll());
        }
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        for (int i = 0; i < len-1; i++){
            queue.offer(queue.poll());
        }
        int res = queue.peek();
        queue.offer(queue.poll());
        return res;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.isEmpty();
    }
}

