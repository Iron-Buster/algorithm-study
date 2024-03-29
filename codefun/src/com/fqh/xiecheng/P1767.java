package com.fqh.xiecheng;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/29 21:05
 **/
public class P1767 {

//    #P1757. 2024.03.28-携程-第三题-塔子哥除2
//    http://101.43.147.120:8888/p/P1757


    // 滑动窗口维护偶数区间，枚举每个区间除2后的最大值，可以使用前缀和快速求区间[i:j]的和
    public static void solve() throws IOException {
        int n = in.nextInt();
        long[] a = new long[n];
        boolean ok = true;
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            if (a[i] < 0) ok = false;
        }
        long sum = Arrays.stream(a).sum();
        if (ok) { // 没有负数，显然不操作就是最大的
            out.println(sum);
            return;
        }
        int l = 0, r = 0;
        long ans = Long.MIN_VALUE;
        while (l < n) {
            while (l < n && a[l] % 2 != 0) l++;
            if (l < n) {
                r = l;
                while (r < n && a[r] % 2 == 0) r++;
                long v = 0;
                while (l < r) {
                    v += a[l];
                    if (v < 0) {
                        ans = Math.max(ans, sum - v / 2);
                    } else {
                        v = 0;
                    }
                    l++;
                }
            }
        }
        out.println(ans);
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
