package com.fqh.哈希表;

import java.util.HashMap;

/**
 * @Author: vq
 * @Date: 2023/12/7 15:29
 * @Version V1.0
 */
public class LC_1814 {
//    1814. 统计一个数组中好对子的数目
//    第 49 场双周赛
//            Q3
//    1738
//    相关标签
//            相关企业
//    提示
//    给你一个数组 nums ，数组中只包含非负整数。定义 rev(x) 的值为将整数 x 各个数字位反转得到的结果。比方说 rev(123) = 321 ， rev(120) = 21 。我们称满足下面条件的下标对 (i, j) 是 好的 ：
//
//            0 <= i < j < nums.length
//    nums[i] + rev(nums[j]) == nums[j] + rev(nums[i])
//    请你返回好下标对的数目。由于结果可能会很大，请将结果对 109 + 7 取余 后返回。


//        转化一下等式
//        -> x + rev(y) == y + rev(x)
//        -> x - rev(x) == y - rev(y)
//         -> 等式两边当作哈希key
    static final int MOD = (int) (1e9 + 7);
    public int countNicePairs(int[] nums) {
        var mp = new HashMap<Integer, Integer>();
        int ans = 0;
        for (int x : nums) {
            int k = x - rev(x);
            ans += mp.getOrDefault(k, 0);
            ans %= MOD;
            mp.merge(k, 1, Integer::sum);
        }
        return ans;
    }

    int rev(int num) {
        int v = 0;
        while (num > 0) {
            v = v * 10 + num % 10;
            num /= 10;
        }
        return v;
    }

    public static void main(String[] args) {
        int[] nums = {42, 11, 1, 97};
        System.out.println(new LC_1814().countNicePairs(nums));
    }
}
