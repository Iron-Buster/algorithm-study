package com.fqh.abc.abc_372;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class D {

    public static void solve() throws IOException {
        int n = in.nextInt();
        int[] h = new int[n];
        for (int i = 0; i < n; i++) {
            h[i] = in.nextInt();
        }
        int[] ans = new int[n];
        var stk = new ArrayDeque<Integer>();
        for (int i = n - 2; i >= 0; i--) {
            // 如果栈顶元素 < 当前值的下一个值 就要pop
            while (!stk.isEmpty() && h[stk.peek()] < h[i + 1]) {
                stk.pop();
            }
            stk.push(i + 1);
            ans[i] = stk.size();
        }
        for (int v : ans) out.print(v + " ");
        out.println();
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
