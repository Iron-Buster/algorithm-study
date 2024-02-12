package com.fqh.位运算.XOR;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/2/12 17:02
 **/
public class LC_2425 {


//    2425. 所有数对的异或和
//            已解答
//    第 88 场双周赛
//            Q3
//    1622
//    相关标签
//            相关企业
//    提示
//    给你两个下标从 0 开始的数组 nums1 和 nums2 ，两个数组都只包含非负整数。请你求出另外一个数组 nums3 ，包含 nums1 和 nums2 中 所有数对 的异或和（nums1 中每个整数都跟 nums2 中每个整数 恰好 匹配一次）。
//
//    请你返回 nums3 中所有整数的 异或和 。
//
//
//
//    示例 1：
//
//    输入：nums1 = [2,1,3], nums2 = [10,2,5,0]
//    输出：13
//    解释：
//    一个可能的 nums3 数组是 [8,0,7,2,11,3,4,1,9,1,6,3] 。
//    所有这些数字的异或和是 13 ，所以我们返回 13 。


    // [a,b]
    // [c,d,e]
    // (a^c) ^ (a^d) ^ (a^e) ^ (b^c) ^ (b^d) ^ (b^e)
    // 化简得：a^b
    public int xorAllNums(int[] a, int[] b) {
        int len1 = a.length, len2 = b.length;
        int ans = 0;
        if (len1 % 2 == 1) {
            for (int x : b) ans ^= x;
        }
        if (len2 % 2 == 1) {
            for (int x : a) ans ^= x;
        }
        return ans;
    }
}
