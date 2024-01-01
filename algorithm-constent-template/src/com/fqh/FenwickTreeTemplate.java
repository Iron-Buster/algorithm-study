package com.fqh;

/**
 * @Author: vq
 * @Date: 2023/11/24 12:10
 * @Version V1.0
 */

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

/**
 * 树状数组
 */
public class FenwickTreeTemplate {
    // 洛谷树状数组模板1 https://www.luogu.com.cn/problem/P3374
    // 单点修改 区间查询
    public static void solve() throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();
        FenwickTree ft = new FenwickTree(n);
        for (int i = 1; i <= n; i++) {
            int y = in.nextInt();
            ft.change(i, y);
        }
        while (m-- > 0) {
            String s = in.nextLine();
            String[] ss = s.split(" ");
            int op = Integer.parseInt(ss[0]);
            int x = Integer.parseInt(ss[1]);
            int y = Integer.parseInt(ss[2]);
            if (op == 1) {
                ft.change(x, y);
            } else {
                out.println(ft.query(y) - ft.query(x-1));
            }
        }
    }

    // 洛谷树状数组模板2 https://www.luogu.com.cn/problem/P3368
    // 区间修改 单点查询
    public static void solve2() throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();
        FenwickTree ft = new FenwickTree(n);
        for (int i = 1; i <= n; i++) {
            int y = in.nextInt();
            ft.a[i] = y;
        }
        while (m-- > 0) {
            String s = in.nextLine();
            String[] ss = s.split(" ");
            int op = Integer.parseInt(ss[0]);
            int x = Integer.parseInt(ss[1]);
            if (op == 1) { // 区间 [x,y] + k
                int y = Integer.parseInt(ss[2]);
                int k = Integer.parseInt(ss[3]);
                // 利用差分对两端进行修改
                ft.change(x, k);
                ft.change(y+1, -k);
            } else {
                out.println(ft.a[x] + ft.query(x));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int T = 1;
        while (T-- > 0) {
            solve();
//            solve2();
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


class FenwickTree {
    int n;
    int[] s = new int[500005]; // 区间和
    int[] a = new int[500005];

    public FenwickTree(int n) {
        this.n = n;
    }

    public int lowbit(int x) { // 提取x的低位2次幂数（去掉二进制最后一位1）
        return x & -x;
    }

    public void change(int x, int k) {    // 向后修
        while (x <= n) {
            s[x] += k;
            x += lowbit(x);
        }
    }
    public int query(int x) { // 向前查（前缀和）
        int t = 0;
        while (x > 0) {
            t += s[x];
            x -= lowbit(x);
        }
        return t;
    }
}


class FenwickTree2 {
    int n;
    int[] s = new int[100005]; // 区间和
    int[] a = new int[500005];

    public FenwickTree2(int n) {
        this.n = n;
    }

    public int lowbit(int x) { // 提取x的低位2次幂数（去掉二进制最后一位1）
        return x & -x;
    }

    public void change(int x, int k) {    // 向后修
        while (x <= n) {
            s[x] += k;
            x += lowbit(x);
        }
    }
    public int query(int x) { // 向前查（前缀和）
        int t = 0;
        while (x > 0) {
            t += s[x];
            x -= lowbit(x);
        }
        return t;
    }

    public void change2(int x, int k) {    // 向后修 维护前缀最值
        while (x <= n) {
            s[x] = Math.max(s[x], k);
            x += lowbit(x);
        }
    }
    public int query2(int x) { // 向前查（前缀和） 查询前缀最值
        int t = 0;
        while (x > 0) {
            t = Math.max(t, s[x]);
            x -= lowbit(x);
        }
        return t;
    }

    public Map<Integer, Integer> f(int[] a) {
        // 离散化
        TreeSet<Integer> tset = new TreeSet<>();
        for (int x : a) {
            tset.add(x);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (Integer x : tset) {
            map.put(x, rank++);
        }
        return map;
    }
}