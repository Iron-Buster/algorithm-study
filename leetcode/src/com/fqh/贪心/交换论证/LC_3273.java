package com.fqh.贪心.交换论证;

import java.util.Arrays;

public class LC_3273 {

    // https://leetcode.cn/problems/minimum-amount-of-damage-dealt-to-bob/description/

    public long minDamage(int power, int[] damage, int[] health) {
        int n = damage.length;
        int[][] a = new int[n][2];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            a[i][0] = damage[i];
            a[i][1] = (health[i] + power - 1) / power;
            sum += damage[i];
        }
        // 考虑n=2, A和B
        // 假设先打A要优于先打B x[1]是击败A现需要的次数，x[0]是A的伤害。y同理
        // 那么满足
        // x[1] * x[0] + (x[1] * y[0]) + (y[1] * y[0]) < y[1] * y[0] + (y[1] * x[0]) + (x[1] * x[0])
        // x[1] * x[0] + x[1] * y[0] + y[1] * y[0] < y[1] * y[0] + y[1] * x[0] + x[1] * x[0]
        // x[1] * x[0] + x[1] * y[0] + y[1] * y[0] - y[1] * y[0] - y[1] * x[0] - x[1] * x[0] < 0
        // x[1] * x[0] 和 y[1] * y[0] 可以抵消掉
        // 化简得到 x[1] * y[0] < y[1] * x[0]
        Arrays.sort(a, (x, y) -> x[1] * y[0] - y[1] * x[0]);
        long ans = 0;
        for (int[] p : a) {
            ans += sum * p[1];
            sum -= p[0];
        }
        return ans;
    }
}
