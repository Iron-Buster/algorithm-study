package com.fqh.contest.ROUND_32;

import java.io.*;
import java.util.StringTokenizer;


/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/11 18:42
 **/
public class B {


    public static void solve() throws IOException {
        String str1 = in.nextLine();
        String str2 = in.nextLine();
        String str3 = in.nextLine();
        int ans1 = 0 ,ans2 = 0 ,ans3 = 0;
        if(str1.charAt(0) != 'd') ans1 ++; if(str2.charAt(0) != 'f') ans1 ++;
        if(str1.charAt(1) != 'f')ans1 ++;  if(str3.charAt(0) != 's')ans1 ++;
        if(str1.charAt(2) != 's')ans1 ++;

        if(str2.charAt(0) != 'd') ans2 ++; if(str1.charAt(1) != 'd') ans2 ++;
        if(str2.charAt(1) != 'f')ans2 ++;  if(str3.charAt(1) != 's')ans2 ++;
        if(str2.charAt(2) != 's')ans2 ++;

        if(str3.charAt(0) != 'd') ans3 ++; if(str1.charAt(2) != 'd') ans3 ++;
        if(str3.charAt(1) != 'f')ans3 ++;  if(str2.charAt(2) != 'f')ans3 ++;
        if(str3.charAt(2) != 's')ans3 ++;
        out.println(Math.min(Math.min(ans1 ,ans2) , ans3));
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
