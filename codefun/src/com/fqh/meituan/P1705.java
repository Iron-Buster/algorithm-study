package com.fqh.meituan;

import java.io.*;
import java.util.*;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/18 11:33
 **/
public class P1705 {

    //#P1705. 2024.3.16美团-第五题-塔子哥的排列
    //https://codefun2000.com/p/P1705


    public static void solve() throws IOException {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.nextInt();
        }
        TreeSet<Integer> tset = new TreeSet<>();
        for (int x : a) tset.add(x);
        Map<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (int x : tset) map.put(x, rank++);
        FenwickTree ft = new FenwickTree(map.size() + 1);
        // ans[i] = 总的逆序对数量 - 当前数字形成的逆序对数量 + 当前数字取反后形成的逆序对数量
        // 将第i个元素取反后，前面i-1个元素都比a[i]大，形成了i-1个逆序对
        int sum = 0, r = map.size();
        int[] left = new int[n], right = new int[n];
        for (int i = 0; i < n; i++) {
            Integer index = map.get(a[i]);
            left[i] = ft.query(r) - ft.query(index);
            sum += left[i];
            ft.change(index, 1);
        }
        FenwickTree ft2 = new FenwickTree(map.size() + 1);
        for (int i = n - 1; i >= 0; i--) {
            Integer index = map.get(a[i]);
            right[i] = ft2.query(index - 1);
            ft2.change(index, 1);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(sum - left[i] - right[i] + i);
        }
        for (int v : ans) out.print(v + " ");
        out.println();
    }

    static class FenwickTree {
        int n;
        int[] s = new int[200005]; // 区间和

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
