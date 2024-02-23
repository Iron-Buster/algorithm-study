package com.fqh.oppo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/23 14:27
 **/
public class P1669 {

    //2024.02.21-OPPO春招（第二套）第二题-小欧的O和P
    //https://codefun2000.com/p/P1669

    public static void solve() throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();
        char[][] c = new char[n][m];
        for (int i = 0; i < n; i++) {
            c[i] = in.nextLine().toCharArray();
        }
        List<Integer> b = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < m; j++) {
                if (c[i][j] == '#') cnt++;
            }
            if (cnt > 0) b.add(cnt);
        }
        if (b.get(0).intValue() == b.get(b.size() - 1)) {
            out.println("O");
        } else {
            out.println("P");

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
