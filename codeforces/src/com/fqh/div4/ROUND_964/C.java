package com.fqh.div4.ROUND_964;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/8/10 15:57
 **/
public class C {


    public static void solve() throws IOException {
        int n = in.nextInt();
        long s = in.nextInt();
        long m = in.nextInt();
        List<int[]> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int l = in.nextInt();
            int r = in.nextInt();
            a.add(new int[]{l, r});
        }
        a.sort((x, y) -> x[0] - y[0]);
        int preR = a.get(0)[1];
        long mx = 0;
        for (int i = 1; i < n; i++) {
            int curL = a.get(i)[0];
            if (curL - preR > mx) {
                mx = curL - preR;
            }
            if (a.get(i)[1] >= m) break;
            preR = a.get(i)[1];
        }
        if (mx >= s) {
            out.println("YES");
            return;
        }
        if (a.get(0)[0] >= s || (m - a.get(n-1)[1]) >= s) {
            out.println("YES");
            return;
        }
        out.println("NO");
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
