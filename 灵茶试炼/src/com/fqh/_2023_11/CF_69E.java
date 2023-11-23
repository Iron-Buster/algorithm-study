package com.fqh._2023_11;

import java.io.*;
import java.util.*;

/**
 * @Author: vq
 * @Date: 2023/11/23 9:31
 * @Version V1.0
 */
public class CF_69E {


    static final int MAXN = 200010;
    static int[] a = new int[MAXN];
    static int[] b = new int[MAXN];
    static boolean[] vis = new boolean[MAXN];
    static List<Integer>[] g;
    static int n;
    static int m;

//    https://codeforces.com/problemset/problem/69/E
//
//    输入 n k(1≤k≤n≤1e5) 和长为 n 的数组 a(-1e9≤a[i]≤1e9)。
//    对于每个长为 k 的连续子数组，输出子数组内的恰好出现一次的最大元素。如果不存在这样的元素，输出 Nothing。


//    定长滑动窗口。
//    用 map 维护窗口内的元素个数。
//    无论是移入窗口还是移出窗口，只要发现元素的出现次数等于 1，就把这个元素加到最大堆中。
//    输出答案之前，检查下堆顶元素的出现次数是否恰好为 1，如果不是则弹出堆顶（懒删除）。
//
//    https://codeforces.com/contest/69/submission/233292854
    static void solve() throws Exception {
        n = in.nextInt();
        int k = in.nextInt();
        for (int i = 0; i < n; ++i) a[i] = in.nextInt();
        var pq = new PriorityQueue<Integer>((a, b) -> b - a);
        var map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; ++i) {
            map.merge(a[i], 1, Integer::sum);
            if (map.get(a[i]) == 1) pq.offer(a[i]);
            if (i >= k - 1) {
                while (pq.size() > 0 && map.get(pq.peek()) != 1) {
                    pq.poll();
                }
                if (pq.size() > 0) {
                    out.println(pq.peek());
                } else {
                    out.println("Nothing");
                }
                int left = a[i - k + 1];
                map.merge(left, -1, Integer::sum);
                if (map.get(left) == 1) pq.offer(left);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int T = 1;
        while (T-- > 0) {
            solve();
        }
        out.close();
    }

    static class Pair implements Comparable<Pair> {
        int val;
        int cnt;

        public Pair(int val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.val == o.val) {
                return this.cnt - o.cnt;
            }
            return this.val - o.val;
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
