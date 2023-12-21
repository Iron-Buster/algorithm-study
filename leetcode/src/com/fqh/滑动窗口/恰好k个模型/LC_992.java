package com.fqh.滑动窗口.恰好k个模型;

/**
 * @Author: vq
 * @Date: 2023/12/21 15:38
 * @Version V1.0
 */
public class LC_992 {

    // 恰好k个模板咯
    // 恰好k个不同整数的子数组数目 = 最多k个不同整数的子数组数目 - 最多k-1个不同整数的子数组数目
    public int subarraysWithKDistinct(int[] nums, int k) {
        return f(nums, k) - f(nums, k - 1);
    }

    int f(int[] a, int k) {
        int[] map = new int[20001];
        int i = 0, j = 0, cnt = 0;
        int ans = 0;
        while (i < a.length) {
            if (map[a[i]] == 0) cnt++;
            map[a[i]]++;
            while (cnt > k) {
                map[a[j]]--;
                cnt -= map[a[j]] == 0 ? 1 : 0;
                j++;
            }
            ans += i - j + 1;
            i++;
        }
        return ans;
    }

//    992. K 个不同整数的子数组
//    已解答
//    第 123 场周赛
//            Q4
//2210
//    相关标签
//            相关企业
//    给定一个正整数数组 nums和一个整数 k，返回 nums 中 「好子数组」 的数目。
//
//    如果 nums 的某个子数组中不同整数的个数恰好为 k，则称 nums 的这个连续、不一定不同的子数组为 「好子数组 」。
//
//    例如，[1,2,3,1,2] 中有 3 个不同的整数：1，2，以及 3。
//    子数组 是数组的 连续 部分。
}
