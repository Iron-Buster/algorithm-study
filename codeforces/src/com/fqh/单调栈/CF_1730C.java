package com.fqh.单调栈;

import java.io.*;
import java.util.*;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/20 11:10
 **/
public class CF_1730C {

//    https://codeforces.com/problemset/problem/1730/C
//
//    输入 T(≤1e4) 表示 T 组数据。所有数据的 n 之和 ≤2e5。
//    每组数据输入 n(1≤n≤2e5) 和长为 n 的字符串 s，仅包含 '0' 到 '9'。
//
//    你可以执行如下操作任意次：
//    把 s 中的一个字符 c 删除，然后在任意位置插入 min(c+1,'9')。
//
//    输出你能得到的字典序最小的字符串。

//    输入
//        4
//        04829
//        9
//        01
//        314752277691991
//    输出
//        02599
//        9
//        01
//        111334567888999
//    解释：样例 1 删除 '4' 和 '8'，插入 '5' 和 '9'。

    public static void solve() throws IOException {
        char[] s = in.nextLine().toCharArray();
        int n = s.length;
        var stk = new ArrayDeque<Integer>();
        int[] right = new int[n + 1];
        // 0 4 8 2 9
        // 5 3 3 5 5 0
        stk.push(n);
        var a = new ArrayList<Character>();
        for (int i = n - 1; i >= 0; i--) {
            while (stk.size() > 1 && s[stk.peek()] >= s[i]) {
                stk.pop();
            }
            right[i] = stk.peek();
            stk.push(i);
        }
        for (int i = 0; i < n; i++) {
            if (right[i] != n) a.add((char) Math.min(s[i] + 1, '9'));
            else a.add(s[i]);
        }
        Collections.sort(a);
        var ans = new StringBuilder();
        for (char c : a) ans.append(c);
        out.println(ans);
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
