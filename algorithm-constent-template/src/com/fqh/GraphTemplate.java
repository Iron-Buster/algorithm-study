package com.fqh;

import java.io.*;
import java.util.*;

/**
 * @Author: vq
 * @Date: 2023/11/7 21:45
 * @Version V1.0
 */
public class GraphTemplate {

    /*
Graph Theory Playlist https://www.youtube.com/playlist?list=PLDV1Zeh2NRsDGO4--qE8yH72HFL1Km93P
图论的小技巧以及扩展 https://www.luogu.com.cn/blog/chengni5673/tu-lun-di-xiao-ji-qiao-yi-ji-kuo-zhan

边权转点权：在 v-w 之间加一个点，这个点的点权就是原来的边权（原图的点的点权视作 0）
点权转边权：将一个点拆分成两个点，用一条边连起来，新边的边权就是该点的点权（原图的边的边权视作 0）
其它情况：也可以用 min/max 等价转换 http://codeforces.com/problemset/problem/915/F

TIPS: 使用一个 fa 数组（初始化为 -1）记录搜索树中的节点的父节点，这样对每个节点都有一条到根的路径（根的 fa 为 -1）
NOTE: 独立集相关问题，可以从染色的角度考虑
NOTE: 度数大于 √M 的点不超过 2√M 个
      相关题目 & 无向图定向 https://leetcode-cn.com/problems/minimum-degree-of-a-connected-trio-in-a-graph/solution/gei-wu-xiang-tu-ding-xiang-by-lucifer100-c72d/

https://oeis.org/A031878 Maximal number of edges in Hamiltonian path in complete graph on n nodes
a(n) = C(n, 2)        n%2==0
a(n) = C(n, 2)-n/2+1  n%2==1

环与独立集 https://codeforces.com/problemset/problem/1364/D
匹配与独立集 https://codeforces.com/problemset/problem/1198/C

建图 https://codeforces.com/problemset/problem/1635/E
归纳 https://codeforces.com/problemset/problem/412/D
构造 https://codeforces.com/problemset/problem/41/E
转换 https://codeforces.com/problemset/problem/788/B
转换 https://codeforces.com/problemset/problem/788/C
加边 https://codeforces.com/problemset/problem/723/E
*/

/*给一无向图，从中删除恰好一条边，求可以让图变成二分图的所有边的下标 https://codeforces.com/problemset/problem/19/E
倒水问题 https://www.luogu.com.cn/problem/P1432
顶点有限制的生成树 https://codeforces.com/problemset/problem/723/F
辅助证明 https://codeforces.com/contest/1839/problem/E

集合哈希 set hashing https://codeforces.com/problemset/problem/154/C

Trémaux tree https://en.wikipedia.org/wiki/Tr%C3%A9maux_tree
DFS 树与 BFS 树 https://atcoder.jp/contests/abc251/tasks/abc251_f
证明 https://atcoder.jp/contests/abc251/editorial/3987

奇妙 BFS https://codeforces.com/problemset/problem/1651/D

竞赛图
竞赛图的一些性质 https://www.cnblogs.com/acha/p/9042984.html
- SCC 的拓扑序是唯一的
- 拓扑序上，不同 SCC 的点的入度，越靠前的严格越小
https://codeforces.com/problemset/problem/1498/E
https://codeforces.com/problemset/problem/1514/E
todo 竞赛图与三元环 https://codeforces.com/problemset/problem/117/C

定义连通性
https://codeforces.com/problemset/problem/1689/E
*/

    // BFS 应用：求无向无权图最小环长度
// 好题 https://codeforces.com/problemset/problem/1325/E
// LC2608 https://leetcode.cn/problems/shortest-cycle-in-a-graph/
    /* 注意不能提前推出（哪怕是遍历完一个找到环的点的所有邻居）
     */

    class Pair {
        int v;
        int fa;

        public Pair(int v, int fa) {
            this.v = v;
            this.fa = fa;
        }
    }

    public int shortestCycleBFS(int n, List<Integer>[] g) {
        int INF = Integer.MAX_VALUE;
        int ans = INF;
        int[] dis = new int[n];
        for (int st = 0; st < g.length; ++st) {
            Arrays.fill(dis, -1);
            dis[st] = 0;
            var q = new ArrayDeque<Pair>();
            q.offer(new Pair(st, -1));
            while (!q.isEmpty()) {
                var p = q.poll();
                int v = p.v;
                int fa = p.fa;
                for (int w : g[v]) {
                    if (dis[w] == -1) {
                        dis[w] = dis[v] + 1;
                        q.offer(new Pair(w, v));
                    } else if (w != fa) {
                        ans = Math.min(ans, dis[w] + dis[v] + 1);
                    }
                }
            }
        }
        return ans;
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

/**
 * DFS 找长度至少为 k 的环
 */
class FindLenKCycle {
    private List<Integer>[] g;
    private boolean[] vis;
    private int k;
    private int end;
    private int start;
    private int[] fa;
    private int[] dep;

    private void DFS_FIND_K_CYCLE(int n, int m) throws IOException {
        // 无向图: DFS 找长度至少为 k 的环
        // 注：如果只有一个环（基环树），见 pseudotree
        // 模板题 https://codeforces.com/problemset/problem/263/D
        // https://codeforces.com/problemset/problem/1325/F
        k = in.nextInt();
        fa = new int[n + 1];
        dep = new int[n + 1];
        while (m-- > 0) {
            int x = in.nextInt();
            int y = in.nextInt();
            g[x].add(y);
            g[y].add(x);
        }
        f(1, 0, 1);
        List<Integer> cycle = new ArrayList<>();
        cycle.add(start);
        int v = end;
        for (; v != start; v = fa[v]) {
            cycle.add(v);
        }
        out.println(cycle);
    }

    private boolean f(int v, int p, int d) {
        fa[v] = p;
        dep[v] = d;
        for (int w : g[v]) {
            if (dep[w] == 0) {
                if (f(w, v, d + 1)) {
                    return true;
                }
            } else if (d - dep[w] >= k) {
                end = v;
                start = w;
                return true;
            }
        }
        return false;
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


/**
 * 第k小路径
 */
class KthShortestPath {
    /* 第k小路径 https://codeforces.com/problemset/problem/1196/F */
    class Edge {
        int u, v;
        long w;

        public Edge(int u, int v, long w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    private Edge[] edges;
    private Map<Integer, Integer> mp;
    private int cnt = 0;
    private long[][] dis;

    private void init() {
        for (int i = 1; i <= cnt; ++i) {
            for (int j = 1; j <= cnt; ++j) {
                if (i == j) continue;
                if (dis[i][j] == 0) dis[i][j] = (long) 1e16;
            }
        }
    }

    private void work() {
        for (int i = 1; i <= cnt; ++i) {
            for (int j = 1; j <= cnt; ++j) {
                for (int k = 1; k <= cnt; ++k) {
                    dis[j][k] = Math.min(dis[j][k], dis[j][i] + dis[i][k]);
                }
            }
        }
    }

    private void findKthPath(int n, int m, int k) throws IOException {
        edges = new Edge[n + 1];
        for (int i = 1; i <= m; ++i) {
            int u = in.nextInt();
            int v = in.nextInt();
            long w = in.nextLong();
            edges[i] = new Edge(u, v, w);
        }
        Arrays.sort(edges, 1, m + 1, (a, b) -> Long.compare(a.w, b.w));
        for (int i = 1; i <= m; ++i) {
            if (!mp.containsKey(edges[i].u)) {
                mp.put(edges[i].u, ++cnt);
            }
            if (!mp.containsKey(edges[i].v)) {
                mp.put(edges[i].v, ++cnt);
            }
            int u = mp.get(edges[i].u);
            int v = mp.get(edges[i].v);
            long w = edges[i].w;
            if (dis[u][v] == 0) {
                dis[u][v] = dis[v][u] = (long) 1e16;
            }
            dis[u][v] = dis[v][u] = Math.min(dis[u][v], w);
            if (i >= k) break;
        }
        init();
        work();
        List<Long> ans = new ArrayList<>();
        for (int i = 1; i <= cnt; ++i) {
            for (int j = i + 1; j <= cnt; ++j) {
                if (dis[i][j] == 0 || dis[i][j] == 1e16) continue;
                ans.add(dis[i][j]);
            }
        }
        Collections.sort(ans);
        out.println(ans.get(k - 1));
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


// 单源最短路 Dijkstra
// 适用于稀疏图 O(mlogm)
// 这里实现的是懒更新（lazy）版本的 Dijkstra，复杂度为 O(mlogm)
// 若在插入堆时元素已在堆中，改成直接更新元素，而不是插入元素，可使复杂度降为 O(mlogn)
//
// st 也可以是一个点集，这相当于同时对多个点跑最短路
// 视频讲解（第四题）https://www.bilibili.com/video/BV1wj411G7sH/
// 可视化 https://visualgo.net/zh/sssp
// https://oi-wiki.org/graph/shortest-path/#dijkstra
// 最短路问题笔记 https://www.luogu.com.cn/blog/SCN/zui-duan-lu-wen-ti-bi-ji
//
// 模板题 https://www.luogu.com.cn/problem/P3371 https://www.luogu.com.cn/problem/P4779
//       https://codeforces.com/problemset/problem/20/C
//       LC743 https://leetcode-cn.com/problems/network-delay-time/
// 超级源点 LC2473 https://leetcode.cn/problems/minimum-cost-to-buy-apples/
// 结合二分 https://codeforces.com/problemset/problem/229/B
// 最短路个数 https://www.luogu.com.cn/problem/P1608
// 通过最短路找到可以删除的边 https://codeforces.com/problemset/problem/449/B
// 稠密图 https://atcoder.jp/contests/arc064/tasks/arc064_c
// 【理解本质】https://atcoder.jp/contests/abc271/tasks/abc271_e
// 建模 https://www.luogu.com.cn/problem/P4644
// 建模 LC864 https://leetcode-cn.com/problems/shortest-path-to-get-all-keys/
// 建模【好题】https://codeforces.com/contest/1528/problem/D
// 建模+转换+多源最短路 https://codeforces.com/problemset/problem/1753/D
// 还能再走多远？LC882 https://leetcode.cn/problems/reachable-nodes-in-subdivided-graph/
// 转换 LC2577 https://leetcode.cn/problems/minimum-time-to-visit-a-cell-in-a-grid/
// 转换 https://atcoder.jp/contests/abc237/tasks/abc237_e
// 转换 https://codeforces.com/contest/1842/problem/D
// 双关键字+记录路径编号 https://codeforces.com/problemset/problem/507/E
// 关键边、伪关键边（与割边结合）https://codeforces.com/problemset/problem/567/E
// 基于 max LC1631 https://leetcode-cn.com/problems/path-with-minimum-effort/
// [SDOI2010]大陆争霸 https://www.luogu.com.cn/problem/P2446
// [AHOI2014/JSOI2014]骑士游戏 https://www.luogu.com.cn/problem/P4042
// 转换 https://codeforces.com/problemset/problem/1693/C
// 题目推荐 https://cp-algorithms.com/graph/dijkstra.html#toc-tgt-5
// 线段树建图优化 https://codeforces.com/problemset/problem/786/B
// - todo [SNOI2017] 炸弹 https://www.luogu.com.cn/problem/P5025
// 涉及到相邻两条边的最短路 https://codeforces.com/contest/1486/problem/E
// todo 与扩欧结合 https://www.acwing.com/problem/content/3418/
// 跑两遍最短路，第二次修正边权来改变最短路 https://codeforces.com/problemset/problem/715/B
// 分层图最短路
//    空间压缩 https://codeforces.com/problemset/problem/1442/C
//    转换 https://codeforces.com/problemset/problem/1473/E
// todo 动态最短路 https://codeforces.com/problemset/problem/1163/F
//
// 最短路径树
// todo https://xyzl.blog.luogu.org/Shortest-Path-Tree-SPT
// 最短路树上跑拓扑排序 LC1786 https://leetcode.cn/problems/number-of-restricted-paths-from-first-to-last-node/
// 最短路树上跑拓扑排序 https://codeforces.com/contest/1076/problem/D
// todo https://codeforces.com/problemset/problem/1005/F
// todo MST https://codeforces.com/problemset/problem/545/E
//  https://atcoder.jp/contests/arc090/tasks/arc090_c

class DijkstraTemplate {
    static class Edge {
        int v;
        long w;

        Edge(int v, long w) {
            this.v = v;
            this.w = w;
        }
    }

    static long[] dist;
    static boolean[] vis;
    static List<Edge>[] g;
    static int[] par;
    static final Long INF = Long.MAX_VALUE;

    static boolean dijkstra(int start, int end) {
        var pq = new PriorityQueue<Edge>((a, b) -> Long.compare(a.w, b.w));
        pq.offer(new Edge(start, 0));
        dist[start] = 0;
        par[start] = -1;
        while (!pq.isEmpty()) {
            var p = pq.poll();
            int u = p.v;
            if (u == end) {
                return true;
            }
            vis[u] = true;
            for (Edge next : g[u]) {
                int v = next.v;
                long w = next.w;
                if (!vis[v] && dist[u] + w < dist[v]) {
                    dist[v] = dist[u] + w;
                    pq.offer(new Edge(v, dist[v]));
                    par[v] = u;
                }
            }
        }
        return false;
    }

    // dijk求最长路
    // 经典Dijsktra可在全负权边图中跑最长路、全正权边图中跑最短路
    static long dijkstra2(int start, int end) {
        var pq = new PriorityQueue<Edge>((a, b) -> Long.compare(a.w, b.w));
        pq.offer(new Edge(start, -1));
        dist[start] = 1;
        while (!pq.isEmpty()) {
            var p = pq.poll();
            int u = p.v;
            long w = p.w;
            w *= -1;
            if (u == end) {
                return w;
            }
            vis[u] = true;
            for (Edge next : g[u]) {
                int v = next.v;
                long next_w = next.w;
                if (!vis[v] && dist[v] < dist[u] + next_w) {
                    dist[v] = dist[u] + next_w;
                    pq.offer(new Edge(v, -dist[v]));
                }
            }
        }
        return -1;
    }

    static void solve() throws IOException {
        int n = in.nextInt();
        int m = in.nextInt();

        g = new ArrayList[n + 1];
        dist = new long[n + 1];
        par = new int[n + 1];
        vis = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            g[i] = new ArrayList<>();
            dist[i] = INF;
        }
        int u, v;
        long w;
        for (int i = 0; i < m; i++) {
            u = in.nextInt();
            v = in.nextInt();
            w = in.nextLong();
            g[u].add(new Edge(v, w));
            g[v].add(new Edge(u, w));
        }

        if (dijkstra(1, n)) {
            StringBuilder ans = new StringBuilder();
            List<Integer> path = new ArrayList<>();

            for (v = n; v != -1; v = par[v])
                path.add(v);

            // reversing path
            for (int i = path.size() - 1; i >= 0; i--) {
                ans.append(path.get(i)).append(" ");
            }
            out.println(ans);
        } else {
            out.println("-1");
        }
    }

    public static void main(String[] args) throws IOException {
        solve();
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


// 任意两点最短路 Floyd-Warshall  O(n^3)  本质是求 Min-plus matrix multiplication
// 传入邻接矩阵 dis
// dis[v][w] == inf 表示没有 v-w 边
// 带你发明 Floyd 算法！https://leetcode.cn/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/solution/dai-ni-fa-ming-floyd-suan-fa-cong-ji-yi-m8s51/
// https://en.wikipedia.org/wiki/Floyd%E2%80%93Warshall_algorithm
// https://en.wikipedia.org/wiki/Min-plus_matrix_multiplication
// https://cp-algorithms.com/graph/all-pair-shortest-path-floyd-warshall.html#toc-tgt-5
//
// 模板题 https://www.luogu.com.cn/problem/B3647
// 传递闭包 https://www.luogu.com.cn/problem/B3611
// https://codeforces.com/problemset/problem/33/B
// https://codeforces.com/problemset/problem/1204/C
// LC1334 https://leetcode.cn/problems/find-the-city-with-the-smallest-number-of-neighbors-at-a-threshold-distance/
// LC1462 https://leetcode.cn/problems/course-schedule-iv/
// 动态加点 https://codeforces.com/problemset/problem/295/B
// 动态加边 LC2642 https://leetcode.cn/problems/design-graph-with-shortest-path-calculator/
// - https://codeforces.com/problemset/problem/25/C LC2646 https://leetcode.cn/problems/minimize-the-total-price-of-the-trips/
// todo https://atcoder.jp/contests/abc243/tasks/abc243_e
// 传递闭包 UVa247 https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=4&page=show_problem&problem=183
// 注：求传递闭包时，若 i-k 不连通，则最内层循环无需运行
// 任意两点最大边权最小路径 UVa10048 https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=12&page=show_problem&problem=989


class FloydTemplate {
    static long[][] floyd(long[][] dist) {
        // dis[k][i][j] 表示「经过若干个编号不超过 k 的中间节点」时，从 i 到 j 的最短路长度，其中第一维可以压缩掉
        // 为什么可以把第一维度去掉？dis[i][k] 和 dis[k][j] 不会被覆盖掉吗？
        // 见算法导论第三版练习 25.2-4（网络上有习题解答）

        // 初始化，注意 dis[i][i] = 0
        //dis := make([][]int, n)
        //for i := range dis {
        //	dis[i] = make([]int, n)
        //	for j := range dis[i] {
        //		if j != i {
        //			dis[i][j] = math.MaxInt / 2
        //		}
        //	}
        //}
        int n = dist.length;
        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    // 不选 k，选 k
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        // 如果出现 dis[i][i] < 0 则说明有负环
        // 动态加边
        // https://codeforces.com/problemset/problem/25/C
        // LC2642 https://leetcode.cn/problems/design-graph-with-shortest-path-calculator/
        return dist;
    }

    static void addEdge(int[][] dist, int from, int to, int wt) {
        // 无法让任何最短路变短
        if (wt >= dist[from][to]) {
            return;
        }
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist.length; j++) {
                dist[i][j] = Math.min(dist[i][j], dist[i][from] + wt + dist[to][j]);
            }
        }
    }
}