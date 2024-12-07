package contest;

public class A {


    static int[] dp = new int[26];

    static {
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= 25; i++) {
            dp[i] = dp[i-3] + dp[i-2] + dp[i-1];
        }
    }

    public static int solution(int n) {
        // write code here
        return dp[n];
    }
}
