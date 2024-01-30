package com.fqh;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/24 15:09
 **/
public class LcaTemplate {
    //倍增求LCA模板
    static final int N  = (int) (5e5 + 10);
    static int n, m, s;
    static List<Integer>[] g = new List[N];
    static int[] dep = new int[N];
    static int[][] fa = new int[N][22];

    static void dfs(int u, int father) { //树增dep,fa
        dep[u] = dep[father] + 1;
        // 向上跳1，2，4...步的祖先节点
        fa[u][0] = father;
        for (int i = 1; i <= 20; i++) {
            fa[u][i] = fa[fa[u][i-1]][i-1];
        }
        for (int v : g[u]) {
            if (v != father) {
                dfs(v, u);
            }
        }
    }

    static int lca(int u, int v) {
        if (dep[u] < dep[v]) {
            // swap(u, v)
           int temp = u;
           u = v;
           v = temp;
        }
        //u先大步后小步向上跳，直到与v同层
        for (int i = 20; i >= 0; i--) {
            if (dep[fa[u][i]] >= dep[v]) {
                u = fa[u][i];
            }
        }
        if (u == v) return v;
        //u,v一起向上跳，直到lca的下面
        for (int i = 20; i >= 0; i--) {
            if (fa[u][i] != fa[v][i]) {
                u = fa[u][i];
                v = fa[v][i];
            }
        }
        return fa[u][0];
    }


    public static void solve() throws IOException {
        n = in.nextInt();
        m = in.nextInt();
        s = in.nextInt();
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            g[x].add(y);
            g[y].add(x);
        }
        dfs(s, 0);
        while (m-- > 0) {
            int a = in.nextInt();
            int b = in.nextInt();
            out.println(lca(a, b));
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

class LCA {
    //倍增求LCA模板
    static final int N  = (int) (5e5 + 10);
    int n, s;
    List<Integer>[] g = new List[N];
    int[] dep = new int[N];
    int[][] fa = new int[N][22];

    /**
     * dfs树上倍增
     * @param u
     * @param father
     */
    public void dfs(int u, int father) { //树增dep,fa
        dep[u] = dep[father] + 1;
        // 向上跳1，2，4...步的祖先节点
        fa[u][0] = father;
        for (int i = 1; i <= 20; i++) {
            fa[u][i] = fa[fa[u][i-1]][i-1];
        }
        for (int v : g[u]) {
            if (v != father) {
                dfs(v, u);
            }
        }
    }

    /**
     * 返回u和v的最近公共祖先
     * @param u
     * @param v
     * @return
     */
    public int lca(int u, int v) {
        if (dep[u] < dep[v]) {
            // swap(u, v)
            int temp = u;
            u = v;
            v = temp;
        }
        //u先大步后小步向上跳，直到与v同层
        for (int i = 20; i >= 0; i--) {
            if (dep[fa[u][i]] >= dep[v]) {
                u = fa[u][i];
            }
        }
        if (u == v) return v;
        //u,v一起向上跳，直到lca的下面
        for (int i = 20; i >= 0; i--) {
            if (fa[u][i] != fa[v][i]) {
                u = fa[u][i];
                v = fa[v][i];
            }
        }
        return fa[u][0];
    }

    /**
     * 返回node的第k个祖先
     * @param node
     * @param k
     * @return
     */
    public int getKthAncestor(int node, int k) {
        int m = 32 - Integer.numberOfLeadingZeros(k);
        for (int i = 0; i < m; i++) {
            if ((k >> i & 1) == 1) {
                node = fa[node][i];
                if (node == 0) // 跳出界了
                    break;
            }
        }
        return node;
    }

    public LCA(int n) {
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
    }
}

//https://loj.ac/p/10130
//#10130. 「一本通 4.4 例 1」点的距离
class LOJ_10130 {

    static LCA lca;

    public static void solve() throws IOException {
        int n = in.nextInt();
        lca = new LCA(n);
        for (int i = 0; i < n - 1; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            lca.g[x].add(y);
            lca.g[y].add(x);
        }
        lca.dfs(1, 0);
        int q = in.nextInt();
        while (q-- > 0) {
            int x = in.nextInt();
            int y = in.nextInt();
            int LCA = lca.lca(x, y);
            out.println(lca.dep[x] + lca.dep[y] - 2 * lca.dep[LCA]);
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