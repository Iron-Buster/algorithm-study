package com.fqh;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/29 23:04
 **/

import java.io.*;
import java.util.*;

/**
 * 树上差分
 */
public class TreeDiffTemplate {

}

// 1.点差分，初始树上各点点权为0，现在对路径(x,y)上的点均做 +1 操作，等价于
//               d_x + 1，d_y + 1，d_lca - 1，d_fa[lca] - 1
//  进行dfs，自底向上计算节点差分值的子树和（还原），恰好使得路径(x,y)上的点权均为1，
//  同时消除了对lca之上的节点的影响

// 2.边差分，初始树上各边边权为0，现在对路径(x,y)上的边均做 +1 操作，
// 直接对边权操作比较困难1，通常把边权下移给节点，变为点权操作。等价于
//               d_x + 1，d_y + 1，d_lca - 2
//  进行dfs，自底向上计算节点差分值的子树和（还原），恰好使得路径(x,y)上的边权均为1，
//  同时消除了对lca之上的节点的影响

// 点差分模板题
// https://www.luogu.com.cn/problem/P3128
class LG_P3128 {
    static final int N = 50005;
    static int[] dep = new int[N];
    static int[][] fa = new int[N][22];
    static int[] power = new int[N];
    static List<Integer>[] g;
    static int ans = 0;

    static void dfs(int u, int f) { // 倍增预处理
        dep[u] = dep[f] + 1;
        fa[u][0] = f;
        for (int i = 1; i <= 20; i++) {
            fa[u][i] = fa[fa[u][i-1]][i-1];
        }
        for (int v : g[u]) {
            if (v != f) {
                dfs(v, u);
            }
        }
    }
    static int lca(int u, int v) { // 倍增求lca
        if (dep[u] < dep[v]) {
            // swap(u, v)
            int temp = u;
            u = v;
            v = temp;
        }
        for (int i = 20; i >= 0; i--) {
            if (dep[fa[u][i]] >= dep[v]) {
                u = fa[u][i];
            }
        }
        if (u == v) return v;
        for (int i = 20; i >= 0; i--) {
            if (fa[u][i] != fa[v][i]) {
                u = fa[u][i];
                v = fa[v][i];
            }
        }
        return fa[u][0];
    }

    static void dfs2(int u, int f) {
        for (int v : g[u]) {
            if (v == f) continue;
            dfs2(v, u);
            power[u] += power[v];
        }
        ans = Math.max(ans, power[u]);
    }

    public static void solve() throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();
        g = new List[n+1];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 0; i < n - 1; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            g[x].add(y);
            g[y].add(x);
        }
        dfs(1, 0);
        while (m-- > 0) {
            int x = in.nextInt();
            int y = in.nextInt();
            int l = lca(x, y);
            ++power[x]; ++power[y]; // 树上差分
            --power[l]; --power[fa[l][0]];
        }
        dfs2(1, 0);
        out.println(ans);
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