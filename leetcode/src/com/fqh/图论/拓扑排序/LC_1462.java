package com.fqh.图论.拓扑排序;

import java.util.*;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2023/12/29 16:41
 **/
public class LC_1462 {

    Map<Integer, HashSet<Integer>> map = new HashMap<>();
    // 一模一样的题目 LC_2192-有向无环图中一个节点的所有祖先
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        topoSort(numCourses, prerequisites);
        List<Boolean> ans = new ArrayList<>();
        for (int[] q : queries) {
            int u = q[0], v = q[1];
           ans.add(map.get(v).contains(u));
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
            map.computeIfAbsent(i, v -> new HashSet<>());
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


//    1462. 课程表 IV
//    第 27 场双周赛
//            Q3
//1693
//    相关标签
//            相关企业
//    提示
//    你总共需要上 numCourses 门课，课程编号依次为 0 到 numCourses-1 。你会得到一个数组 prerequisite ，其中 prerequisites[i] = [ai, bi] 表示如果你想选 bi 课程，你 必须 先选 ai 课程。
//
//    有的课会有直接的先修课程，比如如果想上课程 1 ，你必须先上课程 0 ，那么会以 [0,1] 数对的形式给出先修课程数对。
//    先决条件也可以是 间接 的。如果课程 a 是课程 b 的先决条件，课程 b 是课程 c 的先决条件，那么课程 a 就是课程 c 的先决条件。
//
//    你也得到一个数组 queries ，其中 queries[j] = [uj, vj]。对于第 j 个查询，您应该回答课程 uj 是否是课程 vj 的先决条件。
//
//    返回一个布尔数组 answer ，其中 answer[j] 是第 j 个查询的答案。

}
