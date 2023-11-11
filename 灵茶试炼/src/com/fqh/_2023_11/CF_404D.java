package com.fqh._2023_11;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @Author: vq
 * @Date: 2023/11/11 16:21
 * @Version V1.0
 */
public class CF_404D {

//    https://codeforces.com/contest/404/problem/D
//
//    输入一个长度在 [1,1e6] 内的字符串，由五种字符 *?012 组成，表示一个「一维扫雷游戏」的局面。
//    其中 * 表示雷，数字表示左右相邻位置有多少个雷。
//    把 ? 替换成 *012 中的一个，可以得到多少个合法的局面？模 1e9+7。

//    定义 dfs(i,j) 表示考虑 s[0]~s[i]，j=0/1/2 分别为：s[i]不能是雷/s[i]一定是雷/s[i+1]是雷，返回在这种情况下的方案数。
//    分类讨论即可。
//    递归边界：dfs(-1,0) = dfs(-1,2) = 1, dfs(-1,1) = 0
//    递归入口：dfs(n-1,0) + dfs(n-1,1)
//
//    记忆化搜索
//1:1 翻译成递推 + 空间优化
//    Python 递推代码


    static final int MAXN = 200010;
    static int[] a = new int[MAXN];
    static int[] b = new int[MAXN];
    static boolean[] vis = new boolean[MAXN];
    static List<Integer>[] g;
    static int n;
    static int m;
    static final int MOD = (int) (1e9 + 7);

    static int[][] dp;
    static char[] cs;

    static int dfs(int i, int j) {
        if (i < 0) {
            if (j == 1) return 0;
            return 1;
        }
        if (dp[i][j] != -1) return dp[i][j];
        int res = 0;
        var b = cs[i];
        if (j == 0) {
            if (b == '0') res = dfs(i - 1, 0);
            else if (b == '1') res = dfs(i - 1, 1);
            else if (b == '2' || b == '*')  return 0;
            else res = (dfs(i - 1, 0) + dfs(i - 1, 1)) % MOD;
        } else if (j == 1) {
            if (b == '0' || b == '1' || b == '2') return 0;
            res = dfs(i - 1, 2);
        } else {
            if (b == '0') return 0;
            else if (b == '1') res = dfs(i - 1, 0);
            else if (b == '2') res = dfs(i - 1, 1);
            else if (b == '*') res = dfs(i - 1, 2);
            else res = (dfs(i - 1, 0) + dfs(i - 1, 1) + dfs(i - 1, 2)) % MOD;
        }
        return dp[i][j] = res;
    }

    static void solve() throws Exception {
        var s = in.nextLine();
        cs = s.toCharArray();
        int n = cs.length;
        dp = new int[n][3];
        for (var d : dp) {
            Arrays.fill(d, -1);
        }
        int ans = (dfs(n - 1, 0) + dfs(n - 1, 1)) % MOD;
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
