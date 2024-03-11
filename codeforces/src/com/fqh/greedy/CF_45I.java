package com.fqh.greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/11 11:15
 **/
public class CF_45I {


//    https://codeforces.com/problemset/problem/45/I

//    输入 n(1≤n≤100) 和长为 n 的数组 a(-100≤a[i]≤100)。
//    你需要从 a 中选择若干个数（至少一个），最大化所选数字的乘积。
//    输出你选的数字。如果答案不唯一，输出任意一个。

    public static void solve() throws IOException {
        int n = in.nextInt();
        int[] a = new int[n];
        int cnt = 0; // 负数个数
        int cnt1 = 0; // 正数个数
        boolean hasZero = false;
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
            cnt += (a[i] < 0 ? 1 : 0);
            cnt1 += (a[i] > 0 ? 1 : 0);
            hasZero |= (a[i] == 0);
        }
        if (hasZero && ((cnt == 0 || cnt == 1) && cnt1 == 0)) {
            out.println(0);
            return;
        }
        Arrays.sort(a);
        List<Integer> ans = new ArrayList<>();
        // 正数一定要选
        // 负数个数为偶数，全部都选，否则留一个最大的负数不选
        for (int i = 0; i < n; i++) {
            if (a[i] < 0) {
                if (i + 1 < n && cnt % 2 == 1 && a[i+1] >= 0) {
                    continue;
                }
                ans.add(a[i]);
            } else if (a[i] > 0) {
                ans.add(a[i]);
            }
        }
        for (int x : ans) out.print(x + " ");
        out.println();
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
