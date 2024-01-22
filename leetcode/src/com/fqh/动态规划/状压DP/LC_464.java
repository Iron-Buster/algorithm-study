package com.fqh.动态规划.状压DP;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/22 18:17
 **/
public class LC_464 {

//    464. 我能赢吗
//            中等
//    相关标签
//            相关企业
//    在 "100 game" 这个游戏中，两名玩家轮流选择从 1 到 10 的任意整数，累计整数和，先使得累计整数和 达到或超过  100 的玩家，即为胜者。
//
//    如果我们将游戏规则改为 “玩家 不能 重复使用整数” 呢？
//
//    例如，两个玩家可以轮流从公共整数池中抽取从 1 到 15 的整数（不放回），直到累计整数和 >= 100。
//
//    给定两个整数 maxChoosableInteger （整数池中可选择的最大数）和 desiredTotal（累计和），若先出手的玩家能稳赢则返回 true ，否则返回 false 。
//    假设两位玩家游戏时都表现 最佳 。

    public boolean canIWin(int n, int total) {
        if (n * (n + 1) / 2 < total) return false; // 先选必败，赢不了
        int[] sum = new int[1<<n];
        boolean[] f = new boolean[1<<n];
        for (int s = 0; s < 1<<n; s++) {
            for (int j = 0; j < n; j++) {
                if ((s >> j & 1) == 1) {
                    sum[s] += (j+1);
                }
            }
        }
        // 博弈：先手数字大的，选的数多的更容易获胜
        for (int s = (1<<n)-1; s >= 0; s--) {
            for (int j = n-1; j >= 0; j--) {
                if ((s >> j & 1) == 0) {
                    if (sum[s|(1<<j)] >= total || !f[s|(1<<j)]) {
                        f[s] = true;
                        break;
                    }
                }
            }
        }
        return f[0];
    }

    public static void main(String[] args) {

    }
}
