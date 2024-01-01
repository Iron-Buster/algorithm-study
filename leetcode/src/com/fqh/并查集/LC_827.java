package com.fqh.并查集;

import java.util.HashSet;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/1 16:36
 **/
public class LC_827 {

    static final int[][] DIRS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    // 并查集 + 枚举
    public int largestIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        var uf = new UnionFind(n*m);
        // 将g[i][j] == 1周围的岛屿全部合并
        int cnt0 = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    cnt0++;
                    continue;
                }
                int cur = i * n + j;
                for (int[] dir : DIRS) {
                    int nx = i + dir[0];
                    int ny = j + dir[1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] == 0) continue;
                    int next = nx * n + ny;
                    uf.merge(cur, next);
                }
            }
        }
        if (cnt0 == 0) return m * n; // 不存在0
        // 枚举将哪个0变为岛屿后，连通分量的数量最多
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    continue;
                }
                var set = new HashSet<Integer>();
                int s = 0;
                for (int[] dir : DIRS) {
                    int nx = i + dir[0];
                    int ny = j + dir[1];
                    if (nx < 0 || nx >= m || ny < 0 || ny >= n || grid[nx][ny] == 0) continue;
                    int next = nx * n + ny;
                    int fa = uf.find(next);
                    if (!set.contains(fa)) {
                        s += uf.size[fa];
                        set.add(fa);
                    }
                }
                ans = Math.max(ans, s + 1);
            }
        }
        return ans;
    }


    class UnionFind {
        int[] size;
        int[] fa;

        public UnionFind(int n) {
            fa = new int[n+1];
            size = new int[n+1];
            for (int i = 0; i <= n; i++) {
                fa[i] = i;
                size[i] = 1;
            }
        }

        public int find(int x) {
            while (x != fa[x]) {
                fa[x] = fa[fa[x]];
                x = fa[x];
            }
            return x;
        }

        public void merge(int a, int b) {
            int aRoot = find(a);
            int bRoot = find(b);
            if (aRoot == bRoot) return;
            if (size[aRoot] < size[bRoot]) {
                fa[aRoot] = bRoot;
                size[bRoot] += size[aRoot];
            } else {
                fa[bRoot] = aRoot;
                size[aRoot] += size[bRoot];
            }
        }
    }

//    827. 最大人工岛
//            已解答
//    第 82 场周赛
//            Q4
//1934
//    相关标签
//            相关企业
//    给你一个大小为 n x n 二进制矩阵 grid 。最多 只能将一格 0 变成 1 。
//
//    返回执行此操作后，grid 中最大的岛屿面积是多少？
//
//    岛屿 由一组上、下、左、右四个方向相连的 1 形成。
//
//
//
//    示例 1:
//
//    输入: grid = [[1, 0], [0, 1]]
//    输出: 3
//    解释: 将一格0变成1，最终连通两个小岛得到面积为 3 的岛屿。
}
