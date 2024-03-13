package com.fqh.union_find;

import java.io.*;
import java.util.*;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/13 09:56
 **/
public class CF_1702E {


//    https://codeforces.com/problemset/problem/1702/E
//
//    输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
//    每组数据输入 n(2≤n≤2e5) 表示 n 块骨牌，每块骨牌上写有两个数。
//    然后输入 n 行，每行 2 个数，表示骨牌上的数字，范围 [1,n]。
//
//    你需要把这 n 块骨牌分成两组，使得每组内都不含重复数字。
//    能否做到？输出 YES 或 NO。
//
//    例如有 4 块骨牌：(1,4), (1,3), (3,2), (4,2)。
//    可以分成如下两组：
//    第一组：(1,4), (3,2)。
//    第二组：(1,3), (4,2)。

    public static void solve() throws IOException {
        int n = in.nextInt();
        List<Integer>[] g = new List[n+1];
        Arrays.setAll(g, v -> new ArrayList<>());
        for (int i = 0; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            g[x].add(y);
            g[y].add(x);
        }
        var uf = new UnionFind(n);
        for (int i = 1; i <= n; i++) {
            List<Integer> next = g[i];
            if (next.size() % 2 != 0) {
                out.println("NO");
                return;
            }
            for (int j : next) {
                uf.merge(i, j);
            }
        }
        var map = new HashMap<Integer, Integer>();
        for (int i = 1; i <= n; i++) {
            int fa = uf.find(i);
            map.merge(fa, 1, Integer::sum);
        }
        for (int cnt : map.values()) {
            if (cnt % 2 != 0) {
                out.println("NO");
                return;
            }
        }
        out.println("YES");
    }


    static class UnionFind {
        int[] fa;

        public UnionFind(int n) {
            fa = new int[n+1]; // 如果n从1开始，则n+1
            for (int i = 1; i <= n; i++) { // <= n
                fa[i] = i;
            }
        }

        public int find(int x) {
            while (x != fa[x]) {
                fa[x] = fa[fa[x]];
                x = fa[x];
            }
            return x;
        }

        public void merge(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);
            if (rootA == rootB) return;
            fa[rootB] = rootA;
        }
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
