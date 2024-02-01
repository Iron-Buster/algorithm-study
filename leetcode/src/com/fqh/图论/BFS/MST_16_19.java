package com.fqh.图论.BFS;

import java.util.*;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/1 15:15
 **/
public class MST_16_19 {

//    面试题 16.19. 水域大小
//            中等
//    相关标签
//            相关企业
//    提示
//    你有一个用于表示一片土地的整数矩阵land，该矩阵中每个点的值代表对应地点的海拔高度。若值为0则表示水域。
//    由垂直、水平或对角连接的水域为池塘。池塘的大小是指相连接的水域的个数。
//    编写一个方法来计算矩阵中所有池塘的大小，返回值需要从小到大排序。
//
//    示例：
//
//    输入：
//            [
//            [0,2,1,0],
//            [0,1,0,1],
//            [1,1,0,1],
//            [0,1,0,1]
//            ]
//    输出： [1,2,4]
    static final int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1},{-1,-1},{-1,1},{1,1},{1,-1}};
    int res = 0;

    public void bfs(int i, int j, int[][] g) {
        var q = new ArrayDeque<int[]>();
        q.offer(new int[]{i, j});
        res = 1;
        while (!q.isEmpty()) {
            var p = q.poll();
            int x = p[0], y = p[1];
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx < 0 || nx >= g.length || ny < 0 || ny >= g[0].length || g[nx][ny] != 0) {
                    continue;
                }
                res++;
                q.offer(new int[]{nx, ny});
                g[nx][ny] = 1;
            }
        }
    }

    public int[] pondSizes(int[][] land) {
        int m = land.length;
        int n = land[0].length;
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 0) {
                    land[i][j] = 1;
                    bfs(i, j, land);
                    ans.add(res);
                    res = 0;
                }
            }
        }
        Collections.sort(ans);
        return ans.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[][] a = {
        {0,2,1,0},
        {0,1,0,1},
        {1,1,0,1},
        {0,1,0,1}
    };
        System.out.println(Arrays.toString(new MST_16_19().pondSizes(a)));
    }
}
