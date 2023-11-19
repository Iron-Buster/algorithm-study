package com.fqh;

import java.io.*;
import java.util.*;

/**
 * @Author: vq
 * @Date: 2023/11/7 21:45
 * @Version V1.0
 */
public class Graph {

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

todo《挑战》例题+练习题
2.5 节 - 最短路 & 最小生成树
3255 https://www.luogu.com.cn/problem/P2865 次短路
3723 http://poj.org/problem?id=3723 建模+MST
3169 https://www.luogu.com.cn/problem/P4878 差分约束
2139 http://poj.org/problem?id=2139 Floyd
3259 https://www.luogu.com.cn/problem/P2850 多源 SPFA（建议读原文，洛谷翻译不完整）
3268 https://www.luogu.com.cn/problem/P1821 反图 Dij
https://onlinejudge.u-aizu.ac.jp/problems/2249 Dij 的过程中更新花费，注意距离相等时取花费最小值
https://onlinejudge.u-aizu.ac.jp/problems/2200 todo
1258 https://www.luogu.com.cn/problem/P1546 Prim
2377 http://poj.org/problem?id=2377 最大生成树
https://onlinejudge.u-aizu.ac.jp/problems/2224 为了让原图无环，需要去除不在最大生成树上的边
2395 https://www.luogu.com.cn/problem/P1547 最小生成树的最长边：Kruskal 中最后一条加入 MST 中的边的长度
3.5 节 - 二分图
3041
3057
1274
2112
1486
1466
3692
2724
2226
AOJ 2251
3.5节 - 网络流
最大流
3281
3469
3713
2987
2914
3155
最小费用流
2135
2175
3686
3680
3068
2195
3422
AOJ 2266
AOJ 2230
4.3 节 - SCC & 2SAT
2186
3683
3180
1236
3678
2723
2749
*/
    private List<Integer>[] g;
    private boolean[] vis;

    /*
## 图上的 DFS
- [547. 省份数量](https://leetcode.cn/problems/number-of-provinces/)
- [2316. 统计无向图中无法互相到达点对数](https://leetcode.cn/problems/count-unreachable-pairs-of-nodes-in-an-undirected-graph/) 1604
- [1319. 连通网络的操作次数](https://leetcode.cn/problems/number-of-operations-to-make-network-connected/) 1633
- 三色标记法 [802. 找到最终的安全状态](https://leetcode.cn/problems/find-eventual-safe-states/) 1962

DAG [797. 所有可能的路径](https://leetcode.cn/problems/all-paths-from-source-to-target/) 1383

https://atcoder.jp/contests/arc111/tasks/arc111_b
EXTRA: 先染色，再递归 https://codeforces.com/problemset/problem/1470/D
无向图后向边定向 https://codeforces.com/problemset/problem/1519/E
https://codeforces.com/problemset/problem/1176/E
与 MST 结合 https://codeforces.com/problemset/problem/1707/C
*/

    {
        // 有向图的环/回边检测/012染色
        //《算法导论》p.353 边的分类
        // vis[v] == 0：该顶点未被访问
        // vis[v] == 1：该顶点已经被访问，其子树未遍历完
        // vis[v] == 2：该顶点已经被访问，其子树已遍历完
        // LC802 https://leetcode-cn.com/problems/find-eventual-safe-states/
        // http://codeforces.com/problemset/problem/25/D
        // https://codeforces.com/problemset/problem/698/B
        // https://codeforces.com/problemset/problem/936/B
        // https://codeforces.com/problemset/problem/1217/D 给一个有向图着色，使得没有一个环只有一个颜色，求使用的颜色数量的最小值
        // https://codeforces.com/problemset/problem/1547/G
        try {
            int n = in.nextInt();
            int[] color = new int[n];
            for (int i = 0; i < color.length; i++) {
                if (color[i] == 0) {
                    f(color, i);
                }
            }
        } catch (Exception e) {
        }
    }

    private void f(int[] color, int v) {
        color[v] = 1;
        for (int w : g[v]) {
            if (color[w] == 0) {        // 未访问过，即 DFS 树上的树边【树枝边】
                f(color, w);
            } else if (color[w] == 1) { // 后向边，说明有环

            } else {                    // 前向边或横向边，说明有多条路径可以到 w

            }
            color[v] = 2;
        }
    }


    {
        // 无向图分类：无环/自环/一般环
        // https://codeforces.com/contest/1770/problem/D
        int c = 0; // 默认：无环
        f(0, -1);
    }

    private void f(int v, int fa) {
        int c = 0; // 默认：无环
        vis[v] = true;
        for (int w : g[v]) {
            if (w == fa) continue;
            if (w == v) {
                // 自环
                c = 1;
            } else if (vis[w]) { // 返祖边或者横向边（v 连向不在子树 v 上的点 w）
                // 一般环
                c = 2;
            } else {    // 树枝边
                f(w, v);
            }
        }
    }


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
