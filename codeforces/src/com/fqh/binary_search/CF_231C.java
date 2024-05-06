package com.fqh.binary_search;

import java.io.*;
import java.util.*;

public class CF_231C {

//    https://codeforces.com/problemset/problem/231/C

    public static void solve() throws Exception {
        int n = in.nextInt();
        int k = in.nextInt();
        long[] a = new long[n], s = new long[n+1];
        var group = new HashMap<Long, List<Integer>>();
        for (int i = 0; i < n; i++) a[i] = in.nextLong();
        Arrays.sort(a);
        for (int i = 0; i < n; i++) {
            s[i+1] = s[i] + a[i];
            group.computeIfAbsent(a[i], v -> new ArrayList<>()).add(i);
        }
        // 枚举a[i]作为答案
        long mx = 0, ans = 0;
        for (var x : group.keySet()) {
            var list = group.get(x);
            int l = list.get(0), r = list.get(list.size()-1);
            if (r - l + 1 > mx || (r - l + 1 == mx && x < ans)) {
                mx = r - l + 1;
                ans = x;
            }
            // 二分这个left
            int left = 0, right = l - 1;
            while (left < right) {
                int mid = (left + right) >> 1;
                long need = (l - mid) * x - (s[l] - s[mid]);
                if (need <= k) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
            long need = (l - left) * x - (s[l] - s[left]);
            long cnt = r - left + 1;
            if (need <= k && (cnt > mx || (cnt == mx && x < ans))) {
                mx = cnt;
                ans = x;
            }
        }
        out.println(mx + " " + ans);
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
