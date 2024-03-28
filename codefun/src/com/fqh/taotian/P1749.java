package com.fqh.taotian;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/28 20:52
 **/
public class P1749 {


//    http://101.43.147.120:8888/p/P1749
//    2024.03.27-阿里淘天-第一题-塔子哥打周赛

//    TreeSet居然只能拿72分???🥲 换小根堆就100

    public static void solve() throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();
        PriorityQueue<Long> pq = new PriorityQueue<>((a, b) -> Long.compare(a, b));
        long mx = 0;
        for (int i = 0; i < n; i++) {
            long x = in.nextLong();
            pq.offer(x);
            mx = Math.max(mx, x);
        }
        while (m-- > 0) {
            long v = in.nextLong();
            Long p = pq.poll();
            pq.offer(p + v);
            mx = Math.max(mx, p + v);
            out.println(mx);
        }
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
