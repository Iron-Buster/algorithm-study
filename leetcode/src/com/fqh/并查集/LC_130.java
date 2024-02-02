package com.fqh.并查集;

import java.util.*;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/2 14:54
 **/
public class LC_130 {

    // https://leetcode.cn/problems/surrounded-regions/description/
    static final int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        var q = new ArrayDeque<int[]>();
        boolean[][] ok = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                ok[i][0] = true;
                q.offer(new int[]{i, 0});
            }
            if (board[i][n-1] == 'O') {
                ok[i][n-1] = true;
                q.offer(new int[]{i, n-1});
            }
        }
        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                ok[0][j] = true;
                q.offer(new int[]{0, j});
            }
            if (board[m-1][j] == 'O') {
                ok[m-1][j] = true;
                q.offer(new int[]{m-1, j});
            }
        }
        while (!q.isEmpty()) {
            var p = q.poll();
            int x = p[0], y = p[1];
            for (int[] dir : dirs) {
                int nx = x + dir[0], ny = y + dir[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && board[nx][ny] == 'O' && !ok[nx][ny]) {
                    ok[nx][ny] = true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'O' && !ok[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
    public static void main(String[] args) {
        char[][] board = {
                {'X', 'O', 'X'},
                {'X', 'O', 'X'},
                {'X', 'O', 'X'}
        };
        new LC_130().solve(board);
    }
}
