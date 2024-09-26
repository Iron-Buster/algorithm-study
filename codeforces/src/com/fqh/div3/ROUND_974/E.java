package com.fqh.div3.ROUND_974;

import java.io.*;
import java.util.*;


public class E {
    // https://codeforces.com/contest/2014/problem/E
    // 拆点 + dijkstra
    public static void solve() throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();
        int h = in.nextInt(); // h个顶点有马

        List<List<Pair<Integer, Integer>>> adj = new ArrayList<>(n * 2);
        for (int i = 0; i < n * 2; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < h; i++) {
            int x = in.nextInt() - 1;
            adj.get(x).add(new Pair<>(x + n, 0));
        }
        for (int i = 0; i < m; i++) {
            int u = in.nextInt() - 1;
            int v = in.nextInt() - 1;
            int w = in.nextInt();
            adj.get(u).add(new Pair<>(v, w));
            adj.get(v).add(new Pair<>(u, w));
            adj.get(u + n).add(new Pair<>(v + n, w / 2));
            adj.get(v + n).add(new Pair<>(u + n, w / 2));
        }

        long[] dist0 = dijkstra(adj, 0, n);
        long[] dist1 = dijkstra(adj, n - 1, n);
        long ans = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            long x = Math.min(dist0[i], dist0[i + n]);
            long y = Math.min(dist1[i], dist1[i + n]);
            ans = Math.min(ans, Math.max(x, y));
        }
        if (ans == Long.MAX_VALUE) {
            out.println(-1);
        } else {
            out.println(ans);
        }
    }


    static long[] dijkstra(List<List<Pair<Integer, Integer>>> adj, int start, int end) {
        long[] dist = new long[end * 2];
        Arrays.fill(dist, Long.MAX_VALUE);
        PriorityQueue<Pair<Integer, Long>> pq = new PriorityQueue<>(Comparator.comparingLong(a -> a.value));
        pq.offer(new Pair<>(start, 0L));
        dist[start] = 0;
        while (!pq.isEmpty()) {
            Pair<Integer, Long> p = pq.poll();
            int u = p.key;
            long d = p.value;
            if (dist[u] < d) {
                continue;
            }
            for (Pair<Integer, Integer> next : adj.get(u)) {
                int v = next.getKey(), w = next.getValue();
                if (dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new Pair<>(v, dist[v]));
                }
            }
        }
        return dist;
    }

    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
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
