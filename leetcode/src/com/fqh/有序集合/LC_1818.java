package com.fqh.有序集合;

import java.util.Map;
import java.util.TreeSet;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/16 23:47
 **/
public class LC_1818 {

    static final int MOD = 1000000007;
    // 1.计算出没替换之前的绝对差值和s
    // 2.将a数组丢到有序集合中
    // 3.枚举替换a数字的哪一个数字让 ans最小
    //  3-1: 对于a[i]，我们通过a数组的有序集合找离b[i]最近的两个数字floor，ceiling
    //  3-2: 将a[i]替换为floor，ceiling后，跟ans取一个最小。
    public int minAbsoluteSumDiff(int[] a, int[] b) {
        int n = a.length;
        var tset = new TreeSet<Integer>();
        long s = 0;
        for (int i = 0; i < n; i++) {
            s += Math.abs(a[i] - b[i]);
            tset.add(a[i]);
        }
        long ans = Long.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int v = Math.abs(a[i] - b[i]);
            Integer floor = tset.floor(b[i]);
            Integer ceiling = tset.ceiling(b[i]);
            if (floor != null) {
                ans = Math.min(ans, s - v + Math.abs(floor - b[i]));
            }
            if (ceiling != null) {
                ans = Math.min(ans, s - v + Math.abs(ceiling - b[i]));
            }
        }
        ans %= MOD;
        return (int) ans;
    }

//    1818. 绝对差值和
//            已解答
//    第 235 场周赛
//            Q3
//1934
//    相关标签
//            相关企业
//    提示
//    给你两个正整数数组 nums1 和 nums2 ，数组的长度都是 n 。
//
//    数组 nums1 和 nums2 的 绝对差值和 定义为所有 |nums1[i] - nums2[i]|（0 <= i < n）的 总和（下标从 0 开始）。
//
//    你可以选用 nums1 中的 任意一个 元素来替换 nums1 中的 至多 一个元素，以 最小化 绝对差值和。
//
//    在替换数组 nums1 中最多一个元素 之后 ，返回最小绝对差值和。因为答案可能很大，所以需要对 109 + 7 取余 后返回。
//
//            |x| 定义为：
//
//    如果 x >= 0 ，值为 x ，或者
//    如果 x <= 0 ，值为 -x
//
//
//    示例 1：
//
//    输入：nums1 = [1,7,5], nums2 = [2,3,5]
//    输出：3
//    解释：有两种可能的最优方案：
//            - 将第二个元素替换为第一个元素：[1,7,5] => [1,1,5] ，或者
//- 将第二个元素替换为第三个元素：[1,7,5] => [1,5,5]
//    两种方案的绝对差值和都是 |1-2| + (|1-3| 或者 |5-3|) + |5-5| = 3
}
