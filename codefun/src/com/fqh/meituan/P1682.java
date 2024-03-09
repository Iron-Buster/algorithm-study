package com.fqh.meituan;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/9 12:43
 **/
public class P1682 {

    // https://codefun2000.com/p/P1682
    //  #P1682. 2024.3.9美团-第三题-塔子哥的完美矩形
    static int[][] matrixSum(int[][] a) {
        int m = a.length;
        int n = a[0].length;
        int[][] g = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int x = i + 1;
                int y = j + 1;
                g[x][y] = a[i][j] + g[x-1][y] + g[x][y-1] - g[x-1][y-1];
            }
        }
        return g;
    }

    static int query(int x1, int y1, int x2, int y2, int[][] g) {
        x1++; y1++; x2++; y2++;
        return g[x2][y2] - g[x1-1][y2] - g[x2][y1-1] + g[x1-1][y1-1];
    }


    public static void solve() throws IOException {
        int n = in.nextInt();
        int[][] a = new int[n][n];
        for (int i = 0; i < n; i++) {
            char[] t = in.nextLine().toCharArray();
            for (int j = 0; j < n; j++) {
                a[i][j] = t[j] - '0';
            }
        }
        int[][] g = matrixSum(a);
        int[] ans = new int[n];
        for (int up = 0; up < n; up++) {
            for (int down = 0; down < n; down++) {
                for (int l = 0; l < n; l++) {
                    if (up + l >= n || down + l >= n) break;
                    int v = query(up, down, up + l, down + l, g);
                    if (v * 2 == Math.pow(l + 1, 2)) {
                        ans[l]++;
                    }
                }
            }
        }
        for (int x : ans) out.println(x);
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
