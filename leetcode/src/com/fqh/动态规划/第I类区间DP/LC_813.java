package com.fqh.动态规划.第I类区间DP;

import java.util.Arrays;

/**
 * @Author: vq
 * @Date: 2023/12/21 22:02
 * @Version V1.0
 */
public class LC_813 {

    int[] a;
    public double largestSumOfAverages(int[] nums, int k) {
        int N = nums.length;
        int K = k;
        a = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            a[i] = nums[i - 1];
        }
        double[][] f = new double[N + 1][K + 1];
        for (int i = 1; i <= N; i++) {  // 初始化k=1的时候 f[i][k]的值
            f[i][1] = calc(1, i);
        }
        for (int i = 1; i <= N; i++) {
            for (k = 2; k <= Math.min(i, K); k++) {
                for (int j = i; j >= k; j--) {
                    f[i][k] = Math.max(f[i][k], f[j - 1][k - 1] + calc(j, i));
                }
            }
        }
        return f[N][K];
    }

    // 计算a[j:i]的平均值 这里可以预处理出前缀和，然后O(1)的时间计算出区间的平均值
    double calc(int j, int i) {
        int cnt = i - j + 1;
        double sum = 0;
        for (; j <= i; j++) sum += a[j];
        return sum / cnt;
    }



//    813. 最大平均值和的分组
//            已解答
//    第 79 场周赛
//            Q3
//1937
//    相关标签
//            相关企业
//    给定数组 nums 和一个整数 k 。我们将给定的数组 nums 分成 最多 k 个非空子数组，且数组内部是连续的 。 分数 由每个子数组内的平均值的总和构成。
//
//    注意我们必须使用 nums 数组中的每一个数进行分组，并且分数不一定需要是整数。
//
//    返回我们所能得到的最大 分数 是多少。答案误差在 10-6 内被视为是正确的。

    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7};
        int k = 4;
        System.out.println(new LC_813().largestSumOfAverages(a, k));
    }
}
