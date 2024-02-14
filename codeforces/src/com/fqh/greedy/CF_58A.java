package com.fqh.greedy;

import java.io.*;
import java.util.*;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/14 21:41
 **/
public class CF_58A {


    public static void solve() throws IOException {
        String s = in.nextLine();
        var q = new ArrayDeque<Character>();
        q.offer('h');
        q.offer('e');
        q.offer('l');
        q.offer('l');
        q.offer('o');
        for (char c : s.toCharArray()) {
            if (q.isEmpty()) break;
            if (c == q.peek()) q.pop();
        }
        out.println(q.isEmpty() ? "YES" : "NO");
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
