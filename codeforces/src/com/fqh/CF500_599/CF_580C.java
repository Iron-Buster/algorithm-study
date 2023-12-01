package com.fqh.CF500_599;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @Author: vq
 * @Date: 2023/12/1 14:59
 * @Version V1.0
 */
public class CF_580C {

//    C. Kefa and Park
//    凯法决定去餐厅庆祝他的第一份高薪。
//    他住在一个不寻常的公园旁。公园是一棵有根的树，由 n 个顶点组成，根位于顶点 1 。
//    顶点 1 也包含凯发的房子。不幸的是，公园里也有猫。凯法已经找出了有猫的顶点。
//    公园的叶子顶点包含餐馆。克法想选择一家他要去的餐馆，但不幸的是，他非常害怕猫，所以如果从餐馆到他家的路径中包含超过 m 的顶点，他是不可能去餐馆的。连续顶点有猫。
//    你的任务是帮助凯法计算他可以去的餐馆数量。

    static final int MAXN = 200010;
    static int[] a = new int[MAXN];
    static int[] b = new int[MAXN];
    static boolean[] vis = new boolean[MAXN];
    static List<Integer>[] g;
    static int n;
    static int m;

    static int ans = 0;
    // dfs 搜索 当前节点的size = 1，cur != 1 并且cnt <= m时 ans++
    static void solve() throws Exception {
        ans = 0;
        n = in.nextInt();
        m = in.nextInt();   // 可以接受的顶点为1的最大连续数量
        for (int i = 1; i <= n; ++i) {
            a[i] = in.nextInt();    // a[i] = 1或者0
        }
        g = new List[n + 1];
        Arrays.setAll(g, v -> new ArrayList<>());
        for (int i = 1; i <= n - 1; ++i) {
            int x = in.nextInt();
            int y = in.nextInt();
            g[x].add(y);
            g[y].add(x);
        }
        dfs(1, -1, a[1]);
        out.println(ans);
    }

    static void dfs(int x, int fa, int cnt) {
        if (cnt > m) return;
        if (g[x].size() == 1 && x != 1) {
            ans++;
            return;
        }
        for (int y : g[x]) {
            if (y == fa) continue;
            if (a[y] == 0) {
                dfs(y, x, 0);
            } else {
                dfs(y, x, cnt + 1);
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
