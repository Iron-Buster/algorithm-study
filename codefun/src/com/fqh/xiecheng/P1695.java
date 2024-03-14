package com.fqh.xiecheng;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/14 10:19
 **/
public class P1695 {

//    https://codefun2000.com/p/P1695
//    #P1695. 2024.03.13-携程-第三题-数字压缩
    public static void solve() throws IOException {
        String s = in.nextLine();
        s = s.replace("[", "");
        s = s.replace("]", "");
        String[] ss = s.split(",");
        List<PII> list = new ArrayList<>();
        for (int i = 0; i < ss.length; i++) {
            if (!ss[i].contains("(")) { // 没有被压缩的字符串
                list.add(new PII(Integer.parseInt(ss[i]), 1));
            } else {
                int idx1 = ss[i].indexOf('(');
                int idx2 = ss[i].lastIndexOf(')');
                int x = Integer.parseInt(ss[i].substring(0, idx1));
                int cnt = Integer.parseInt(ss[i].substring(idx1 + 1, idx2));
                list.add(new PII(x, cnt));
            }
        }
        List<String> ans = new ArrayList<>();
        int cur = list.get(0).x;
        int cnt = list.get(0).cnt;
        for (int i = 1; i < list.size(); i++) {
            PII p = list.get(i);
            if (p.x == cur) {
                cnt += p.cnt;
            } else {
                ans.add(cur + "(" + cnt + ")");
                cur = p.x;
                cnt = p.cnt;
            }
            if (i == list.size() - 1) {
                ans.add(cur + "(" + cnt + ")");
            }
        }
        out.println("[" + String.join(",", ans) + "]");
    }

    static class PII {
        int x;
        int cnt;

        public PII(int x, int cnt) {
            this.x = x;
            this.cnt = cnt;
        }
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
