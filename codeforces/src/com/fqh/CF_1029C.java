 
import java.io.*;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.TreeSet;

public class Main {

    // https://codeforces.com/problemset/problem/1029/C
    public static void solve() throws Exception {
        int n = in.nextInt();
        var a = new long[n][2];
        long maxLeft = Long.MIN_VALUE / 2;
        long minRight = Long.MAX_VALUE / 2;
        var set1 = new TreeMap<Long, Integer>();
        var set2 = new TreeMap<Long, Integer>();
        for (int i = 0; i < n; i++) {
            long l = in.nextLong();
            long r = in.nextLong();
            a[i][0] = l;
            a[i][1] = r;
            maxLeft = Math.max(maxLeft, l);
            minRight = Math.min(minRight, r);
            set1.merge(l, 1, Integer::sum);
            set2.merge(r, 1, Integer::sum);
        }
        long ans = 0;
        // 跟LC周赛的曼哈顿删点的有点像
        for (int i = 0; i < n; i++) {
            long l = a[i][0], r = a[i][1];
            if (l == maxLeft && set1.get(l) == 1) {
                set1.remove(l);
                if (r == minRight && set2.get(r) == 1) {
                    set2.remove(r);
                    ans = Math.max(ans, set2.firstKey() - set1.lastKey());
                    set2.put(r, 1);
                } else {
                    ans = Math.max(ans, minRight - set1.lastKey());
                }
                set1.put(l, 1);
            } else {
                if (r == minRight && set2.get(r) == 1) {
                    set2.remove(r);
                    ans = Math.max(ans, set2.firstKey() - maxLeft);
                    set2.put(r, 1);
                } else {
                    ans = Math.max(ans, minRight - maxLeft);
                }
            }
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
