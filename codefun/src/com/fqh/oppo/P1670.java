package com.fqh.oppo;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/23 14:33
 **/
public class P1670 {

    //2024.02.21-OPPO春招（第二套）第三题-小欧吃苹果
    // https://codefun2000.com/p/P1670
    static int[] a = new int[100005];
    static List<Integer>[] g = new List[100005];
    static int ans = 0;
    static int[] dfs(int x, int fa) {
        int coins = 0; // 子树硬币数量
        int nodes = 0; // 子数结点点数量
        for (int y : g[x]) {
            if (y == fa) continue;
            int[] sub = dfs(y, x);
            coins += sub[0];
            nodes += sub[1];
        }
        ans += Math.abs(coins - nodes);
        nodes += 1;
        coins += a[x];
        return new int[]{coins, nodes};
    }
    public static void solve() throws IOException {
        int n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }
        Arrays.setAll(g, v -> new ArrayList<>());
        for (int i = 1; i <= n - 1; i++) {
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
