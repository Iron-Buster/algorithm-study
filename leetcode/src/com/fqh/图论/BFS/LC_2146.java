package com.fqh.图论.BFS;

import com.fqh.contests.bw85.D;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @Author: vq
 * @Date: 2023/12/18 14:40
 * @Version V1.0
 */
public class LC_2146 {

    //    2146. 价格范围内最高排名的 K 样物品
//    第 70 场双周赛
//            Q3
//1837
//    相关标签
//            相关企业
//    提示
//    给你一个下标从 0 开始的二维整数数组 grid ，它的大小为 m x n ，表示一个商店中物品的分布图。数组中的整数含义为：
//
//            0 表示无法穿越的一堵墙。
//            1 表示可以自由通过的一个空格子。
//    所有其他正整数表示该格子内的一样物品的价格。你可以自由经过这些格子。
//    从一个格子走到上下左右相邻格子花费 1 步。
//
//    同时给你一个整数数组 pricing 和 start ，其中 pricing = [low, high] 且 start = [row, col] ，表示开始位置为 (row, col) ，
//    同你时你只对物品价格在 闭区间 [low, high] 之内的物品感兴趣。同时给你一个整数 k 。
//
//    你想知道给定范围 内 且 排名最高 的 k 件物品的 位置 。排名按照优先级从高到低的以下规则制定：
//
//    距离：定义为从 start 到一件物品的最短路径需要的步数（较近 距离的排名更高）。
//    价格：较低 价格的物品有更高优先级，但只考虑在给定范围之内的价格。
//    行坐标：较小 行坐标的有更高优先级。
//    列坐标：较小 列坐标的有更高优先级。
//    请你返回给定价格内排名最高的 k 件物品的坐标，将它们按照排名排序后返回。如果给么定价格内少于 k 件物品，那请将它们的坐标 全部 返回。

    static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    boolean[][] vis;

    class Node {
        int x, y, price, step;
        public Node(int x, int y, int price, int step) {
            this.x = x;
            this.y = y;
            this.price = price;
            this.step = step;
        }
    }
    public List<List<Integer>> highestRankedKItems(int[][] grid, int[] pricing, int[] start, int k) {
        int m = grid.length;
        int n = grid[0].length;
        vis = new boolean[m][n];
        var pq = new PriorityQueue<Node>((a, b) -> {
            if (a.step != b.step) {
                return a.step - b.step;
            }
            if (a.price != b.price) {
                return a.price - b.price;
            }
            if (a.x != b.x) {
                return a.x - b.x;
            }
            return a.y - b.y;
        });
        var q = new ArrayDeque<int[]>();
        q.offer(new int[]{start[0], start[1], 0});
        int startPrice = grid[start[0]][start[1]];
        if (startPrice >= pricing[0] && startPrice <= pricing[1]) {
            pq.offer(new Node(start[0], start[1], startPrice,  0));
            vis[start[0]][start[1]] = true;
        }
        while (q.size() > 0) {
            int[] p = q.poll();
            int x = p[0], y = p[1], step = p[2];
            for (int[] d : DIRS) {
                int nx = x + d[0];
                int ny = y + d[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] == 0) continue;
                if (!vis[nx][ny]) {
                    int nextPrice = grid[nx][ny];
                    if (nextPrice >= pricing[0] && nextPrice <= pricing[1]) {
                        pq.offer(new Node(nx, ny, nextPrice, step + 1));
                    }
                    q.offer(new int[]{nx, ny, step + 1});
                    vis[nx][ny] = true;
                }
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; !pq.isEmpty() && i < k; i++) {
            Node node = pq.poll();
            ans.add(List.of(node.x, node.y));
        }
        return ans;
    }




}
