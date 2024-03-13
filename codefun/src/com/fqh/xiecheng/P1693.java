package com.fqh.xiecheng;

import javax.crypto.MacSpi;
import java.io.*;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/13 23:51
 **/
public class P1693 {


    //#P1693. 2024.03.13-携程-第一题-最喜欢“you”
    //https://codefun2000.com/p/P1693


    public static void solve() throws IOException {
        char[] s = in.nextLine().toCharArray();
        int[] map = new int[26];
        for (char c : s) map[c-'a']++;
        int mn = Math.min(map['y'-'a'], Math.min(map['o'-'a'], map['u'-'a']));
        StringBuilder ans = new StringBuilder();
        ans.append("you".repeat(mn));
        map['y'-'a'] -= mn;
        map['o'-'a'] -= mn;
        map['u'-'a'] -= mn;
        for (int i = 0; i < 26; i++) {
            if (map[i] > 0) {
                ans.append(String.valueOf((char) (i + 'a')).repeat(map[i]));
            }
        }
        out.println(ans);
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
