package com.fqh.div4.ROUND_928;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/19 18:20
 **/
public class D {
    // 两数之和思想：a，b如果想在同一组，那么满足 INF ^ b = a
    // map计数，当前数x， map如果存在 INF ^ x，并且 cnt[INF^x] > 0的，那么可以组合为1组，否则必须单独一组
    static final int INF = Integer.MAX_VALUE;
    public static void solve() throws IOException {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.nextInt();
        var map = new HashMap<Integer, Integer>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(INF ^ a[i])) {
                int cnt = map.get(INF ^ a[i]);
                if (cnt > 0) { // 可以合并为1组
                    map.merge(INF ^ a[i], -1, Integer::sum); // INF ^ a[i]的使用次数-1
                    map.put(a[i], 0); // 当前a[i]不能被后面的某个数使用，因为存在 a b a这种case
                } else {
                    map.merge(a[i], 1, Integer::sum);
                    ans++;
                }
            } else {
                map.merge(a[i], 1, Integer::sum);
                ans++;
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
