package com.fqh.heap;

import java.io.*;
import java.util.*;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/5/25 15:18
 **/
public class CF_962D {

    // https://codeforces.com/problemset/problem/962/D

    public static void solve() throws IOException {
        int n = in.nextInt();
        var a = new long[n];
        var pq = new PriorityQueue<Integer>((i, j) -> a[i] != a[j] ? Long.compare(a[i], a[j]) : i - j);
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            pq.offer(i);
        }
        var ans = new ArrayList<Integer>();
        while (pq.size() > 1) {
            int p1 = pq.poll();
            int p2 = pq.poll();
            if (a[p1] == a[p2]) { // merge
                a[p2] *= 2;
                pq.offer(p2);
            } else {
                ans.add(p1);
                pq.offer(p2);
            }
        }
        if (!pq.isEmpty()) {
            ans.add(pq.peek());
        }
        Collections.sort(ans);
        out.println(ans.size());
        for (int i : ans) {
            out.print(a[i] + " ");
        }
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
