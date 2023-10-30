package _2023_10;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

/**
 * @Author: vq
 * @Date: 2023/10/30 12:51
 * @Version V1.0
 */
public class CF_26B {

//    https://codeforces.com/problemset/problem/26/B
//
//    输入一个长度 ≤1e6 的括号字符串 s。
//    输出 s 的最长合法括号子序列的长度。
//    注：子序列不一定连续。
//
//    相似题目：
//            32. 最长有效括号


//    输入 (()))(
//    输出 4
//
//    输入 ((()())
//    输出 6

    static final int MAXN = 200010;
    static int[] a = new int[MAXN];

    static void solve() throws Exception {
        var s = in.nextLine();
        var ss = s.toCharArray();
        var stack = new ArrayDeque<Character>();
        int ans = 0;
        for (var c : ss) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || stack.peek() == ')') continue;
                ans += 2;
                stack.pop();
            }

        }
        out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        int t = 1;
        while (t-- > 0) {
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
