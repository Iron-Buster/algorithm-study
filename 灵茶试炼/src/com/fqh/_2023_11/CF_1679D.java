package com.fqh._2023_11;

import java.io.*;
import java.util.*;

/**
 * @Author: vq
 * @Date: 2023/11/2 10:08
 * @Version V1.0
 */
public class CF_1679D {

//    https://codeforces.com/problemset/problem/1679/D
//
//    输入 n(1≤n≤2e5) m(0≤m≤2e5) k(1≤k≤1e18) 和长为 n 的数组 a(1≤a[i]≤1e9)。
//    然后输入 m 条边，每条边输入 x y，表示一条从 x 到 y 的有向边。节点编号从 1 开始。
//    保证图中无自环和重边。
//
//    如果图中不存在一条长为 k 的路径（路径有 k 个节点），输出 -1。
//    否则输出路径上的最大点权的最小值。
//    注意：你可以重复访问同一个节点。

//    二分答案 mx。
//
//    只考虑点权 <= mx 的点。
//    如果这些点组成的图是有环的，那么 check 为 true。
//    否则说明图是个 DAG，拓扑排序计算 DAG 的最长路，如果长度 >= k，那么 check 为 true。
//    否则 check 为 false。
//
//    优化：代码实现时，只需建一次图，不需要每次二分重新建图，这样可以更快一些。
//
//    https://codeforces.com/problemset/submission/1679/230820936


    static List<Integer>[] g;
    static int n, m;
    static long k;
    static int[] a;

    public static void solve() throws IOException {
        n = in.nextInt();
        m = in.nextInt();
        k = in.nextLong();
        a = new int[n + 1];
        int l = Integer.MAX_VALUE, r = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
            l = Math.min(l, a[i]);
            r = Math.max(r, a[i]);
        }
        g = new ArrayList[n + 1];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 0; i < m; i++) {
            int u = in.nextInt();
            int v = in.nextInt();
            g[u].add(v);
        }
        if (m == 0) {
            if (k == 1) out.println(l);
            else out.println(-1);
            return;
        }
        int ans = -1;
        while (l <= r) {
            int mid = l + r >> 1;
            if (check(mid)) {
                ans = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        out.println(ans);

    }

    public static boolean check(int target) {
        int[] ins = new int[n + 1];
        int cnt = n;
        for (int i = 1; i <= n; i++) {
            if (a[i] > target) {
                cnt--;
                continue;
            }
            for (int v : g[i]) {
                if (a[v] > target) continue;
                ins[v]++;
            }
        }
        Deque<Integer> que = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            if (ins[i] == 0 && a[i] <= target) que.addLast(i);
        }
        int[] f = new int[n + 1];
        Arrays.fill(f, 1);
        while (!que.isEmpty()) {
            int cur = que.pollFirst();
            cnt--;
            for (int v : g[cur]) {
                if (a[v] > target) continue;
                f[v] = Math.max(f[v], f[cur] + 1);
                if (f[v] >= k) return true;
                ins[v]--;
                if (ins[v] == 0) que.addLast(v);
            }
        }
        if (cnt > 0) return true;
        return false;
    }

    static boolean MULTI_CASE = false;


    public static void main(String[] args) throws IOException {
        if (MULTI_CASE) {
            int T = in.nextInt();
            for (int i = 0; i < T; ++i) {
                solve();
            }
        } else {
            solve();
        }
        out.flush();
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

/*

5 4
1 2 3 5
3 1 3 2
4 5 2 3
5 5 3 2
4 4 3 4

1 4
2 3
1 2  3 5

2 0 1
1 2
 */