package com.fqh.LCA问题.倍增;

import java.util.*;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/26 10:48
 **/
public class LC_2846 {

    LCA lca;

    public int[] minOperationsQueries(int n, int[][] edges, int[][] queries) {
        lca = new LCA(n);
        for (int[] edge : edges) {
            int x = edge[0] + 1;
            int y = edge[1] + 1;
            int w = edge[2];
            lca.g[x].add(new int[]{y, w});
            lca.g[y].add(new int[]{x, w});
        }
        lca.dfs(1, 0);
        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int u = queries[i][0] + 1;
            int v = queries[i][1] + 1;
            int LCA = lca.lca(u, v);
            int depth = lca.dep[LCA];
            int u_depth = lca.dep[u];
            int v_depth = lca.dep[v];
            int mx = 0; // 出现次数最多的边权的个数
            for (int j = 1; j <= 26; j++) {
                mx = Math.max(mx, lca.cnt[u][j] + lca.cnt[v][j] - 2 * lca.cnt[LCA][j]);
            }
            ans[i] = (u_depth + v_depth - 2 * depth) - mx;
        }
        return ans;
    }

    class LCA {
        //倍增求LCA模板
        static final int N  = (int) (4e5 + 10);
        int n, s;
        List<int[]>[] g;
        int[] dep;
        int[][] fa;
        int[][] cnt; // cnt[i][x] 表示从节点1到节点i边权为x出现的次数

        /**
         * dfs树上倍增
         * @param u
         * @param father
         */
        public void dfs(int u, int father) { //树增dep,fa
            dep[u] = dep[father] + 1;
            // 向上跳1，2，4...步的祖先节点
            fa[u][0] = father;
            for (int i = 1; i <= 20; i++) {
                fa[u][i] = fa[fa[u][i-1]][i-1];
            }
            for (int[] next : g[u]) {
                int v = next[0], w = next[1];
                if (v != father) {
                    for (int i = 1; i <= 26; i++) {
                        cnt[v][i] += cnt[u][i];
                    }
                    cnt[v][w]++;
                    dfs(v, u);
                }

            }
        }
        /**
         * 返回u和v的最近公共祖先
         * @param u
         * @param v
         * @return
         */
        public int lca(int u, int v) {
            if (dep[u] < dep[v]) {
                // swap(u, v)
                int temp = u;
                u = v;
                v = temp;
            }
            //u先大步后小步向上跳，直到与v同层
            for (int i = 20; i >= 0; i--) {
                if (dep[fa[u][i]] >= dep[v]) {
                    u = fa[u][i];
                }
            }
            if (u == v) return v;
            //u,v一起向上跳，直到lca的下面
            for (int i = 20; i >= 0; i--) {
                if (fa[u][i] != fa[v][i]) {
                    u = fa[u][i];
                    v = fa[v][i];
                }
            }
            return fa[u][0];
        }

        public LCA(int n) {
            g = new List[n+1];
            dep = new int[n+1];
            fa = new int[n+1][22];
            cnt = new int[n+1][27];
            for (int i = 1; i <= n; i++) {
                g[i] = new ArrayList<>();
            }
        }
    }

    public static void main(String[] args) {
        int n = 7;
        int[][] edges = {{0,1,1},{1,2,1},{2,3,1},{3,4,2},{4,5,2},{5,6,2}};
        int[][] queries = {{0,3},{3,6},{2,6},{0,6}};
        System.out.println(Arrays.toString(new LC_2846().minOperationsQueries(n, edges, queries)));
    }
}
