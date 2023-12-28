package com.fqh.div4.ROUND_918;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2023/12/28 19:52
 **/
public class D {


    static boolean isV(char x) {
        return x == 'a' || x == 'e';
    }

    public static void solve() throws IOException {
        int n = in.nextInt();
        String s = in.nextLine();
        char[] a = s.toCharArray();
        StringBuilder builder = new StringBuilder();
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (!isV(a[i])) { // 前面一定是C
                builder.append(a[i]);
                boolean ok = false;
                if (i + 1 < n) {
                    if (i + 2 < n) {
                        if (i + 3 < n) {
                            if (!isV(a[i+3])) {
                                builder.append(a[i + 1]);
                                builder.append(a[i + 2]);
                                i+=2;
                                ok = true;
                            }
                        } else {
                            if (!ok) {
                                builder.append(a[i + 1]);
                                builder.append(a[i + 2]);
                                i += 2;
                                ok = true;
                            }
                        }
                    }
                    if (!ok) {
                        builder.append(a[i + 1]);
                        i += 1;
                    }
                }
                ans.add(builder.toString());
                builder = new StringBuilder();
            }
        }
        for (int i = 0; i < ans.size(); i++) {
            if (i == ans.size() - 1) {
                out.print(ans.get(i));
            } else {
                out.print(ans.get(i) + ".");
            }
        }
        out.println();
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
