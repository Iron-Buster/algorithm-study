package com.fqh.abc.abc_326;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @Author: vq
 * @Date: 2023/11/1 17:17
 * @Version V1.0
 */
public class C {

    /**
     * 8 6
     * 2 3 5 7 11 13 17 19
     * out: 4
     * 双指针
     */

    static final int MAXN = 200010;
    static int[] a = new int[MAXN];


    static void solve() throws Exception {
        int N = in.nextInt();
        int M = in.nextInt();
        var arr = new int[N];
        for (int i = 0; i < N; ++i) {
            arr[i] = in.nextInt();
        }
        Arrays.sort(arr);
        int ans = 0;
        int r = 0;
        for (int l = 0; l < N; ++l) {
            int x = arr[l];
            while (r < N && arr[r] < x + M) r++;
            ans = Math.max(ans, r - l);
        }
        out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        int t = 1;
        while (t-- > 0) {
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
