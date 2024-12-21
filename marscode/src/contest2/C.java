package contest2;

import java.util.ArrayDeque;

public class C {

    static int[][] dirs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    static boolean check(int[][] h, int mid) {
        int m = h.length;
        int n = h[0].length;
        var q = new ArrayDeque<int[]>();
        q.offer(new int[]{0, 0});
        var vis = new boolean[m][n];
        vis[0][0] = true;
        while (!q.isEmpty()) {
            int[] p = q.poll();
            int x = p[0], y = p[1];
            if (x == m - 1 && y == n - 1) return true;
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                if (nx < 0 || nx >= m || ny < 0 || ny >= n) continue;
                if (!vis[nx][ny] && Math.abs(h[x][y] - h[nx][ny]) <= mid) {
                   q.offer(new int[]{nx, ny});
                   vis[nx][ny] = true;
                }
            }
        }
        return false;
    }

    public static int solution(int[][] heights) {
        // PLEASE DO NOT MODIFY THE FUNCTION SIGNATURE
        // write code here

        int l = 1;
        int r = 101;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (check(heights, mid)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{new int[]{5, 1, 2}, new int[]{4, 6, 2}, new int[]{1, 3, 8}}) == 5);
        System.out.println(solution(new int[][]{new int[]{3, 9, 8, 7, 4, 2}, new int[]{5, 6, 5, 3, 2, 1}, new int[]{7, 4, 6, 7, 5, 9}}) == 4);
        System.out.println(solution(new int[][]{new int[]{2, 5}, new int[]{1, 4}}) == 3);
    }

}
