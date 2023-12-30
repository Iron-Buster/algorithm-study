package com.fqh.树状数组;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2023/12/30 13:03
 **/
public class LC_2426 {

    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        // nums1[i] - nums1[j] <= nums2[i] - nums2[j] + diff.
        // 式子变形 nums1[i] - nums2[i] <= nums1[j] - nums2[j] + diff.
        // 设 a[i] = nums1[i] - nums2[i]，那么 a[i] <= a[j] + diff
        int n = nums1.length;
        int MX = (int) (4e4 + 10);
        FenwickTree ft = new FenwickTree();
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int x = nums1[i] - nums2[i];
            ans += ft.query(x + MX + diff);
            ft.change(x + MX, 1);
        }
        return ans;
    }

    class FenwickTree {
        int n;
        int[] s = new int[100005]; // 区间和
        int[] a = new int[100005];

        public FenwickTree(int n) {
            this.n = n;
        }

        public FenwickTree() {
            this.n = 100005;
        }

        public int lowbit(int x) { // 提取x的低位2次幂数（去掉二进制最后一位1）
            return x & -x;
        }

        public void change(int x, int k) {    // 向后修
            while (x <= n) {
                s[x] += k;
                x += lowbit(x);
            }
        }
        public int query(int x) { // 向前查（前缀和）
            int t = 0;
            while (x > 0) {
                t += s[x];
                x -= lowbit(x);
            }
            return t;
        }
    }


//    2426. 满足不等式的数对数目
//            困难
//    相关标签
//            相关企业
//    提示
//    给你两个下标从 0 开始的整数数组 nums1 和 nums2 ，两个数组的大小都为 n ，同时给你一个整数 diff ，统计满足以下条件的 数对 (i, j) ：
//
//            0 <= i < j <= n - 1 且
//    nums1[i] - nums1[j] <= nums2[i] - nums2[j] + diff.
//    请你返回满足条件的 数对数目 。
//
//
//
//    示例 1：
//
//    输入：nums1 = [3,2,5], nums2 = [2,2,1], diff = 1
//    输出：3
//    解释：
//    总共有 3 个满足条件的数对：
//            1. i = 0, j = 1：3 - 2 <= 2 - 2 + 1 。因为 i < j 且 1 <= 1 ，这个数对满足条件。
//            2. i = 0, j = 2：3 - 5 <= 2 - 1 + 1 。因为 i < j 且 -2 <= 2 ，这个数对满足条件。
//            3. i = 1, j = 2：2 - 5 <= 2 - 1 + 1 。因为 i < j 且 -3 <= 2 ，这个数对满足条件。
//    所以，我们返回 3 。
}
