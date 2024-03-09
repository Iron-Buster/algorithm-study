package com.fqh.meituan;

import java.io.*;
import java.util.*;


/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/9 13:51
 **/
public class P1683 {

    public static void solve() throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();
        int q = in.nextInt();
        var uf = new UnionFind(n);
        var map = new HashMap<Integer, HashSet<Integer>>();
        for (int i = 0; i < m; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            map.computeIfAbsent(x, v -> new HashSet<>()).add(y);
            map.computeIfAbsent(y, v -> new HashSet<>()).add(x);
        }
        List<int[]> ops = new ArrayList<>();
        var delSet = new HashSet<String>();
        for (int i = 0; i < q; i++) {
            int op = in.nextInt();
            int x = in.nextInt();
            int y = in.nextInt();
            ops.add(new int[]{op, x, y});
            if (op == 1) {
                if (map.get(x).contains(y)) {
                    delSet.add(x + "_" + y);
                }
                if (map.get(y).contains(x)) {
                    delSet.add(y + "_" + x);
                }
            }
        }
        for (int u = 1; u <= n; u++) {
            for (int v : map.get(u)) {
                if (delSet.contains(u + "_" + v) || delSet.contains(v + "_" + u)) {
                    continue;
                }
                uf.merge(u, v);
            }
        }
        List<String> ans = new ArrayList<>();
        for (int i = q - 1; i >= 0; i--) {
            int[] p = ops.get(i);
            if (p[0] == 2) {
                int x = p[1], y = p[2];
                if (uf.find(x) == uf.find(y)) {
                    ans.add("YES");
                } else {
                    ans.add("NO");
                }
            }
        }
        Collections.reverse(ans);
        for (String x : ans) out.println(x);
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
