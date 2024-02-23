package com.fqh.div2.EDU_ROUND_162;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/23 22:31
 **/
public class B {



    public static void solve() throws IOException {
        int n = in.nextInt();
        int k = in.nextInt();
        long[][] bb = new long[n][2];
        for (int i = 0; i < n; i++) {
            bb[i][0] = in.nextLong();
        }
        for (int i = 0; i < n; i++) {
            long x = in.nextLong();
            bb[i][1] = Math.abs(x);
        }
        Arrays.sort(bb, (a, b) -> {
            if (a[1] != b[1]) return Long.compare(a[1], b[1]);
            return Long.compare(a[0], b[0]);
        });
        long less = 0;
        boolean ok = true;
        long att = 0;
        for (int i = 0; i < n; i++) {
            long s = bb[i][0];
            if (less >= s) {
                less -= s;
                continue;
            }
            long dis = bb[i][1] - att;
            if (dis <= 0) {
                ok = false;
                break;
            }
            if (less + k >= s) {
                less = (less + k) - s;
                att++;
            } else {
                // 需要打几次
                long cnt = (s + k - 1) / k;
                long cnt2 = less / k;
                if (less >= k) {
                    cnt -= cnt2;
                }
                if (cnt > dis) {
                    ok = false;
                    break;
                }
                att += cnt;
                if (less >= k) {
                    less = cnt * k - s;
                } else {
                    less += cnt * k - s;
                }
            }
        }
        out.println(ok ? "YES" : "NO");
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
