package com.fqh.动态规划.树形DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/3/7 12:14
 **/
public class LC_2925 {

//    2925. 在树上执行操作以后得到的最大分数
//    第 370 场周赛
//            Q3
//    1940
//    相关标签
//            相关企业
//    提示
//    有一棵 n 个节点的无向树，节点编号为 0 到 n - 1 ，根节点编号为 0 。给你一个长度为 n - 1 的二维整数数组 edges 表示这棵树，其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 有一条边。
//
//    同时给你一个长度为 n 下标从 0 开始的整数数组 values ，其中 values[i] 表示第 i 个节点的值。
//
//    一开始你的分数为 0 ，每次操作中，你将执行：
//
//    选择节点 i 。
//    将 values[i] 加入你的分数。
//    将 values[i] 变为 0 。
//    如果从根节点出发，到任意叶子节点经过的路径上的节点值之和都不等于 0 ，那么我们称这棵树是 健康的 。
//
//    你可以对这棵树执行任意次操作，但要求执行完所有操作以后树是 健康的 ，请你返回你可以获得的 最大分数 。

    List<Integer>[] g;
    int[] val;
    public long maximumScoreAfterOperations(int[][] edges, int[] values) {
        int n = edges.length + 1;
        g = new List[n];
        val = values;
        Arrays.setAll(g, v -> new ArrayList<>());
        for (int[] edge : edges) {
            int x = edge[0], y = edge[1];
            g[x].add(y);
            g[y].add(x);
        }
        return Arrays.stream(values).sum() - dfs(0, -1);
    }

    // 保证执行后是健康的，那么每条边选values最小的那个节点不修改就可以了。
    long dfs(int x, int fa) {
        if (g[x].size() == 0) { // 叶子节点
            return val[x];
        }
        long loss = 0;
        for (int y : g[x]) {
            if (y == fa) continue;
            loss += dfs(y, x);
        }
        return Math.min(val[x], loss);
    }
}
