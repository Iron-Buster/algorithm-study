package com.fqh.动态规划.树形DP;

import java.util.*;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/29 09:52
 **/
public class LC_2581 {

//    2581. 统计可能的树根数目
//    第 99 场双周赛
//            Q4
//    2228
//    相关标签
//            相关企业
//    提示
//    Alice 有一棵 n 个节点的树，节点编号为 0 到 n - 1 。树用一个长度为 n - 1 的二维整数数组 edges 表示，其中 edges[i] = [ai, bi] ，表示树中节点 ai 和 bi 之间有一条边。
//
//    Alice 想要 Bob 找到这棵树的根。她允许 Bob 对这棵树进行若干次 猜测 。每一次猜测，Bob 做如下事情：
//
//    选择两个 不相等 的整数 u 和 v ，且树中必须存在边 [u, v] 。
//    Bob 猜测树中 u 是 v 的 父节点 。
//    Bob 的猜测用二维整数数组 guesses 表示，其中 guesses[j] = [uj, vj] 表示 Bob 猜 uj 是 vj 的父节点。
//
//    Alice 非常懒，她不想逐个回答 Bob 的猜测，只告诉 Bob 这些猜测里面 至少 有 k 个猜测的结果为 true 。
//
//    给你二维整数数组 edges ，Bob 的所有猜测和整数 k ，请你返回可能成为树根的 节点数目 。如果没有这样的树，则返回 0。
    List<Integer>[] g;
    int[] cnt;
    Map<Integer, HashSet<Integer>> map = new HashMap<>();
    // 换根过程中，受影响的只有两个节点的关系，考虑u-v如果在guesses中，并且v-u不在guesses中，那么guess的次数就要减一，否则guess次数+1
    public int rootCount(int[][] edges, int[][] guesses, int k) {
        int n = edges.length + 1;
        g = new List[n];
        cnt = new int[n];
        Arrays.setAll(g, v -> new ArrayList<>());
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            g[x].add(y);
            g[y].add(x);
        }
        for (int[] guess : guesses) {
            int u = guess[0], v = guess[1];
            map.computeIfAbsent(v, e -> new HashSet<>()).add(u);
        }
        // 计算以0为根节点的猜中次数cnt[0]
        dfs(0, -1);
        // 换根dp计算以x为根的猜中次数cnt[x]
        dfs1(0, -1);
        int ans = 0;
        for (int x : cnt) if (x >= k) ans++;
        return ans;
    }

    void dfs(int x, int fa) {
        for (int y : g[x]) {
            if (y == fa) continue;
            dfs(y, x);
        }
        if (fa != -1 && map.containsKey(x)) {
            HashSet<Integer> set = map.get(x);
            if (set.contains(fa)) cnt[0]++;
        }
    }

    void dfs1(int x, int fa) {
        if (fa != -1) {
            cnt[x] = cnt[fa];
            if (map.getOrDefault(x, new HashSet<>()).contains(fa)) {
                cnt[x]--;
            }
            if (map.getOrDefault(fa, new HashSet<>()).contains(x)) {
                cnt[x]++;
            }
        }
        for (int y : g[x]) {
            if (y == fa) continue;
            dfs1(y, x);
        }
    }

//    输入：edges = [[0,1],[1,2],[1,3],[4,2]], guesses = [[1,3],[0,1],[1,0],[2,4]], k = 3
//    输出：3
//    解释：
//    根为节点 0 ，正确的猜测为 [1,3], [0,1], [2,4]
//    根为节点 1 ，正确的猜测为 [1,3], [1,0], [2,4]
//    根为节点 2 ，正确的猜测为 [1,3], [1,0], [2,4]
//    根为节点 3 ，正确的猜测为 [1,0], [2,4]
//    根为节点 4 ，正确的猜测为 [1,3], [1,0]
//    节点 0 ，1 或 2 为根时，可以得到 3 个正确的猜测。

    public static void main(String[] args) {
        int[][] edges = {{0, 1}, {1, 2}, {1, 3}, {4, 2}};
        int[][] guesses = {{1, 3}, {0, 1}, {1, 0}, {2, 4}};
        int k = 3;
        System.out.println(new LC_2581().rootCount(edges, guesses, k));
    }
}
