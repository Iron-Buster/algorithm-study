package com.fqh.图论.拓扑排序;

import java.util.*;

/**
 * @Author: vq
 * @Date: 2023/11/29 16:21
 * @Version V1.0
 */
public class LC_2192 {

//    2192. 有向无环图中一个节点的所有祖先
//    第 73 场双周赛
//            Q3
//    1788
//    相关标签
//            相关企业
//    提示
//    给你一个正整数 n ，它表示一个 有向无环图 中节点的数目，节点编号为 0 到 n - 1 （包括两者）。
//
//    给你一个二维整数数组 edges ，其中 edges[i] = [fromi, toi] 表示图中一条从 fromi 到 toi 的单向边。
//
//    请你返回一个数组 answer，其中 answer[i]是第 i 个节点的所有 祖先 ，这些祖先节点 升序 排序。
//
//    如果 u 通过一系列边，能够到达 v ，那么我们称节点 u 是节点 v 的 祖先 节点。



    Map<Integer, TreeSet<Integer>> map = new HashMap<>();
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        // 从入度为0的点出发进行拓扑排序，过程中将父节点的fa（祖先集合）加入到当前节点的fa（祖先集合）中
        topoSort(n, edges);
        var ans = new ArrayList<List<Integer>>();
        for (int i = 0; i < n; ++i) {
            TreeSet<Integer> fa = map.getOrDefault(i, new TreeSet<>());
            ans.add(new ArrayList<>(fa));
        }
        return ans;
    }

    void topoSort(int n, int[][] edges) {
        int[] degree = new int[1001];
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0], y = e[1];
            g[x].add(y);
            degree[y]++;
        }
        var q = new ArrayDeque<Integer>();
        for (int i = 0; i < n; ++i) {
            if (degree[i] == 0) {
                q.offer(i);
            }
            map.computeIfAbsent(i, v -> new TreeSet<>());
        }
        while (!q.isEmpty()) {
            int u = q.poll();
            for (int v : g[u]) {
                for (Integer fa : map.get(u)) { // 继承u的祖先节点
                    map.get(v).add(fa);
                }
                map.get(v).add(u);
                degree[v]--;
                if (degree[v] == 0) {
                    q.offer(v);
                }
            }
        }
    }


    public static void main(String[] args) {
        int n = 8;
        int[][] edges = {{0,3},{0,4},{1,3},{2,4},{2,7},{3,5},{3,6},{3,7},{4,6}};
        System.out.println(new LC_2192().getAncestors(n, edges));

    }
}
