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
        TreeSet<Integer> a = new TreeSet<>();
        TreeSet<Integer> b = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            a.add(x);
        }
        for (int i = 0; i < m; i++) {
            int x = in.nextInt();
            b.add(x);
        }
        int cnt = k / 2; // 从 a，b选cnt个数能否组成一个从 1-k的数组
        if (n < cnt || m < cnt) {
            out.println("NO");
            return;
        }
        int v1 = 0, v2 = 0;
        // 2 3 4 5 6
        // 1 3 8 10
        int vv1 = 0, vv2 = 0;
        boolean[] ok = new boolean[k + 1];
        for (int i = 1; i <= k; i++) {
            if (v1 == cnt && v2 == cnt) break;
            if (!a.contains(i) && !b.contains(i)) {
                out.println("NO");
                return;
            }
            if (v1 < cnt && a.contains(i) && !b.contains(i)) {
                v1++;
                ok[i] = true;
                continue;
            }
            if (v2 < cnt && b.contains(i) && !a.contains(i)) {
                v2++;
                ok[i] = true;
                continue;
            }
            if (a.contains(i) && b.contains(i)) {
                if (vv1 > vv2) {
                    ok[i] = true;
                    vv2++;
                    v2++;
                } else {
                    ok[i] = true;
                    vv1++;
                    v1++;
                }
            }
        }
        if (v1 != cnt || v2 != cnt) {
            out.println("NO");
            return;
        }
        for (int i = 1; i <= k; i++) {
            if (!ok[i]) {
                out.println("NO");
                return;
            }
        }
        out.println("YES");
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
