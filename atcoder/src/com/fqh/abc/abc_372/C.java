package com.fqh.abc.abc_372;

import java.io.*;
import java.util.*;

public class C {

//    AC
    public static void solve() throws IOException {
        int n = in.nextInt();
        int q = in.nextInt();
        String s = in.nextLine();
        int cnt = 0;
        for (int i = 0; i < n - 2; i++) {
            String t = s.substring(i, i + 3);
            if (t.equals("ABC")) {
               cnt++;
            }
        }
        List<Integer> ans = new ArrayList<>();
        char[] cs = s.toCharArray();
        while (q-- > 0) {
            String line = in.nextLine();
            String[] ss = line.split(" ");
            int x = Integer.parseInt(ss[0]) - 1;
            char c = ss[1].charAt(0);

            int start = Math.max(0, x - 2);
            int end = Math.min(n - 1, x + 2);

            for (int i = start; i < end - 1; i++) {
                if (cs[i] == 'A' && cs[i+1] == 'B' && cs[i+2] == 'C') {
                    cnt--;
                }
            }
            cs[x] = c;
            for (int i = start; i < end - 1; i++) {
                if (cs[i] == 'A' && cs[i+1] == 'B' && cs[i+2] == 'C') {
                    cnt++;
                }
            }
            ans.add(cnt);

        }
        for (int v : ans) {
            out.println(v);
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
