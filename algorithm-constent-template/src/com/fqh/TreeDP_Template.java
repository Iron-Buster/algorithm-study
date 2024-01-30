package com.fqh;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/30 23:18
 **/
public class TreeDP_Template {
}

/**
 * 树形DP-树的重心
 */
class TreeDP_CASE1 {
    static List<Integer>[] g;
    static int ans;
    static int n;
    static int dfs(int u, int fa) {
        int size = 0; // 记录u的最大子树的结点数
        int sum = 1; // 记录以u为根的子树的结点数
        for (int v : g[u]) {
            if (v == fa) continue;
            int s = dfs(v, u);          // s是以v为根的子树的结点数
            size = Math.max(size, s);   // 记录以u为根的最大子树的结点数
            sum += s;                   // 累加u的各个子树的结点数
        }
        ans = Math.min(ans, Math.max(ans, n - size));
        return sum;
    }
    public static void solve() throws IOException {
        n = in.nextInt();
        g = new List[n+1];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 1; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            g[x].add(y);
            g[y].add(x);
        }
        dfs(1, 0);
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

/**
 * 树形DP-树的直径
 */
class TreeDP_CASE2 {
    static List<int[]>[] g;
    static int ans;
    static int n;

    static int dfs(int u, int fa) {
        int d1 = 0; // 以u为根的最大长度
        int d2 = 0; // 以u为根的次大长度
        for (int[] next : g[u]) {
            int v = next[0];
            int len = next[1];
            if (v == fa) continue;
            int d = dfs(v, u) + len;
            if (d >= d1) { // 更新d1，d2
                d2 = d1;
                d1 = d;
            } else if (d > d2) {
                d2 = d; // 更新d2
            }
        }
        ans = Math.max(ans, d1 + d2);
        return d1;
    }

    public static void solve() throws IOException {
        n = in.nextInt();
        g = new List[n+1];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 1; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            int len = in.nextInt();
            g[x].add(new int[]{y, len});
            g[y].add(new int[]{x, len});
        }
        dfs(1, 0);
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

/**
 * 树形DP-树的中心（换根DP）
 */
class ReRootDP {
}
//https://www.luogu.com.cn/problem/P3478
// 换根DP
class LG_P3478 {
    static int n;
    static List<Integer>[] g;
    static int[] dep;
    static int[] sz;
    static int[] f;

    // dfs 预处理，求出每颗子树的大小sz[i]，以 1 号点为根时所有结点的深度之和 f[1]
    static void dfs(int u, int fa) {
        dep[u] = dep[fa] + 1;
        f[1] += dep[u];
        sz[u] = 1;
        for (int v : g[u]) {
            if (v == fa) continue;
            dfs(v, u);
            sz[u] += sz[v];
        }
    }
    //dfs2 换根时，f[u]→f[v]
    //在 v 的子树上的结点深度都减少了1，即 -sz[v]
    //不在 v 的子树上的结点深度都增加了1，即 n-sz[v]
    //所以，f[v] = f[u]-sz[v]+n-sz[v] = f[u]+n-2*sz[v]

    static void dfs2(int u, int fa) {
        for (int v : g[u]) {
            if (v == fa) continue;
            f[v] = f[u] + n - 2 * sz[v];
            dfs2(v, u);
        }
    }
    public static void solve() throws IOException {
        n = in.nextInt();
        dep = new int[n+1];
        g = new List[n+1];
        sz = new int[n+1];
        f = new int[n+1];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int i = 1; i < n; i++) {
            int x = in.nextInt();
            int y = in.nextInt();
            g[x].add(y);
            g[y].add(x);
        }
        dfs(1, 0);
        dfs2(1, 0);
        long ans = -1;
        int id = 0;
        for (int i = 1; i <= n; i++) {
            if (f[i] > ans) {
                ans = f[i];
                id = i;
            }
        }
        out.println(id);
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