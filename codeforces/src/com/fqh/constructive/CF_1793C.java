package com.fqh.constructive;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/27 16:08
 **/
public class CF_1793C {

    //https://codeforces.com/problemset/problem/1793/C

    static void f(int[] a, int[] left, int[] right, boolean ok) {
        int n = a.length;
        var stk = new ArrayDeque<Integer>();
        stk.push(-1);
        for (int i = 0; i < n; i++) {
            if (ok) {
                while (stk.size() > 1 && a[stk.peek()] > a[i]) {
                    stk.pop();
                }
            } else {
                while (stk.size() > 1 && a[stk.peek()] < a[i]) {
                    stk.pop();
                }
            }
            left[i] = stk.peek();
            stk.push(i);
        }
        stk.clear();
        stk.push(n);
        for (int i = n - 1; i >= 0; i--) {
            if (ok) {
                while (stk.size() > 1 && a[stk.peek()] > a[i]) {
                    stk.pop();
                }
            } else {
                while (stk.size() > 1 && a[stk.peek()] < a[i]) {
                    stk.pop();
                }
            }
            right[i] = stk.peek();
            stk.push(i);
        }
        stk.clear();
    }
    // 单调栈求出，left_min，left_max，right_min，right_max，然后双指针枚举端点，直到满足条件
    public static void solve() throws IOException {
        int n = in.nextInt();
        int[] a = new int[n+1];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        int[] right_min = new int[n+1], right_max = new int[n+1];
        int[] left_min = new int[n+1], left_max = new int[n+1];
        f(a, left_min, right_min, true);
        f(a, left_max, right_max, false);
        int i = 0, j = n - 1;
        while (i < j) {
            int i1 = right_min[i];
            int i2 = right_max[i];
            if (i1 == n || i2 == n || i1 > j || i2 > j) { // i1，i2必须<=j
                i++;
                continue;
            }
            int i3 = left_min[j];
            int i4 = left_max[j];
            if (i3 == -1 || i4 == -1 || i3 < i || i4 < i) { // i3，i4必须>=i
                j--;
                continue;
            }
            out.println((i+1) + " " + (j+1));
            return;
        }
        out.println(-1);
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
