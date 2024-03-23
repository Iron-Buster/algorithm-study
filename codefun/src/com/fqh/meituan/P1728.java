package com.fqh.meituan;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/23 17:14
 **/
public class P1728 {

    // https://codefun2000.com/p/P1728
    //#P1728. 2024.3.23-美团-第三题-塔子哥的染色数组


    // 计算将数组排序的最小交换次数
    // 最少交换次数 = 节点数n - 形成的环数

    public static int getMinSwaps(int[] nums, char[] s) {
        var nums1 = nums.clone();
        Arrays.sort(nums1);
        var map = new HashMap<Integer, Integer>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            map.put(nums1[i], i); // 建立每个元素与其应放位置的映射
        }
        int r = 0;
        var vis = new boolean[n];
        // 找出交换环的个数
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                int j = i;
                while (!vis[j]) {
                    vis[j] = true;
                    if (s[map.get(nums[j])] != s[j]) {
                        return -1;
                    }
                    j = map.get(nums[j]); // 原序列中j的位置在有序序列中的位置

                }
                r++;
            }
        }
        return n - r;
    }

    public static void solve() throws IOException {
        int n = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = in.nextInt();
        char[] s = in.nextLine().toCharArray();

        int res = getMinSwaps(a, s);
        out.println(res);

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
