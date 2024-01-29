package com.fqh.树上差分;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/29 23:45
 **/
public class LC_2646 {

//    2646. 最小化旅行的价格总和
//            已解答
//    第 341 场周赛
//            Q4
//    2238
//    相关标签
//            相关企业
//    提示
//    现有一棵无向、无根的树，树中有 n 个节点，按从 0 到 n - 1 编号。给你一个整数 n 和一个长度为 n - 1 的二维整数数组 edges ，其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条边。
//
//    每个节点都关联一个价格。给你一个整数数组 price ，其中 price[i] 是第 i 个节点的价格。
//
//    给定路径的 价格总和 是该路径上所有节点的价格之和。
//
//    另给你一个二维整数数组 trips ，其中 trips[i] = [starti, endi] 表示您从节点 starti 开始第 i 次旅行，并通过任何你喜欢的路径前往节点 endi 。
//
//    在执行第一次旅行之前，你可以选择一些 非相邻节点 并将价格减半。
//
//    返回执行所有旅行的最小价格总和。

    List<Integer>[] g;
    int[] power = new int[51];
    int[] dep = new int[51];
    int[][] fa = new int[51][22];

    void dfs(int u, int f) { // 倍增预处理
        dep[u] = dep[f] + 1;
        fa[u][0] = f;
        for (int i = 1; i <= 20; i++) {
            fa[u][i] = fa[fa[u][i-1]][i-1];
        }
        for (int v : g[u]) {
            if (v != f) {
                dfs(v, u);
            }
        }
    }
    int lca(int u, int v) { // 倍增求lca
        if (dep[u] < dep[v]) {
            // swap(u, v)
            int temp = u;
            u = v;
            v = temp;
        }
        for (int i = 20; i >= 0; i--) {
            if (dep[fa[u][i]] >= dep[v]) {
                u = fa[u][i];
            }
        }
        if (u == v) return v;
        for (int i = 20; i >= 0; i--) {
            if (fa[u][i] != fa[v][i]) {
                u = fa[u][i];
                v = fa[v][i];
            }
        }
        return fa[u][0];
    }

    int[] dfs2(int u, int f, int[] price) {
        int s = power[u];
        int v1 = 0, v2 = 0;
        for (int v : g[u]) {
            if (v == f) continue;
            int[] sub = dfs2(v, u, price);
            v1 += Math.min(sub[1], sub[2]);
            v2 += sub[1];
            s += sub[0];
        }
        v1 += price[u-1] * s;     // u不减半
        v2 += price[u-1] * s / 2; // u减半
        return new int[]{s, v1, v2};
    }


    public int minimumTotalPrice(int n, int[][] edges, int[] price, int[][] trips) {
        g = new List[n+1];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] edge : edges) {
            int x = edge[0] + 1;
            int y = edge[1] + 1;
            g[x].add(y);
            g[y].add(x);
        }
        dfs(1, 0);
        for (int[] q : trips) {
            int x = q[0] + 1;
            int y = q[1] + 1;
            int l = lca(x, y);
            ++power[x]; ++power[y]; // 树上差分
            --power[l]; --power[fa[l][0]];
        }
        int[] res = dfs2(1, 0, price);
        return Math.min(res[1], res[2]);
    }
}
