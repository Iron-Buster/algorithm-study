package com.fqh.LCA问题.倍增;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/25 23:03
 **/
public class LC_1483 {

//    1483. 树节点的第 K 个祖先
//    第 193 场周赛
//            Q4
//    2115
//    相关标签
//            相关企业
//    提示
//    给你一棵树，树上有 n 个节点，按从 0 到 n-1 编号。树以父节点数组的形式给出，其中 parent[i] 是节点 i 的父节点。树的根节点是编号为 0 的节点。
//
//    树节点的第 k 个祖先节点是从该节点到根节点路径上的第 k 个节点。
//
//    实现 TreeAncestor 类：
//
//    TreeAncestor（int n， int[] parent） 对树和父数组中的节点数初始化对象。
//    getKthAncestor(int node, int k) 返回节点 node 的第 k 个祖先节点。如果不存在这样的祖先节点，返回 -1 。

    class TreeAncestor {
        LCA lca;

        public TreeAncestor(int n, int[] parent) {
            lca = new LCA(n);
            for (int i = 0; i < n; i++) {
                if (parent[i] == -1)
                    continue;
                // 让节点从1开始
                int x = i + 1;
                int y = parent[i] + 1;
                lca.g[x].add(y);
                lca.g[y].add(x);
            }
            lca.dfs(1, 0);
        }

        public int getKthAncestor(int node, int k) {
            return lca.getKthAncestor(node + 1, k) - 1;
        }
    }

    class LCA {
        //倍增求LCA模板
        static final int N  = (int) (5e5 + 10);
        int n, s;
        List<Integer>[] g = new List[N];
        int[] dep = new int[N];
        int[][] fa = new int[N][22];

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
            for (int v : g[u]) {
                if (v != father) {
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

        /**
         * 返回node的第k个祖先
         * @param node
         * @param k
         * @return
         */
        public int getKthAncestor(int node, int k) {
            int m = 32 - Integer.numberOfLeadingZeros(k);
            for (int i = 0; i < m; i++) {
                if ((k >> i & 1) == 1) {
                    node = fa[node][i];
                    if (node == 0) // 跳出界了
                        break;
                }
            }
            return node;
        }

        public LCA(int n) {
            for (int i = 1; i <= n; i++) {
                g[i] = new ArrayList<>();
            }
        }
    }


    public static void main(String[] args) {
        // 1 2 4 8
//        System.out.println(1<<(3-1));
//        TreeAncestor treeAncestor = new TreeAncestor(10, new int[]{-1,0,0,1,2,0,1,3,6,1});
//        System.out.println(treeAncestor.getKthAncestor(7, 3));
    }
}
