package com.fqh;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/15 11:43
 **/
public class CF_1701C {

//    https://codeforces.com/contest/1701/problem/C
//
//    输入 T(≤1e4) 表示 T 组数据。所有数据的 m 之和 ≤2e5。
//    每组数据输入 n m(1≤n≤m≤2e5) 和长为 m 的数组 a(1≤a[i]≤n)。
//
//    有 n 名工人和 m 个任务，a[i] 表示擅长第 i 个任务的工人编号。
//    每个任务只能分配给一名工人。如果工人擅长该任务，他会用 1 小时完成，否则需要 2 小时完成。
//    一名工人一次只能做一个任务，完成一个任务后，才能开始他的下一个任务。
//    所有工人同时开始工作。
//
//    输出完成所有任务最少要多少小时。


//    输入
//        4
//        2 4
//        1 2 1 2

//        2 4
//        1 1 1 1

//        5 5
//        5 1 3 2 4

//        1 1
//        1
//    输出
//        2
//        3
//        1
//        1

    public static boolean check(long x, int n, Map<Integer, Integer> cnt) {
        long remain = 0; // 剩余的任务
        for (int i = 1; i <= n; i++) {
            if (cnt.getOrDefault(i, 0) > x) {
                remain += cnt.get(i) - x;
            } else {
                // 可用剩余的时间做 (x-cnt[i]) / 2个工人不擅长的任务
                remain -= (x - cnt.getOrDefault(i, 0)) / 2;
            }
        }
        return remain <= 0;
    }
    public static void solve() throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();
        var cnt = new HashMap<Integer, Integer>();
        for (int i = 0; i < m; i++) {
            int x = in.nextInt();
            cnt.merge(x, 1, Integer::sum);
        }
        long l = 1;
        long r = (long) (4e10 + 1);
        while (l < r) {
            long mid = l + r >> 1;
            if (check(mid, n, cnt)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        out.println(l);
    }

    public static void main(String[] args) throws Exception {
        int T = in.nextInt();
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
