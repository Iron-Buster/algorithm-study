package com.fqh.并查集;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/19 17:40
 **/
public class LC_2852 {

//    2852. 所有单元格的远离程度之和
//            中等
//    相关标签
//            提示
//    给定一个下标从 0 开始的大小为 n * n 的矩阵 grid，其中每个单元格的值 grid[i][j] 要么是 正整数，要么是表示阻塞单元格的值 -1 。
//
//    你可以从一个非阻塞单元格移动到与其共享边的任何非阻塞单元格。
//
//    对于任何单元格 (i, j)，我们定义其 远离程度 R[i][j] 如下：
//
//    如果单元格 (i, j) 是 非阻塞 单元格，则 R[i][j] 是值 grid[x][y] 的总和，其中 没有 从 非阻塞 单元格 (x, y) 到单元格 (i, j) 的路径。
//    对于阻塞单元格，R[i][j] == 0。
//    返回所有单元格的 R[i][j] 之和。

//    输入：grid = [
//      [-1,1,-1],
//      [5,-1,4],
//      [-1,3,-1]
//      ]
//    输出：39
//    解释：在上面的图片中，有四个矩阵。左上角的矩阵是题目给定矩阵的初始值。
//    被阻塞的单元格是黑色的，其他单元格的值与输入相同。在右上方的网格中，可以看到所有单元格的值也就是 R[i][j] 的值。
//    答案是它们的和。即:0 + 12 + 0 + 8 + 0 + 9 + 0 + 10 + 0 = 39。
//    在上图左下角的矩阵，计算 R[0][1] (目标单元格为绿色)。我们应该将单元格 (0,1) 无法到达的单元格的值相加。这些单元格在这个矩阵中是黄色的。所以 R[0][1] = 5 + 4 + 3 = 12。
//    在上图右下角的矩阵，计算 R[1][2] (目标单元格为绿色)。我们应该把单元格 (1,2) 无法到达的单元格的值相加。这些单元格在这个矩阵中是黄色的。所以 R[1][2] = 1 + 5 + 3 = 9。

//            [
//            [-1,3,4],
//            [-1,-1,-1],
//            [3,-1,-1]
//            ]

    static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    // 并查集
    public long sumRemoteness(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        var uf = new UnionFind(m * n);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == -1) continue;
                uf.sum[i * n + j] = grid[i][j];
            }
        }
        long sum = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == -1) continue;
                sum += grid[i][j];
                int p1 = i * n + j;
                for (int[] dir : DIRS) {
                    int nx = i + dir[0];
                    int ny = j + dir[1];
                    if (nx >= 0 && nx < m && ny >= 0 && ny < n && grid[nx][ny] != -1) {
                        int p2 = nx * n + ny;
                        uf.merge(p1, p2);
                    }
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == -1) continue;
                int fa = uf.find(i * n + j);
                ans += sum - uf.sum[fa];
            }
        }
        return ans;
    }

    static class UnionFind {
        int[] fa;
        long[] sum;

        public UnionFind(int n) {
            fa = new int[n];
            sum = new long[n];
            for (int i = 0; i < n; i++) {
                fa[i] = i;
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
            if (sum[aRoot] < sum[bRoot]) {
                sum[bRoot] += sum[aRoot];
                fa[aRoot] = bRoot;
            } else {
                sum[aRoot] += sum[bRoot];
                fa[bRoot] = aRoot;
            }
        }
    }

    public static void main(String[] args) {
        int[][] g = {{-1, 3, 4}, {-1, -1, -1}, {3, -1, -1}};
        System.out.println(new LC_2852().sumRemoteness(g));
    }
}
