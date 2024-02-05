package com.fqh.contest.ROUND_31;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/5 11:37
 **/
public class D {

    // 双向链表 + 哈希表
    static class Structure {
        static class Node {
            public Node left, right;
            int val;
            public Node() {}
            public Node(int val) {
                this.val = val;
            }
        }

        Map<Integer, Node> hash = new HashMap<>(); // 方便快速定位结点
        Node head, tail;

        public Structure() {
            head = new Node();
            tail = new Node();
            head.right = tail;
            tail.left = head;
        }

        void add(int x, int y) {    // O(1)
            Node yn = hash.get(y);
            Node cur = new Node(x);
            Node second = yn.right;
            yn.right = cur;
            cur.left = yn;
            cur.right = second;
            second.left = cur;
            hash.put(x, cur);
        }

        void addHead(int x) {
            Node cur = new Node(x);
            Node second = head.right;
            head.right = cur;
            cur.left = head;
            cur.right = second;
            second.left = cur;
            hash.put(x, cur);
        }

        void remove(int x) {    // O(1)
            Node xn = hash.get(x);
            Node left = xn.left, right = xn.right;
            left.right = right;
            right.left = left;
            hash.remove(x);
        }

        List<Integer> toList() {
            List<Integer> res = new ArrayList<>();
            Node iter = head.right;
            while (iter != tail) {
                res.add(iter.val);
                iter = iter.right;
            }
            return res;
        }

    }

    public static void solve() throws IOException {
        int q = in.nextInt();
        Structure st = new Structure();
        while (q-- > 0) {
            int op = in.nextInt();
            int x = in.nextInt();
            if (op == 1) { // 将x插入在y的右边
                int y = in.nextInt();
                if (y == 0) {
                    st.addHead(x);
                } else {
                    st.add(x, y);
                }
            } else { // 删除x
                st.remove(x);
            }
        }
        List<Integer> res = st.toList();
        out.println(res.size());
        out.println(res.stream().map(String::valueOf).collect(Collectors.joining(  " ")));
    }

    static boolean MULTI_CASE = false;
    public static void main(String[] args) throws Exception {
        int T = MULTI_CASE ? in.nextInt() : 1;
        while (T-- > 0) {
            solve();
        }
        out.close();
    }

    static InputReader in = new InputReader();
    static PrintWriter out = new PrintWriter(new OutputStreamWriter(System.out));
    static class InputReader {
        private StringTokenizer st;
        private BufferedReader bf;

        public InputReader() {
            bf = new BufferedReader(new InputStreamReader(System.in));
            st = null;
        }

        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens()) {
                st = new StringTokenizer(bf.readLine());
            }
            return st.nextToken();
        }

        public String nextLine() throws IOException {
            return bf.readLine();
        }

        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }

        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }

        public double nextDouble() throws IOException {
            return Double.parseDouble(next());
        }
    }
}
