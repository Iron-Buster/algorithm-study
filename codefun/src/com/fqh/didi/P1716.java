package com.fqh.didi;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/20 17:28
 **/
public class P1716 {

    // #P1716. 2024.3.17-滴滴-第一题-塔子哥的神秘花园
    //https://codefun2000.com/p/P1716

    public static void solve() throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] a = new int[m][2];
        for (int i = 0; i < m; i++) a[i][0] = in.nextInt();
        for (int i = 0; i < m; i++) a[i][1] = in.nextInt();
        int[] diff = new int[n + 2];
        for (int i = 0; i < m; i++) {
            int l = a[i][0], r = a[i][1];
            diff[l]++;
            diff[r+1]--;
        }
        int q = in.nextInt();
        int v = 0;
        int[] ans = new int[n + 1];
        for (int i = 0; i < n + 1; i++) {
            v += diff[i];
            ans[i] = v;
        }
        while (q-- > 0) {
            int idx = in.nextInt();
            out.print(ans[idx] + " ");
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
