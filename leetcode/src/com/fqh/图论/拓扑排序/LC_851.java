package com.fqh.图论.拓扑排序;

import java.util.*;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2023/12/26 18:08
 **/
public class LC_851 {

    Map<Integer, TreeSet<Integer>> map = new HashMap<>();
    // 相似题目：LC_2192 有向无环图中一个节点的所有祖先
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        topoSort(n, richer, quiet);
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            TreeSet<Integer> tset = map.get(i);
            if (tset.size() == 0) continue;
            ans[i] = tset.first();
        }
        return ans;
    }

    public void topoSort(int n, int[][] edges, int[] quiet) {
        int[] degree = new int[n];
        List<Integer>[] g = new List[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0], y = e[1];
            g[x].add(y);
            degree[y]++;
        }
        var q = new ArrayDeque<Integer>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) {
                q.offer(i);
            }
            // 用平衡树维护安静值
            map.computeIfAbsent(i, v -> new TreeSet<>((x, y) -> quiet[x] - quiet[y]));
            map.get(i).add(i); // 自己也要算上
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

//    851. 喧闹和富有
//    第 88 场周赛
//            Q3
//    1783
//    相关标签
//            相关企业
//    有一组 n 个人作为实验对象，从 0 到 n - 1 编号，其中每个人都有不同数目的钱，以及不同程度的安静值（quietness）。为了方便起见，我们将编号为 x 的人简称为 "person x "。
//
//    给你一个数组 richer ，其中 richer[i] = [ai, bi] 表示 person ai 比 person bi 更有钱。另给你一个整数数组 quiet ，
//    其中 quiet[i] 是 person i 的安静值。richer 中所给出的数据 逻辑自洽（也就是说，在 person x 比 person y 更有钱的同时，不会出现 person y 比 person x 更有钱的情况 ）。
//
//    现在，返回一个整数数组 answer 作为答案，其中 answer[x] = y 的前提是，在所有拥有的钱肯定不少于 person x 的人中，person y 是最安静的人（也就是安静值 quiet[y] 最小的人）。
//
//
//
//    示例 1：
//
//    输入：richer = [[1,0],[2,1],[3,1],[3,7],[4,3],[5,3],[6,3]], quiet = [3,2,5,4,6,1,7,0]
//    输出：[5,5,2,5,4,5,6,7]
//    解释：
//    answer[0] = 5，
//    person 5 比 person 3 有更多的钱，person 3 比 person 1 有更多的钱，person 1 比 person 0 有更多的钱。
//    唯一较为安静（有较低的安静值 quiet[x]）的人是 person 7，
//    但是目前还不清楚他是否比 person 0 更有钱。
//    answer[7] = 7，
//    在所有拥有的钱肯定不少于 person 7 的人中（这可能包括 person 3，4，5，6 以及 7），
//    最安静（有较低安静值 quiet[x]）的人是 person 7。
//    其他的答案也可以用类似的推理来解释。

    public static void main(String[] args) {
        int[][] richer = {{1,0},{2,1},{3,1},{3,7},{4,3},{5,3},{6,3}};
        int[] quiet = {3, 2, 5, 4, 6, 1, 7, 0};
        System.out.println(Arrays.toString(new LC_851().loudAndRich(richer, quiet)));
    }
}
