package com.fqh.双指针;

import java.io.*;
import java.util.*;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/1 16:33
 **/
public class CF_1133C {

    //https://codeforces.com/problemset/problem/1133/C
    public static void solve() throws IOException {
        int n = in.nextInt();
        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = in.nextLong();
        Arrays.sort(a); // 排序让数字紧凑
        int j = 0;
        var ll = new TreeSet<Long>();
        var map = new HashMap<Long, Integer>();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ll.add(a[i]);
            map.merge(a[i], 1, Integer::sum);
            while (ll.last() - ll.first() > 5) {
                map.merge(a[j], -1, Integer::sum);
                if (map.get(a[j]) == 0) {
                    ll.remove(a[j]);
                    map.remove(a[j]);
                }
                j++;
            }
            ans = Math.max(ans, i - j + 1);
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
