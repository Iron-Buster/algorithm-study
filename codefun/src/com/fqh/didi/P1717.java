package com.fqh.didi;

import java.io.*;
import java.util.*;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/20 17:46
 **/
public class P1717 {

    // #P1717. 2024.3.17-滴滴-第二题-塔子哥的授权请求
    //https://codefun2000.com/p/P1717

    // 样例没过完 只能拿65分

    static List<Integer>[] g;
    static int[] ans;
    static int[] a;


    static void dfs(int x, int fa, int depth, TreeSet<PII> tset) {
        if (fa != -1) {
            PII cur = new PII(x, a[x], depth);
            PII ceiling = tset.ceiling(cur);
            PII floor = tset.floor(cur);
            if (ceiling != null && floor != null) {
                int v1 = ceiling.val - cur.val;
                int v2 = cur.val - floor.val;
                if (v1 == v2) {
                    if (ceiling.depth > floor.depth) {
                        ans[x] = ceiling.no;
                    } else {
                        ans[x] = floor.no;
                    }
                } else if (v1 < v2) {
                    ans[x] = ceiling.no;
                } else {
                    ans[x] = floor.no;
                }
            } else if (ceiling != null) {
                ans[x] = ceiling.no;
            } else if (floor != null) {
                ans[x] = floor.no;
            }
        }
        PII pii = new PII(x, a[x], depth);
        tset.add(pii);
        for (int y : g[x]) {
            if (y == fa) continue;
            dfs(y, x, depth + 1, tset);
        }
        tset.remove(pii);
    }

    public static void solve() throws IOException {
        int n = in.nextInt();
        a = new int[n + 1];
        g = new List[n + 1];
        ans = new int[n + 1];
        Arrays.setAll(g, v -> new ArrayList<>());
        for (int i = 1; i <= n - 1; i++) {
            int fa = in.nextInt();
            g[fa].add(i);
        }
        for (int i = 1; i <= n; i++) a[i] = in.nextInt();
        dfs(n, -1, 0, new TreeSet<PII>((a, b) -> a.val != b.val ? a.val - b.val : a.depth - b.depth));
        for (int i = 1; i <= n - 1; i++) {
            out.print(ans[i] + " ");
        }
    }

    static class PII {
        int no;
        int val;
        int depth;

        public PII(int no, int val, int depth) {
            this.no = no;
            this.val = val;
            this.depth = depth;
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
