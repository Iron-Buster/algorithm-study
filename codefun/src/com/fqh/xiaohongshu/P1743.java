package com.fqh.xiaohongshu;

import java.io.*;
import java.util.*;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/25 18:18
 **/
public class P1743 {

//    https://codefun2000.com/p/P1743
//    #P1743. 2024.03.24-小红书-第一题-塔子哥的浏览记录
    public static void solve() throws IOException {
        int n = in.nextInt();
        HashSet<String> vis = new HashSet<>();
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            if (vis.add(s)) ans.add(s);;
        }
        for (String a : ans) {
            out.println(a);
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
