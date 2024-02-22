package com.fqh.hashamp;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/22 17:25
 **/
public class CF_1520D {

//    给你一个由 n 个整数组成的数组 a 。请数出索引 (i, j) 中有多少对索引 ij, a_j - a_i = j - i 。
//    移动一下等式就行： i - a_i = j - a_j 用map计数
    public static void solve() throws IOException {
        int n = in.nextInt();
        int[] a = new int[n+1];
        for (int i = 1; i <= n; i++) a[i] = in.nextInt();
        var map = new HashMap<Integer, Integer>();
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += map.getOrDefault(i - a[i], 0);
            map.merge(i - a[i], 1, Integer::sum);
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
