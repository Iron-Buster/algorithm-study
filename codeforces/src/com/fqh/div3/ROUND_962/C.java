package com.fqh.div3.ROUND_962;

import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/7/27 11:19
 **/
public class C {

    // 两个字符串a,b
    // q个询问 l r的一个区间
    // 你可将a[i] (1<=i<=n) 改为任意字符
    // 每个询问 sorted(a[l:r]) = sorted(b[l:r])的最少操作数

    public static void solve() throws IOException {
        int n = in.nextInt();
        int q = in.nextInt();
        char[] a = in.nextLine().toCharArray();
        char[] b = in.nextLine().toCharArray();
        int[][] cnt1 = new int[n+1][26];
        int[][] cnt2 = new int[n+1][26];
        for (int i = 0; i < n; i++) {
            cnt1[i+1][a[i]-'a']++;
            for (int j = 0; j < 26; j++) {
                cnt1[i+1][j] += cnt1[i][j];
            }
            cnt2[i+1][b[i]-'a']++;
            for (int j = 0; j < 26; j++) {
                cnt2[i+1][j] += cnt2[i][j];
            }
        }
        while (q-- > 0) {
            int l = in.nextInt();
            int r = in.nextInt();
            l--; r--;
            int[] t1 = new int[26];
            int[] t2 = new int[26];
            for (int i = 0; i < 26; i++) {
                t1[i] = cnt1[r+1][i] - cnt1[l][i];
                t2[i] = cnt2[r+1][i] - cnt2[l][i];
            }
            int cnt = 0;
            for (int i = 0; i < 26; i++) {
                cnt += Math.abs(t1[i] - t2[i]);
            }
            out.println(cnt / 2);
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
