package com.fqh.div4.ROUND_918;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2023/12/28 19:52
 **/
public class B {

    public static void solve() throws IOException {
        String[] a = new String[3];
        for (int i = 0; i < 3; i++) {
            a[i] = in.nextLine();
        }
        char[][] b = new char[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                b[i][j] = a[i].charAt(j);
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (b[i][j] == '?') {
                    if (j == 0) {
                        int v1 = 0, v2 = 0, v3 = 0;
                        for (int k = j + 1; k < 3; k++) {
                            if (b[i][k] == 'A') v1++;
                            else if (b[i][k] == 'B') v2++;
                            else v3++;
                        }
                        if (v1 == 0) {
                            out.println('A');
                        } else if (v2 == 0) {
                            out.println('B');
                        } else {
                            out.println('C');
                        }
                    } else if (j == 1) {
                        int v1 = 0, v2 = 0, v3 = 0;
                        if (b[i][j-1] == 'A') v1++;
                        else if (b[i][j-1] == 'B') v2++;
                        else v3++;

                        if (b[i][j+1] == 'A') v1++;
                        else if (b[i][j+1] == 'B') v2++;
                        else v3++;

                        if (v1 == 0) {
                            out.println('A');
                        } else if (v2 == 0) {
                            out.println('B');
                        } else {
                            out.println('C');
                        }

                    } else {
                        int v1 = 0, v2 = 0, v3 = 0;
                        for (int k = 0; k < j; k++) {
                            if (b[i][k] == 'A') v1++;
                            else if (b[i][k] == 'B') v2++;
                            else v3++;
                        }
                        if (v1 == 0) {
                            out.println('A');
                        } else if (v2 == 0) {
                            out.println('B');
                        } else {
                            out.println('C');
                        }
                        return;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int T = in.nextInt();
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
