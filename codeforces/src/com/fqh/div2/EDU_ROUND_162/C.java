package com.fqh.div2.EDU_ROUND_162;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/23 22:31
 **/
public class C {


    // 1比较特殊，它不能减1
    // 区间的增量如果大于了区间1的个数，说明我们可以让每个1加1，然后较大的那个数一直减
    // 等价于判断区间内大于1的部分是否能让所有至少加上1

    public static void solve() throws IOException {
        int n = in.nextInt();
        int q = in.nextInt();
        long[] c = new long[n];
        long[] s = new long[n+1];
        long[] cnt1 = new long[n+1]; // 区间1的数
        for (int i = 0; i < n; i++) {
            c[i] = in.nextLong();
            s[i+1] = s[i] + c[i];
            cnt1[i+1] = cnt1[i] + (c[i] == 1 ? 1 : 0);
        }
        while (q-- > 0) {
            int l = in.nextInt();
            int r = in.nextInt();
            if (l == r) {
                out.println("NO");
                continue;
            }
            long t = s[r] - s[l-1] - (r - l + 1); // 区间[L,R]的增量
            if (t >= cnt1[r] - cnt1[l-1]) {
                out.println("YES");
            } else {
                out.println("NO");
            }
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
