package com.fqh.数据结构设计;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/3 18:16
 **/
public class LC_225 {

    // https://leetcode.cn/problems/implement-stack-using-queues/description
    // 225. 用队列实现栈
    class MyStack {
        Deque<Integer> q;
        public MyStack() {
            q = new ArrayDeque<>();
        }

        public void push(int x) {
            q.addLast(x);
        }

        public int pop() {
            return q.pollLast();
        }

        public int top() {
            return q.peekLast();
        }

        public boolean empty() {
            return q.isEmpty();
        }
    }

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
}
