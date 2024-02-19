package com.fqh.div3.ROUND_927;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/18 20:55
 **/
public class C {

    // 给你一个数组，和一个字符串，R代表删除最右边元素，L代表删除最左边元素
    // 每次操作后，问当前数组的乘积 mod m等于多少
    public static void solve() throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.nextInt();
        String s = in.nextLine();
        // 反过来计算答案，从最后一个元素累乘，计算答案
        var stk = new ArrayDeque<Integer>();
        int l = 0, r = n - 1;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'L') {
                stk.push(l++);
            } else {
                stk.push(r--);
            }
        }
        long v = 1;
        long[] res = new long[n];
        for (int i = n - 1; i >= 0; i--) {
            int j = stk.pop();
            v = v * a[j] % m;
            res[i] = v;
        }
        for (long x : res) {
            out.print(x + " ");
        }
        out.println();
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
