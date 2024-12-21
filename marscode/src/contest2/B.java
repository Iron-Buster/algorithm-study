package contest2;

import java.util.Arrays;

public class B {

    static int[][] dp;
    public static int solution(int[][] giftPackages, int k) {
        // PLEASE DO NOT MODIFY THE FUNCTION SIGNATURE
        // write code here
        int n = giftPackages.length;
        dp = new int[n][k+1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dfs(0, 0, giftPackages, k);
    }

    static int dfs(int i, int v, int[][] g, int k) {
        if (i >= g.length) return v <= k ? 0: Integer.MIN_VALUE;
        if (v > k) return Integer.MIN_VALUE;
        if (dp[i][v] != -1) return dp[i][v];
        int a = dfs(i + 1, v, g, k);
        int b = 0;
        for (int j = 1; j <= g[i][0]; j++) {
            b = Math.max(b, dfs(i + 1, v + j, g, k) + j * g[i][1]);
        }
        return dp[i][v] = Math.max(a, b);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{new int[]{2, 5}, new int[]{1, 3}, new int[]{3, 2}}, 3) == 13);
        System.out.println(solution(new int[][]{new int[]{3, 9}, new int[]{2, 4}, new int[]{4, 8}}, 6) == 51);
        System.out.println(solution(new int[][]{new int[]{3, 1}, new int[]{2, 6}, new int[]{4, 5}}, 5) == 27);
        System.out.println(solution(new int[][]{new int[]{1, 7}, new int[]{3, 8}, new int[]{2, 10}}, 4) == 36);
    }


}
