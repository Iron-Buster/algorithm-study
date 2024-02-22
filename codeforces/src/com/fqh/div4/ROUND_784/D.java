package com.fqh.div4.ROUND_784;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/22 14:32
 **/
public class D {



    public static void solve() throws IOException {
        int n = in.nextInt();
        String str = in.nextLine();
        char[] s = str.toCharArray();
        boolean ok = true;
        // BBBBW WBBBB WBBBBW 这种都是NO
        for (int i = 0; i < n; i++) {
            if (s[i] != 'W') {
                int j = i;
                var map = new HashMap<Character, Integer>();
                for (; j < n && s[j] != 'W'; j++) {
                    map.merge(s[j], 1, Integer::sum);
                }
                if (map.size() == 1) {
                    ok = false;
                    break;
                }
                i = j;
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
