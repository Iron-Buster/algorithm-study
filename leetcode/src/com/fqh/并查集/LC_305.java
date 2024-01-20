package com.fqh.并查集;

import com.fqh.contests.bw85.D;

import java.util.ArrayList;
import java.util.HashSet;
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
    static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        var uf = new UnionFind(m * n);
        var ans = new ArrayList<Integer>();
        var set = new HashSet<Integer>();
        for (int[] pos : positions) {
            int p = pos[0] * n + pos[1];
            uf.parent[p] = p;
            set.add(p);
        }
        var set2 = new HashSet<Integer>();
        set2.add(positions[0][0] * n + positions[0][1]);
        ans.add(1);
        for (int i = 1; i < positions.length; i++) {
            int x = positions[i][0], y = positions[i][1];
            int p1 = x * n + y;
            for (int[] dir : DIRS) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                int p2 = nx * n + ny;
                if (set.contains(p2)) {
                    set2.remove(p2); // 用p1来代替p2
                    uf.merge(p1, p2);
                }
            }
            int fa = uf.find(p1);
            set2.add(fa);
            ans.add(set2.size());
        }
        return ans;
    }


    class UnionFind {
        int[] parent;
        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; ++i) {
                parent[i] = i;
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
            int rootA = find(a);
            int rootB = find(b);
            if (rootA == rootB) return;
            parent[rootB] = rootA;
        }
    }

    public static void main(String[] args) {
        int m = 3, n = 3;
        int[][] positions = {{0,0},{0,1},{1,2},{2,1}};
        System.out.println(new LC_305().numIslands2(m, n, positions));
    }

}
