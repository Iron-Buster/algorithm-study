package com.fqh.competition.小白赛.ROUND4;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/27 20:12
 **/
public class B {

    static final Map<String, Integer> ll = new HashMap<>() {
        {
            put("yuanxing", 1);
            put("zhengfangxing", 2);
            put("changfangxing", 3);
            put("sanjiaoxing", 4);
            put("tuoyuanxing", 5);
            put("liubianxing", 6);
        }
    };


    public static void solve() throws IOException {
        int n = in.nextInt();
        var map = new HashMap<String, Integer>();
        String s = in.nextLine();
        String[] ss = s.split(" ");
        for (String k : ss) {
            map.merge(k, 1, Integer::sum);
        }
        int ans = 0;
        for (String k : map.keySet()) {
            ans += map.get(k) * ll.get(k);
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
