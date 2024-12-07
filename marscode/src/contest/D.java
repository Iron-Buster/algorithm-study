package contest;


import java.util.Arrays;

public class D {

    static int[][] dp;
    static int[] cc;
    static int[] ss;

    public static int solution(int[] stones, int[] c) {
        // write code here
        int n = c.length;
        int m = stones.length;
        cc = c;
        ss = stones;
        dp = new int[n+1][m+1];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }
        return dfs(0, 0);
    }

    static int dfs(int i, int j) {
        if (i >= cc.length) return 0;
        if (dp[i][j] != Integer.MIN_VALUE) return dp[i][j];
        int r = i - j; // 右边已经取的数量
        int k = ss.length - r - 1;
        int res1 = dfs(i + 1, j + 1) + cc[i] * ss[j];
        int res2 = dfs(i + 1, j) + cc[i] * ss[k];
        return dp[i][j] = Math.max(res1, res2);
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{-3, 4, 5}, new int[]{2, -1, 3}) == 25);
        System.out.println(solution(new int[]{6, -7, 1}, new int[]{4, -3}) == 45);
        System.out.println(solution(new int[]{3, 5, -2, 9}, new int[]{1, 3, -5}) == 40);
    }
}
