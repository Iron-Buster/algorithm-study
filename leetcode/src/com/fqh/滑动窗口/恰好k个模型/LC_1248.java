package com.fqh.滑动窗口.恰好k个模型;

/**
 * @Author: vq
 * @Date: 2023/12/21 15:30
 * @Version V1.0
 */
public class LC_1248 {


    public int numberOfSubarrays(int[] nums, int k) {
        return f(nums, k) - f(nums, k - 1);
    }

    int f(int[] a, int k) {
        int ans = 0, cnt = 0, j = 0;
        for (int i = 0; i < a.length; i++) {
            cnt += (a[i] & 1);
            while (cnt > k) {
                cnt -= (a[j] & 1);
                j++;
            }
            ans += i - j + 1;
        }
        return ans;
    }

//    1248. 统计「优美子数组」
//    已解答
//    第 161 场周赛
//            Q2
//1624
//    相关标签
//            相关企业
//    提示
//    给你一个整数数组 nums 和一个整数 k。如果某个连续子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
//
//    请返回这个数组中 「优美子数组」 的数目
}
