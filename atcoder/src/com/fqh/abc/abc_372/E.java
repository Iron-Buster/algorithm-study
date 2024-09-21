package com.fqh.abc.abc_372;

import java.io.*;
import java.util.*;

public class E {

//    AC
    public static void solve() throws IOException {
        int n = in.nextInt();
        int q = in.nextInt();
        List<Integer> ans = new ArrayList<>();
        UnionFind uf = new UnionFind(n);
        while (q-- > 0) {
            String[] s = in.nextLine().split(" ");
            int op = Integer.parseInt(s[0]);
            if (op == 1) {
                int u = Integer.parseInt(s[1]);
                int v = Integer.parseInt(s[2]);
                uf.merge(u, v);
            } else {
                int v = Integer.parseInt(s[1]);
                int k = Integer.parseInt(s[2]); // k很小，只有10

                int root = uf.find(v);
                PriorityQueue<Integer> pq = uf.pqs[root];
                if (pq.size() < k) {
                    ans.add(-1);
                    continue;
                }
                List<Integer> list = new ArrayList<>(pq);
                list.sort((x, y) -> y - x);
                ans.add(list.get(k - 1));
            }
        }
        for (int v : ans) {
            out.println(v);
        }
    }

    static class UnionFind {
        int[] fa;
        PriorityQueue<Integer>[] pqs;

        public UnionFind(int n) {
            this.fa = new int[n + 1]; // n+1
            this.pqs = new PriorityQueue[n + 1];
            for (int i = 1; i <= n; ++i) {
                fa[i] = i;
                pqs[i] = new PriorityQueue<>((a, b) -> a - b);
                pqs[i].add(i);
            }

        }

        // 非递归版本 查询 (路径压缩版)
        public int find(int x) {
            while (x != fa[x]) {
                fa[x] = fa[fa[x]];
                x = fa[x];
            }
            return x;
        }

        // 合并
        public void merge(int from, int to) {
            int x = find(from);
            int y = find(to);
            if (x == y) return;
            if (pqs[x].size() > pqs[y].size()) {
                for (int v : pqs[y]) {
                    pqs[x].add(v);
                    if (pqs[x].size() > 10) pqs[x].poll();
                }
                fa[y] = x;
            } else {
                for (int v : pqs[x]) {
                    pqs[y].add(v);
                    if (pqs[y].size() > 10) pqs[y].poll();
                }
                fa[x] = y;
            }
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
