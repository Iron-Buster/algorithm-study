package com.fqh.动态规划.第I类区间DP;

/**
 * @Author: vq
 * @Date: 2023/12/21 22:25
 * @Version V1.0
 */
public class LC_410 {

    int[] a;
    int[] sum;
    // 也可以使用二分答案做
    public int splitArray(int[] nums, int k) {
        int N = nums.length;
        int K = k;
        a = new int[N + 1];
        sum = new int[N + 2];
        for (int i = 1; i <= N; i++) {
            a[i] = nums[i - 1];
            sum[i + 1] = sum[i] + a[i]; // 使用前缀和可以在O(1)的时间求出sum[i:j]
        }
        int[][] f = new int[N + 1][K + 1];
        for (int i = 1; i <= N; i++) {
//            f[i][1] = calc(1, i);
            f[i][1] = sum[i + 1];
        }
        for (int i = 1; i <= N; i++) {
            for (k = 2; k <= Math.min(i, K); k++) {
                f[i][k] = 0x3f3f3f;
                for (int j = i; j >= k; j--) {
//                    f[i][k] = Math.min(f[i][k], Math.max(f[j - 1][k - 1], calc(j, i)));
                    f[i][k] = Math.min(f[i][k], Math.max(f[j - 1][k - 1], sum[i + 1] - sum[j]));
                }
            }
        }
        return f[N][K];
    }

    int calc(int j, int i) {
        int sum = 0;
        for (; j <= i; j++) sum += a[j];
        return sum;
    }



//    410. 分割数组的最大值
//            已解答
//    困难
//            相关标签
//    相关企业
//    给定一个非负整数数组 nums 和一个整数 k ，你需要将这个数组分成 k 个非空的连续子数组。
//
//    设计一个算法使得这 k 个子数组各自和的最大值最小。

}
