package com.fqh.contest.ROUND_30;

import javax.print.DocFlavor;
import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/29 14:45
 **/
public class C {



    public static void solve() throws IOException {
        String ss = in.nextLine();
        char[] s = ss.toCharArray();
        if (s.length <= 3) {
            out.println(-1);
            return;
        }
        int[] map = new int[26];
        for (char c : s) map[c-'a']++;
        int even = 0, odd = 0;
        for (int i = 0; i < 26; i++) {
            if (map[i] == 0) continue;
            if (map[i] % 2 == 0) even++;
            else odd++;
        }
        if (odd == even) {
            out.println(-1);
            return;
        }
        int n = s.length;
        int idx = -1;
        for (int i = 1; i < n; i++) {
            if (s[i] != s[i-1]) {
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            out.println(-1);
            return;

        }
        int p = n - idx - 1;
        char t = s[idx];
        s[idx] = s[idx-1];
        s[idx-1] = t;
        t = s[p];
        s[p] = s[p+1];
        s[p+1] = t;
        out.println(String.valueOf(s));
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
