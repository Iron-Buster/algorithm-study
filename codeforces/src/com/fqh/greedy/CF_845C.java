package com.fqh.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/12 11:01
 **/
public class CF_845C {

//    https://codeforces.com/problemset/problem/845/C
//
//    输入 n(1≤n≤2e5) 和 n 个闭区间，每个闭区间 [L,R] 都满足 0≤L<R≤1e9。
//    能否将这 n 个闭区间分成两组，每组内的区间交集为空？允许一组是空的。
//    输出 YES 或 NO。

//    输入
//    3
//        1 2
//        2 4
//        4 5
//        6 7
//    输出 YES
//
//    输入
//    4
//        1 2
//        2 3
//        2 3
//        1 2
//    输出 NO

    public static void solve() throws IOException {
        int n = in.nextInt();
        int[][] a = new int[n][2];
        for (int i = 0; i < n; i++) {
            int start = in.nextInt();
            int end = in.nextInt();
            a[i][0] = start;
            a[i][1] = end;
        }
        Arrays.sort(a, ((o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o1[1] - o2[1]));
        int e1 = a[0][1];
        int e2 = -1;
        boolean ok = true;
        for (int i = 1; i < n; i++) {
            if (e1 >= a[i][0]) { // 与第一组相交
                if (e2 == -1) {
                    e2 = a[i][1];
                } else if (e2 >= a[i][0]) { // 与第二组也相交
                    ok = false;
                    break;
                } else {
                    e2 = a[i][1];
                }
            } else {
                e1 = a[i][1];
            }
        }
        out.println(ok ? "YES" : "NO");
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
