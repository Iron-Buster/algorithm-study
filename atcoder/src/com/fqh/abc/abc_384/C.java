package com.fqh.abc.abc_384;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class C {

    static String[] a = {"A", "B", "C", "D", "E"};
    static int[] b;
    static List<Pair<String, Integer>> ans;

    public static void solve() throws IOException {
        String s = in.nextLine();
        b = Arrays.stream(s.split(" ")).mapToInt(Integer::parseInt).toArray();
        ans = new ArrayList<>();
        for (int i = 5; i >= 1; i--) {
            dfs(0, 0, "", i);
        }
        ans.sort((x, y) -> {
            if (x.value.intValue() != y.value.intValue()) {
                return y.value - x.value;
            }
            return x.key.compareTo(y.key);
        });
        for (int i = 0; i < ans.size(); i++) {
            out.println(ans.get(i).key);
        }
    }

    static void dfs(int i, int score, String s, int cnt) {
        if (i >= a.length) {
            if (cnt == 0) {
                ans.add(new Pair<>(s, score));
            }
            return;
        }
        // 不选
        dfs(i + 1, score, s, cnt);
        // 选
        dfs(i + 1, score + b[i], s + a[i], cnt - 1);
    }

    static class Pair<K, V> implements Serializable {
        private K key;
        private V value;

        public K getKey() {
            return this.key;
        }

        public V getValue() {
            return this.value;
        }

        public Pair(K var1, V var2) {
            this.key = var1;
            this.value = var2;
        }

        public String toString() {
            String var10000 = String.valueOf(this.key);
            return var10000 + "=" + String.valueOf(this.value);
        }

        public int hashCode() {
            int var1 = 7;
            var1 = 31 * var1 + (this.key != null ? this.key.hashCode() : 0);
            var1 = 31 * var1 + (this.value != null ? this.value.hashCode() : 0);
            return var1;
        }

        public boolean equals(Object var1) {
            if (this == var1) {
                return true;
            } else if (!(var1 instanceof Pair)) {
                return false;
            } else {
                Pair var2 = (Pair) var1;
                if (this.key != null) {
                    if (!this.key.equals(var2.key)) {
                        return false;
                    }
                } else if (var2.key != null) {
                    return false;
                }

                if (this.value != null) {
                    if (!this.value.equals(var2.value)) {
                        return false;
                    }
                } else if (var2.value != null) {
                    return false;
                }

                return true;
            }
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
