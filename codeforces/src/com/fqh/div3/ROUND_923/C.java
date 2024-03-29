package com.fqh.div3.ROUND_923;

import java.io.*;
import java.util.*;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/6 22:32
 **/
public class C {


    public static void solve() throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        int[] b = new int[m];
        var ll = new HashMap<Integer, Integer>();
        var rr = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            ll.merge(a[i], 1, Integer::sum);
        }
        for (int i = 0; i < m; i++) {
            b[i] = in.nextInt();
            rr.merge(b[i], 1, Integer::sum);
        }
        int cnt1 = k / 2, cnt2 = k / 2, sum = 0;
        for (int i = 1; i <= k; i++) {
            if (!ll.containsKey(i) && !rr.containsKey(i)) {
                out.println("NO");
                return;
            } else if (ll.containsKey(i) && !rr.containsKey(i)) {
                --cnt1;
            } else if (rr.containsKey(i) && !ll.containsKey(i)) {
                --cnt2;
            } else {
                ++sum;
            }
        }
        if (cnt1 < 0 || cnt2 < 0) {
            out.println("NO");
        } else {
            out.println("YES");
        }
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
