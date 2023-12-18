package com.fqh.滑动窗口.定长滑动窗口;

/**
 * @Author: vq
 * @Date: 2023/12/18 14:02
 * @Version V1.0
 */
public class LC_1343 {

//    1343. 大小为 K 且平均值大于等于阈值的子数组数目
//    第 19 场双周赛
//            Q2
//1317
//    相关标签
//            相关企业
//    提示
//    给你一个整数数组 arr 和两个整数 k 和 threshold 。
//
//    请你返回长度为 k 且平均值大于等于 threshold 的子数组数目。
//
//
//
//    示例 1：
//
//    输入：arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
//    输出：3
//    解释：子数组 [2,5,5],[5,5,5] 和 [5,5,8] 的平均值分别为 4，5 和 6 。其他长度为 3 的子数组的平均值都小于 4 （threshold 的值)。
//    示例 2：
//
//    输入：arr = [11,13,17,23,29,31,7,5,2,3], k = 3, threshold = 5
//    输出：6
//    解释：前 6 个长度为 3 的子数组平均值都大于 5 。注意平均值不是整数。
    public int numOfSubarrays(int[] a, int k, int threshold) {
        int n = a.length;
        int ans = 0, j = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
            if (i - j + 1 > k) {
                sum -= a[j++];
            }
            if (i - j + 1 == k) {
                int avg = sum / k;
                ans += avg >= threshold ? 1 : 0;
            }
        }
        return ans;
    }
}
