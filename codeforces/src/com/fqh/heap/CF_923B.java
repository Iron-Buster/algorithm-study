package com.fqh.heap;

import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2023/12/27 16:34
 **/
public class CF_923B {

//    https://codeforces.com/problemset/problem/923/B
//
//    输入 n(1≤n≤1e5)，长为 n 的数组 a(0≤a[i]≤1e9)，长为 n 的数组 t(0≤t[i]≤1e9)。
//
//    下雪啦！0x3F 每天都要堆一个雪人。
//    在第 i 天的开始，0x3F 会堆一个体积为 a[i] 的雪人。
//    第 i 天的温度是 t[i]，体积为 x 的雪人在这天会融化掉 min(t[i], x) 的体积。
//    第 i 天新堆的雪人和之前堆的雪人都会融化。
//
//    对于每一天，输出这一天所有雪人融化掉的体积之和。

//    输入
//        3
//        10 10 5
//        5 7 2
//    输出 5 12 4
//
//    输入
//        5
//        30 25 20 15 10
//        9 10 12 4 13
//    输出 9 20 35 11 25

    public static void solve() throws IOException {
        int n = in.nextInt();
        int[] a = new int[n];
        int[] t = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        for (int i = 0; i < n; i++) {
            t[i] = in.nextInt();
        }
        var pq = new PriorityQueue<Long>();
        long cur = 0;
        for (int i = 0; i < n; i++) {
            long ans = 0;
            pq.add(a[i] + cur);
            while (!pq.isEmpty() && pq.peek() <= cur + t[i]) {
                ans += pq.poll() - cur;
            }
            ans += 1L * t[i] * pq.size();
            cur += t[i];
            out.print(ans + " ");
        }
    }

    public static void main(String[] args) throws Exception {
        int T = 1;
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
