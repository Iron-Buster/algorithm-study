package com.fqh.并查集;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/19 11:18
 **/
public class LC_305 {
//    305. 岛屿数量 II
//    困难
//            相关标签
//    相关企业
//    给你一个大小为 m x n 的二进制网格 grid 。网格表示一个地图，其中，0 表示水，1 表示陆地。最初，grid 中的所有单元格都是水单元格（即，所有单元格都是 0）。
//
//    可以通过执行 addLand 操作，将某个位置的水转换成陆地。给你一个数组 positions ，其中 positions[i] = [ri, ci] 是要执行第 i 次操作的位置 (ri, ci) 。
//
//    返回一个整数数组 answer ，其中 answer[i] 是将单元格 (ri, ci) 转换为陆地后，地图中岛屿的数量。
//
//    岛屿 的定义是被「水」包围的「陆地」，通过水平方向或者垂直方向上相邻的陆地连接而成。你可以假设地图网格的四边均被无边无际的「水」所包围。

    // TODO
    public boolean check(int x1, int y1, int x2, int y2) {
        return (x1-1==x2 && y1 == y2) || (x1+1==x2 && y1==y2) || (x1==x2 && y1-1==y2) || (x1==x2 && y1+1==y2);
    }
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        var uf = new UnionFind(m * n);
        var ans = new ArrayList<Integer>();
        for (int i = 0; i < positions.length; i++) {
            int x1 = positions[i][0], y1 = positions[i][1];
            for (int j = i + 1; j < positions.length; j++) {
                int x2 = positions[i][0], y2 = positions[i][1];
                if (check(x1, y1, x2, y2)) {
                    int p1 = x1 * n + y1;
                    int p2 = x2 * n + y2;
                    uf.merge(p1, p2);
                }
            }
        }
        return ans;
    }


    class UnionFind {
        int[] parent;
        int[] size;
        public UnionFind(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            while (x != parent[x]) {
                parent[x] = parent[parent[x]];
                x = parent[x];
            }
            return x;
        }

        public void merge(int a, int b) {
            int p_a = find(a);
            int p_b = find(b);
            if (p_a == p_b) return;
            if (size[p_a] < size[p_b]) {
                parent[p_a] = p_b;
                size[p_b] += size[p_a];
            } else {
                parent[p_b] = p_a;
                size[p_a] += size[p_b];
            }
        }
    }

    public static void main(String[] args) {

    }

}
