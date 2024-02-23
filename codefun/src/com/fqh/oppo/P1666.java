package com.fqh.oppo;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/23 12:04
 **/
public class P1666 {

    //2024.02.21-OPPO春招第一题-小欧的字符串1
    // https://codefun2000.com/p/P1666

    /**
     *
     * 小欧拿到了一个字符串，她想知道，有多少个长度为
     * k 的连续子串满足，所有字母出现次数为偶数次，小红想知道，有多少个满足条件的子串 ?
     */

    static boolean check(int[] map) {
        for (int x : map) {
            if (x % 2 == 1) return false;
        }
        return true;
    }
    public static void solve() throws IOException {
        int n = in.nextInt();
        int k = in.nextInt();
        char[] s = in.nextLine().toCharArray();
        long ans = 0;
        // 枚举右端点
        int j = 0;
        int[] map = new int[26];
        for (int i = 0; i < n; i++) {
            map[s[i]-'a']++;
            if (i - j + 1 > k) {
                map[s[j]-'a']--;
                j++;
            }
            if (i - j + 1 == k && check(map)) {
                ans += 1;
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
