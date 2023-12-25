package com.fqh.图论.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: vq
 * @Date: 2023/12/9 21:06
 * @Version V1.0
 */
public class LC_1466 {

//    1466. 重新规划路线
//    第 191 场周赛
//            Q3
//    1634
//    相关标签
//            相关企业
//    提示
//    n 座城市，从 0 到 n-1 编号，其间共有 n-1 条路线。因此，要想在两座不同城市之间旅行只有唯一一条路线可供选择（路线网形成一颗树）。去年，交通运输部决定重新规划路线，以改变交通拥堵的状况。
//
//    路线用 connections 表示，其中 connections[i] = [a, b] 表示从城市 a 到 b 的一条有向路线。
//
//    今年，城市 0 将会举办一场大型比赛，很多游客都想前往城市 0 。
//
//    请你帮助重新规划路线方向，使每个城市都可以访问城市 0 。返回需要变更方向的最小路线数。
//
//    题目数据 保证 每个城市在重新规划路线方向后都能到达城市 0 。

    List<int[]>[] g;
    int ans = 0;

    public int minReorder(int n, int[][] connections) {
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (var conn : connections) {
            int x = conn[0];
            int y = conn[1];
            g[x].add(new int[]{y, 1});  // 正向
            g[y].add(new int[]{x, -1}); // 反向
        }
        dfs(0, -1, -1); // dfs从0开始将边全部反向需要的操作
        return ans;
    }

    void dfs(int x, int d, int fa) {
        for (int[] next : g[x]) {
            int y = next[0], dir = next[1];
            if (y == fa) continue;
            if (dir != d) {
                ans++;
            }
            dfs(y, d, x);
        }
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] connections = {{0, 1}, {1, 3}, {2, 3}, {4, 0}, {4, 5}};
        System.out.println(new LC_1466().minReorder(n, connections));
    }
}
