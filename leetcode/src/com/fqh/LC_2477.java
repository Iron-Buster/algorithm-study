package com.fqh;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author: vq
 * @Date: 2023/12/5 10:33
 * @Version V1.0
 */
public class LC_2477 {

//    2477. 到达首都的最少油耗
//    第 320 场周赛
//            Q3
//    2012
//    相关标签
//            相关企业
//    提示
//    给你一棵 n 个节点的树（一个无向、连通、无环图），每个节点表示一个城市，编号从 0 到 n - 1 ，且恰好有 n - 1 条路。0 是首都。给你一个二维整数数组 roads ，其中 roads[i] = [ai, bi] ，表示城市 ai 和 bi 之间有一条 双向路 。
//
//    每个城市里有一个代表，他们都要去首都参加一个会议。
//
//    每座城市里有一辆车。给你一个整数 seats 表示每辆车里面座位的数目。
//
//    城市里的代表可以选择乘坐所在城市的车，或者乘坐其他城市的车。相邻城市之间一辆车的油耗是一升汽油。
//
//    请你返回到达首都最少需要多少升汽油。

    List<Integer>[] g;
    long ans = 0;
    public long minimumFuelCost(int[][] roads, int seats) {
        g = new List[roads.length + 1];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] r : roads) {
            g[r[0]].add(r[1]);
            g[r[1]].add(r[0]);
        }
        dfs(0, -1, seats);
        return ans;
    }

    long dfs(int x, int fa, int seats) {
        long size = 1;
        for (int y : g[x]) {
            if (y == fa) continue;
            size += dfs(y, x, seats); // 统计子树大小
        }
        if (x > 0) {    // x不是根节点
            ans += (size - 1) / seats + 1; // ceil(size/seats) 向上取整
        }
        return size;
    }
}
