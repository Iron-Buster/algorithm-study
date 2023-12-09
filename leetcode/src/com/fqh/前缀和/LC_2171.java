package com.fqh.前缀和;

import java.util.Arrays;

/**
 * @Author: vq
 * @Date: 2023/12/9 15:31
 * @Version V1.0
 */
public class LC_2171 {
//    2171. 拿出最少数目的魔法豆
//    第 280 场周赛
//            Q3
//    1748
//    相关标签
//            相关企业
//    提示
//    给定一个 正整数 数组 beans ，其中每个整数表示一个袋子里装的魔法豆的数目。
//
//    请你从每个袋子中 拿出 一些豆子（也可以 不拿出），使得剩下的 非空 袋子中（即 至少还有一颗 魔法豆的袋子）魔法豆的数目 相等。一旦把魔法豆从袋子中取出，你不能再将它放到任何袋子中。
//
//    请返回你需要拿出魔法豆的 最少数目。

    /**
     1 4 5 6
     前缀和  0 1 5 10 16
     如果beans[i]保留了，那么小于beans[i]的数字都需要变为0，大于beans[i]的数字都要变为beans[i]
     排序后，枚举beans[i]作为最后保留的数字，
     cost[i] = preSum[i] + (preSum[n] - preSum[i] - (n - i) * beans[i])
     取min(cost)
     */
    public long minimumRemoval(int[] beans) {
        int n = beans.length;
        Arrays.sort(beans);
        long[] preSum = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            preSum[i + 1] = preSum[i] + beans[i];
        }
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
            long left = preSum[i];
            long right = (preSum[n] - preSum[i]) - (long) (n - i) * beans[i];
            ans = Math.min(ans, left + right);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] beans = {4, 1, 6, 5};
        System.out.println(new LC_2171().minimumRemoval(beans));
    }
}
