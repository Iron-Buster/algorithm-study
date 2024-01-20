package com.fqh.数学.容斥原理;

import java.util.HashSet;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/7 14:46
 **/
public class LC_100150 {



    public int maximumSetSize(int[] nums1, int[] nums2) {
        var set1 = new HashSet<Integer>();
        var set2 = new HashSet<Integer>();
        for (int i = 0; i < nums1.length; i++) {
            set1.add(nums1[i]);
            set2.add(nums2[i]);
        }
        int common = 0;
        for (int x : set2) {
            if (set1.contains(x)) {
                common++;
            }
        }
        int m = nums1.length / 2; // 需要操作的次数
        int ans = 0;
        ans += Math.min(set1.size(), m);
        ans += Math.min(set2.size(), m);
        if (ans < nums1.length) {
            ans = Math.min(ans + common, nums1.length);
        }
        return ans;
    }

//    100150. 移除后集合的最多元素数
//            已解答
//    中等
//            相关企业
//    提示
//    给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，它们的长度都是偶数 n 。
//
//    你必须从 nums1 中移除 n / 2 个元素，同时从 nums2 中也移除 n / 2 个元素。移除之后，你将 nums1 和 nums2 中剩下的元素插入到集合 s 中。
//
//    返回集合 s可能的 最多 包含多少元素。
//
//
//
//    示例 1：
//
//    输入：nums1 = [1,2,1,2], nums2 = [1,1,1,1]
//    输出：2
//    解释：从 nums1 和 nums2 中移除两个 1 。移除后，数组变为 nums1 = [2,2] 和 nums2 = [1,1] 。因此，s = {1,2} 。
//    可以证明，在移除之后，集合 s 最多可以包含 2 个元素。
//    示例 2：
//
//    输入：nums1 = [1,2,3,4,5,6], nums2 = [2,3,2,3,2,3]
//    输出：5
//    解释：从 nums1 中移除 2、3 和 6 ，同时从 nums2 中移除两个 3 和一个 2 。移除后，数组变为 nums1 = [1,4,5] 和 nums2 = [2,3,2] 。因此，s = {1,2,3,4,5} 。
//    可以证明，在移除之后，集合 s 最多可以包含 5 个元素。
}
