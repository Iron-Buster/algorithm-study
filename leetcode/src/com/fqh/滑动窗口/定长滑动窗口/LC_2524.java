package com.fqh.滑动窗口.定长滑动窗口;

import java.util.HashMap;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/19 18:34
 **/
public class LC_2524 {
//    2524. 子数组的最大频率分数
//            困难
//    相关标签
//            相关企业
//    提示
//    给定一个整数数组 nums 和一个 正 整数 k 。
//
//    数组的 频率得分 是数组中 不同 值的 幂次 之和，并将和对 109 + 7 取模。
//
//    例如，数组 [5,4,5,7,4,4] 的频率得分为 (43 + 52 + 71) modulo (109 + 7) = 96 。
//
//    返回 nums 中长度为 k 的 子数组 的 最大 频率得分。你需要返回取模后的最大值，而不是实际值。
//
//    子数组 是一个数组的连续部分。
//
//
//
//    示例 1 ：
//
//    输入：nums = [1,1,1,2,1,2], k = 3
//    输出：5
//    解释：子数组 [2,1,2] 的频率分数等于 5。可以证明这是我们可以获得的最大频率分数。
static final int MOD = 1000000007;
    // 滑动窗口 + 取模快速幂
    public int maxFrequencyScore(int[] nums, int k) {
        var map = new HashMap<Integer, Integer>();
        int j = 0;
        long ans = 0, s = 0;
        for (int i = 0; i < nums.length; i++) {
            int cnt = map.getOrDefault(nums[i], 0);
            if (cnt != 0) {
                s -= ksm(nums[i], cnt); // 减去原来的cnt次方
            }
            map.merge(nums[i], 1, Integer::sum);
            s += ksm(nums[i], cnt + 1);  // 加上新的cnt+1次方
            if (i - j + 1 > k) {
                cnt = map.get(nums[j]);
                s -= ksm(nums[j], cnt);        // 减去原来的cnt次方
                map.merge(nums[j], -1, Integer::sum);
                if (cnt - 1 != 0) {
                    s += ksm(nums[j], cnt - 1); // 加上新的cnt-1次方
                }
                if (map.get(nums[j]) == 0) {
                    map.remove(nums[j]);
                }
                j++;
            }
            if (i - j + 1 == k) {
                ans = Math.max(ans, s % MOD);
            }
        }
        return (int) ans;
    }


    // 快速幂
    static long ksm(long x, long n) {
        long res = 1 % MOD;
        while (n > 0) {
            if (n % 2 > 0) {
                res = res * x % MOD;
            }
            x = x * x % MOD;
            n /= 2;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] a = {33,34,39,11,13,33,25,40,49};
        int k = 1;
        System.out.println(new LC_2524().maxFrequencyScore(a, k));
    }
}
