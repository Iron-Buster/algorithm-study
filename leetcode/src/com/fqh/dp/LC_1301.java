package com.fqh.dp;

import java.util.List;

/**
 * @Author: vq
 * @Date: 2023/11/6 17:00
 * @Version V1.0
 */
public class LC_1301 {

//    1301. 最大得分的路径数目
//            尝试过
//    第 16 场双周赛
//            Q4
//    1853
//    相关标签
//            相关企业
//    提示
//    给你一个正方形字符数组 board ，你从数组最右下方的字符 'S' 出发。
//
//    你的目标是到达数组最左上角的字符 'E' ，数组剩余的部分为数字字符 1, 2, ..., 9 或者障碍 'X'。在每一步移动中，你可以向上、向左或者左上方移动，可以移动的前提是到达的格子没有障碍。
//
//    一条路径的 「得分」 定义为：路径上所有数字的和。
//
//    请你返回一个列表，包含两个整数：第一个整数是 「得分」 的最大值，第二个整数是得到最大得分的方案数，请把结果对 10^9 + 7 取余。
//
//    如果没有任何路径可以到达终点，请返回 [0, 0] 。

    int m;
    int n;
    List<String> board;
    int[][] dirs = {{-1, 0}, {0, -1}, {-1, -1}};
    Integer[][][] f = new Integer[101][101][2];

    public int[] pathsWithMaxScore(List<String> board) {
        this.m = board.size();
        this.n = board.get(0).length();
        this.board = board;
        Integer[] res = dfs(m - 1, n - 1);
        return new int[]{res[0], res[1]};
    }

    // 记忆化搜索返回值 [最大的分数，最大分数的路径数]
    private Integer[] dfs(int i, int j) {
        if (i == 0 && j == 0) return new Integer[]{0, 1};
        if (f[i][j][0] != null) return f[i][j];
        Integer[] res = {0, 0};
        for (int[] dir : dirs) {
            int nx = i + dir[0];
            int ny = j + dir[1];
            if (nx >= 0 && ny >= 0 && board.get(nx).charAt(ny) != 'X') {
                Integer[] sub = dfs(nx, ny);
                if (sub[0] > res[0]) {
                    res[0] = sub[0];
                    res[1] = sub[1];
                } else if (sub[0].intValue() == res[0]) {
                    res[1] += sub[1];
                    res[1] %= 1000000007;
                }
            }
        }
        if (res[1] != 0) {
            var cur = board.get(i).charAt(j);
            res[0] += cur != 'S' ? cur - '0' : 0;
        }
        return f[i][j] = res;
    }
}
