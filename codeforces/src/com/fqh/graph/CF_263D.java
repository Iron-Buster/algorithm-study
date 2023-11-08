package com.fqh.graph;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @Author: vq
 * @Date: 2023/11/7 22:19
 * @Version V1.0
 */
public class CF_263D {


    // 无向图: DFS 找长度至少为 k 的环

//    你有一个无向图 G ，由 n 个节点组成。我们将考虑用从 1 到 n 的整数索引图中的节点。
//    我们知道，图 G 中的每个节点都与该图中的至少 k 个其他节点有边相连。
//    你的任务是在给定的图中找出一个长度至少为 k+1 的简单循环。
//    长度为 d 的简单循环G 中长度为 d 的 简单循环是一连串不同的图节点 v1,v2,...,vd ，使得节点 v1 和 vd 由图中的一条边连接，
//    并且对于任意整数 i (1≤i<d) 节点 vi 也是如此。 (1≤i<d) 节点 vi 和 vi+1 由一条边连接。

    static final int MAXN = 200010;
    static int[] a = new int[MAXN];
    static int[] b = new int[MAXN];
    static boolean[] vis = new boolean[MAXN];

    static List<Integer>[] g;
    static int n;
    static int m;
    static int k;
    static int[] fa;
    static int[] dep;
    static int end;
    static int start;
    static boolean dfs(int v, int p, int d) {
        fa[v] = p;
        dep[v] = d;
        for (int w : g[v]) {
            if (dep[w] == 0) {
                if (dfs(w, v, d + 1)) {
                    return true;
                }
            } else if (d - dep[w] >= k) {
                end = v;
                start = w;
                return true;
            }
        }
        return false;
    }
    static void solve() throws Exception {
        n = in.nextInt();
        m = in.nextInt();
        k = in.nextInt();
        g = new List[n + 1];
        Arrays.setAll(g, e -> new ArrayList<>());
        while (m-- > 0) {
            int x = in.nextInt();
            int y = in.nextInt();
            g[x].add(y);
            g[y].add(x);
        }
        fa = new int[n + 1];
        dep = new int[n + 1];
        dfs(1, 0, 1);  // 节点从0开始应该这样写 dfs(0, -1, 1)
        List<Integer> cycle = new ArrayList<>();
        cycle.add(start);
        int v = end;
        for (; v != start; v = fa[v]) {
            cycle.add(v);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < cycle.size(); ++i) {
            sb.append(cycle.get(i)).append(" ");
        }
        out.println(cycle.size());
        out.println(sb.toString().trim());
    }

    public static void main(String[] args) throws Exception {
        int T = 1;
        while (T-- > 0) {
            solve();
        }
        out.close();
    }

    static class Pair implements Comparable<Pair> {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.x == o.x) {
                return this.y - o.y;
            }
            return this.x - o.x;
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
