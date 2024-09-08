package com.fqh;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.util.TreeMap;


public class CF_2009G1 {
//    https://codeforces.com/contest/2009/problem/G1

//    '''
//    对于          1 2 3  2  1  2  3
//    减去他们的下标  1 1 1 -1 -3 -3 -3
//    如果是一段连续的自然数，那么减去下标后值相同
//    那么对于区间[L,R]，找到出现次数最多的值，其余的全部改掉就行了
//    src: 1 2 5 4 5
//    map: 1 1 3 1 1
//    只需要修改 3就行了
//    '''

    public static void solve() throws IOException {
        int n = in.nextInt();
        int k = in.nextInt();
        int q = in.nextInt();
        int[] a = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int x = in.nextInt();
            a[i] = x - i;
        }
        var map = new HashMap<Integer, Integer>();
        var count = new TreeMap<Integer, Integer>();
        int j = 1;
        var ans = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            map.merge(a[i], 1, Integer::sum);
            int cnt = map.get(a[i]);
            count.merge(cnt - 1, -1, Integer::sum);
            if (count.get(cnt - 1) == 0) count.remove(cnt - 1);
            count.merge(cnt, 1, Integer::sum);

            if (i - j + 1 > k) {
                map.merge(a[j], -1, Integer::sum);
                int cnt1 = map.get(a[j]);
                if (cnt1 == 0) map.remove(a[j]);
                count.merge(cnt1 + 1, -1, Integer::sum);
                if (count.get(cnt1 + 1) == 0) count.remove(cnt1 + 1);
                count.merge(cnt1, 1, Integer::sum);
                j++;
            }
            if (i >= k) {
                ans.add(k - count.lastKey());
            }
        }

        for (int i = 0; i < q; i++) {
            String[] lr = in.nextLine().split(" ");
            int l = Integer.parseInt(lr[0]);
            out.println(ans.get(l - 1));
        }

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
