package com.fqh;

import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/22 14:07
 **/
public class CF_1669F {

    // https://codeforces.com/contest/1669/problem/F

    // 求一遍前缀，后缀和，然后枚举后缀和，二分找最长的相等的前缀和
    public static void solve() throws IOException {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.nextInt();
        long[] s1 = new long[n+1];
        long[] s2 = new long[n+1];
        for (int i = 0; i < n; i++) {
            s1[i+1] = s1[i] + a[i];
        }
        for (int i = n - 1; i >= 0; i--) {
            s2[i] = s2[i+1] + a[i];
        }
        int ans = 0;
        for (int i = n; i >= 0; i--) {
            long t = s2[i];
            int l = 0, r = n;
            while (l <= r) {
                int mid = (l + r) >> 1;
                if (s1[mid] < t) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
            if (l <= i && s1[l] == t) {
                ans = Math.max(ans, n - i + l);
            }
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
