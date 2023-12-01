package com.fqh.CF800_899;

import java.io.*;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @Author: vq
 * @Date: 2023/12/1 16:11
 * @Version V1.0
 */
public class CF_893C {

//    C. Rumor
//
//    沃瓦曾向自己保证，再也不玩电脑游戏了......但最近，知名游戏开发公司 Firestorm 发布了他们的最新游戏《魔兽世界》(World of Farcraft)，并大受欢迎。当然，沃瓦也开始玩这款游戏。
//
//    现在，他正在尝试解决一个任务。任务是来到一个名为 Overcity 的定居点，并在那里散布谣言。
//
//    沃瓦知道在 Overcity 有 n 个角色。有些角色之间是朋友，他们会分享彼此获得的信息。
//    沃瓦还知道，他可以贿赂每个角色，让他们开始散布谣言； i 个角色想要 ci 金币作为散布谣言的交换条件。
//    当一个角色听到谣言时，他会告诉他所有的朋友，然后他们开始向他们的朋友传播谣言(免费)，以此类推。
//
//    当所有 n 个角色都知道这个谣言时，任务就完成了。沃瓦完成任务至少需要花费多少金币？
//
//    如果您认为还没有完全理解问题，请查看注释。

//            5 2
//            2 5 3 4 8
//            1 4
//            4 5
//            output -> 10


    // 并查集思路，将所有朋友合并成一个连通块，这个连通块维护一个最小值，然后遍历每个连通块，累加最小值。

    static final int MAXN = 200010;
    static int[] a = new int[MAXN];
    static int[] b = new int[MAXN];
    static boolean[] vis = new boolean[MAXN];
    static List<Integer>[] g;
    static int n;
    static int m;

    static class UnionFind {
        int[] fa;
        long[] val; // 维护连通块的最小值

        public UnionFind(int n) {
            fa = new int[n + 1];
            val = new long[n + 1];
            for (int i = 1; i <= n; ++i) {
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
            int a_parent = find(a);
            int b_parent = find(b);
            if (a_parent == b_parent) {
                return;
            }
            // 往权值较小的跟上合并
            if (val[a_parent] < val[b_parent]) {
                fa[b_parent] = fa[a_parent];
            } else {
                fa[a_parent] = fa[b_parent];
            }
        }
    }

    static void solve() throws Exception {
        n = in.nextInt();
        m = in.nextInt();
        var uf = new UnionFind(n);
        for (int i = 1; i <= n; ++i) {
            int x = in.nextInt();
            uf.val[i] = x;
        }
        for (int i = 1; i <= m; ++i) {
            int x = in.nextInt();
            int y = in.nextInt();
            uf.merge(x, y);
        }
        long ans = 0;
        for (int i = 1; i <= n; ++i) {
            int fa = uf.find(i);
            if (i == fa) ans += uf.val[i];
        }
        out.println(ans);
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
