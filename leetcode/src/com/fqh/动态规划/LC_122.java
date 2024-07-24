package com.fqh.动态规划;


//https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description/
public class LC_122 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][1] = -prices[0]; // 第1天买入
        for (int i = 1; i < n; i++) {
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
        }
        return dp[n-1][0];     // 最后一天卖出
    }

    public static void main(String[] args) {
        int res = new LC_122().maxProfit(new int[]{7,1,5,3,6,4});
        System.out.println(res);
    }
}
