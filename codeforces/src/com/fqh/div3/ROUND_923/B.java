package com.fqh.div3.ROUND_923;

import java.io.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/6 22:32
 **/
public class B {

    public static void solve() throws IOException {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.nextInt();
        StringBuilder sb = new StringBuilder();
        var map = new HashMap<Character, Integer>();
        sb.append('a');
        map.put('a', 1);
        for (int i = 1; i < n; i++) {
            int x = a[i];
            if (x == 0) {
                for (int j = 0; j < 26; j++) {
                    char t = (char) ('a' + j);
                    if (!map.containsKey(t)) {
                        sb.append(t);
                        map.put(t, 1);
                        break;
                    }
                }
            } else {
                for (int j = 0; j < 26; j++) {
                    char t = (char) ('a' + j);
                    if (map.containsKey(t) && map.getOrDefault(t, 0) == x) {
                        sb.append(t);
                        map.merge(t, 1, Integer::sum);
                        break;
                    }
                }
            }
        }
        out.println(sb);
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
