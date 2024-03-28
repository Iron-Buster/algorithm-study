package com.fqh.taotian;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/28 21:17
 **/
public class P1751 {

//    http://101.43.147.120:8888/p/P1751
//    #P1751. 2024.03.27-阿里淘天-第三题-塔子哥修改区间
    static int n, m;
    static char[] s;

//    二分答案k
    static boolean check(int mid)  {
        int cnt = m;
        if (mid * cnt >= n) return true;
        int i = 0;
        while (i < n) {
            if (cnt < 0) return false;
            if (s[i] == 'W') {
                cnt--;
                i += mid;
            } else {
                i++;
            }
        }
        return cnt >= 0;
    }

    public static void solve() throws IOException {
        n = in.nextInt();
        m = in.nextInt();
        s = in.nextLine().toCharArray();
        int l = 0, r = (int) (2e5 + 10);
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check(mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        out.println(l);
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
