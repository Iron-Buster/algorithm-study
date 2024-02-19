package com.fqh.div4.ROUND_928;

import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/19 18:20
 **/
public class B {

    // 统计每行1的个数丢到set里面，最后判断set.size()是否等于1就行
    public static void solve() throws IOException {
        int n = in.nextInt();
        String[] ss = new String[n];
        for (int i = 0; i < n; i++) {
            String s = in.nextLine();
            ss[i] = s;
        }
        var set = new HashSet<Integer>();
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < n; j++) {
                if (ss[i].charAt(j) == '1') {
                    cnt++;
                }
            }
            if (cnt > 0) set.add(cnt);
        }
        if (set.size() != 1) {
            out.println("TRIANGLE");
        } else {
            out.println("SQUARE");
        }
    }

    static boolean MULTI_CASE = true;
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
