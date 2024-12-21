package contest2;

public class D {

    public static int solution(int n, int k) {
        // PLEASE DO NOT MODIFY THE FUNCTION SIGNATURE
        // write code here
        final int MOD = 1000000007;
        long[][] dp = new long[n+1][k+1];
        dp[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i-1][j-1];
                dp[i][j] += dp[i-1][j] * (i-1);
                dp[i][j] %= MOD;
            }
        }
        return (int) dp[n][k];
    }

    public static void main(String[] args) {
        System.out.println(solution(4, 2) == 11);
        System.out.println(solution(6, 3) == 225);
        System.out.println(solution(7, 4) == 735);
        System.out.println(solution(9, 5) == 22449);
    }
}
