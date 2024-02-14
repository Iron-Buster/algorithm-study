package com.fqh.div3.ROUND_925;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/13 21:46
 **/
public class D {


    public static void solve() throws IOException {
        int n = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        int[] a = new int[n+1];
        for (int i = 1; i <= n; i++) a[i] = in.nextInt();
        Map<PII, Integer> map = new HashMap<>();
        int nxa = (a[1] % x + x) % x;
        int nya = (a[1] % y + y) % y;
        map.put(new PII(nxa, nya), 1);
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            int bx = (-a[i] % x + x) % x;
            int by = (a[i] % y + y) % y;
            PII pii = new PII(bx, by);
            ans += map.getOrDefault(pii, 0);
            bx = a[i] % x;
            pii.first = bx;
            map.merge(pii, 1, Integer::sum);
        }
        out.println(ans);
    }

    static class PII {
        int first, second;

        public PII(int first, int second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public int hashCode() {
            return first * 31 + second;
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
