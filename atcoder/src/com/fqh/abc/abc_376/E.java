package com.fqh.abc.abc_376;

import java.io.*;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class E {

    public static void solve() throws IOException {
        int n = in.nextInt();
        int k = in.nextInt();
        long[] a = new long[n];
        long[] b = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextLong();
        }
        for (int i = 0; i < n; i++) {
            b[i] = in.nextLong();
        }
        Integer[] ids = new Integer[n];
        for (int i = 0; i < n; i++) ids[i] = i;

        Arrays.sort(ids, (i, j) -> Long.compare(a[i], a[j]));
        var pq = new PriorityQueue<Long>((x, y) -> Long.compare(y, x)); // 维护前k-1小
        long ans = Long.MAX_VALUE;
        long sum = 0;
        for (int j = 0; j < n; j++) { // 枚举a[i]
            int i = ids[j];
            while (pq.size() > k) {
                sum -= pq.poll();
            }
            if (j >= k - 1) {
                long del = (j >= k ? pq.peek() : 0); // 第k小的暂时留着，因为它可能比b[i]小
                ans = Math.min(ans, a[i] * (sum - del + b[i]));
            }
            pq.offer(b[i]);
            sum += b[i];
        }
        out.println(ans);
    }

    static boolean MULTI_CASE = true;

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
