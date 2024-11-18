package com.fqh;


import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class CF_318B {

//    https://codeforces.com/contest/318/problem/B
//
//    输入长度 ≤1e6 的字符串 s，只包含小写英文字母。
//
//    输出有多少个子串，以 "heavy" 开头，并以 "metal" 结尾。
//
//    进阶：如果给定的开头结尾是更长的字符串呢？

//    输入 heavymetalisheavymetal
//    输出 3
//
//    输入 heavymetalismetal
//    输出 2
//
//    输入 trueheavymetalissotruewellitisalsosoheavythatyoucanalmostfeeltheweightofmetalonyou
//    输出 3

    public static void solve() throws IOException {
        String s = in.nextLine();
        var a = new ArrayList<Integer>();
        var b = new ArrayList<Integer>();
        for (int i = 0; i + 5 <= s.length(); i++) {
            String t = s.substring(i, i + 5);
            if (t.equals("heavy")) {
                a.add(i);
            } else if (t.equals("metal")){
                b.add(i);
            }
        }
        if (a.isEmpty() || b.isEmpty()) {
            out.println(0);
            return;
        }
        long ans = 0;
        for (int pos : a) {
            int l = 0, r = b.size() - 1;
            while (l < r) {
                int mid = (l + r) >> 1;
                if (b.get(mid) >= pos) {
                    r = mid;
                } else {
                    l = mid + 1;
                }
            }
            if (pos <= b.get(l)) {
                ans += b.size() - l;
            }
        }
        out.println(ans);
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
