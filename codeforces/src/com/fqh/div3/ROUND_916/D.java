package com.fqh.div3.ROUND_916;

import java.io.*;
import java.util.*;

/**
 * @Author: vq
 * @Date: 2023/12/19 23:21
 * @Version V1.0
 */
public class D {


    static final int MAXN = 200010;
    static int[] a = new int[MAXN];
    static int[] b = new int[MAXN];
    static boolean[] vis = new boolean[MAXN];
    static List<Integer>[] g;
    static int n;
    static int m;

    //每种活动找最大的三天然后暴力枚举所有可能判断是否可行更新答案即可.
    static void solve() throws Exception {
        int n = in.nextInt();
        Pair[] a = new Pair[n];
        Pair[] b = new Pair[n];
        Pair[] c = new Pair[n];
        for (int i = 0; i < n; i++) {
            a[i] = new Pair(in.nextInt(), i + 1);
        }
        for (int i = 0; i < n; i++) {
            b[i] = new Pair(in.nextInt(), i + 1);
        }
        for (int i = 0; i < n; i++) {
            c[i] = new Pair(in.nextInt(), i + 1);
        }
        Arrays.sort(a);
        Arrays.sort(b);
        Arrays.sort(c);
        int ans = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if (a[i].index != b[j].index && a[i].index != c[k].index && b[j].index != c[k].index) {
                        ans = Math.max(ans, a[i].value + b[j].value + c[k].value);
                    }
                }
            }
        }
        out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        int T = in.nextInt();
        while (T-- > 0) {
            solve();
        }
        out.close();
    }

    static class Pair implements Comparable<Pair> {
        int value;
        int index;

        public Pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(o.value, this.value);
        }
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
