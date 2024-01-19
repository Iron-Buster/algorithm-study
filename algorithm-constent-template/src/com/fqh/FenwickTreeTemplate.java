package com.fqh;

/**
 * @Author: vq
 * @Date: 2023/11/24 12:10
 * @Version V1.0
 */

import java.io.*;
import java.util.*;

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
                out.println(ft.query(y) - ft.query(x - 1));
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
                ft.change(y + 1, -k);
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
}

/**
 * 二维树状数组
 */
class FenwickTree3 {
    int n, m;
    int[][][] s = new int[301][301][301]; // 各权值在矩阵出现的次数

    public FenwickTree3(int n, int m) {
        this.n = n;
        this.m = m;
    }

    public int lowbit(int x) {
        return x & -x;
    }

    public void change(int x, int y, int c, int v) {
        for (int i = x; i <= n; i += lowbit(i)) {
            for (int j = y; j <= m; j += lowbit(j)) {
                s[i][j][c] += v;
            }
        }
    }

    public int query(int x, int y, int c) {
        int t = 0;
        for (int i = x; i > 0; i -= lowbit(i)) {
            for (int j = y; j > 0; j -= lowbit(j)) {
                t += s[i][j][c];
            }
        }
        return t;
    }
}


// HH的项链
// https://www.luogu.com.cn/problem/P1972
// 给定m个询问，每个询问区间[L,R]不同元素的个数
class LG_P1972 {
    static int n, m;
    static int N = 1000010;

    static class Q {
        int l, r, id; // 查询得到区间右端点，查询的编号

        public Q(int l, int r, int id) {
            this.l = l;
            this.r = r;
            this.id = id;
        }
    }

    static Q[] q = new Q[N];
    static int[] a = new int[N];
    static int[] last = new int[N];
    static int[] ans = new int[N];
    static int[] s = new int[N]; // 区间1的个数

    static int lowbit(int x) { // 提取x的低位2次幂数（去掉二进制最后一位1）
        return x & -x;
    }

    static void change(int x, int k) {
        while (x <= n) {
            s[x] += k;
            x += lowbit(x);
        }
    }

    static int query(int x) {
        int t = 0;
        while (x > 0) {
            t += s[x];
            x -= lowbit(x);
        }
        return t;
    }

    public static void solve() throws IOException {
        n = in.nextInt();
        for (int i = 1; i <= n; i++) {
            a[i] = in.nextInt();
        }
        m = in.nextInt();
        for (int i = 1; i <= m; i++) {
            String s = in.nextLine();
            String[] ss = s.split(" ");
            int l = Integer.parseInt(ss[0]);
            int r = Integer.parseInt(ss[1]);
            q[i] = new Q(l, r, i);
        }
        //查询按右端点排序
        Arrays.sort(q, 1, m + 1, (a, b) -> a.r - b.r);
        for (int i = 1, lp = 1; i <= m; i++) { // 枚举每个查询
            for (int j = lp; j <= q[i].r; j++) { // 枚举右端点前面的位置
                if (last[a[j]] > 0) {
                    change(last[a[j]], -1); // a[j]上次的位置 -1
                }
                change(j, 1);               // a[j]这次的位置 +1
                last[a[j]] = j;                // 记录a[j]最后一次出现的位置
            }
            lp = q[i].r + 1;                   // 更新已处理位置的左边界
            ans[q[i].id] = query(q[i].r) - query(q[i].l - 1);
        }
        for (int i = 1; i <= m; i++) {
            out.println(ans[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        int T = 1;
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

// 计数问题
// https://www.luogu.com.cn/problem/P4054
// 给定q个询问，每个询问求二维区间中c出现的次数
class LG_P4054 {

    public static void solve() throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();
        int[][] a = new int[n + 10][m + 10];
        FenwickTree3 ft = new FenwickTree3(n, m);
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int c = in.nextInt();
                a[i][j] = c;
                ft.change(i, j, c, 1);
            }
        }
        int q = in.nextInt();
        while (q-- > 0) {
            int op = in.nextInt();
            if (op == 1) { // 修改：先减后加
                int x1 = in.nextInt();
                int y1 = in.nextInt();
                int c = in.nextInt();
                ft.change(x1, y1, a[x1][y1], -1);
                a[x1][y1] = c;
                ft.change(x1, y1, c, 1);
            } else {       // 查询：二维前缀和
                int x1 = in.nextInt();
                int y1 = in.nextInt();
                int x2 = in.nextInt();
                int y2 = in.nextInt();
                int c = in.nextInt();
                int ans = ft.query(x2, y2, c) - ft.query(x1 - 1, y2, c)
                        - ft.query(x2, y1 - 1, c) + ft.query(x1 - 1, y1 - 1, c);
                out.println(ans);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        int T = 1;
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