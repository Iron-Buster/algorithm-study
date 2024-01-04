package com.fqh.数学.筛质数;

import com.fqh.BisectTemplate;

import java.util.*;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/4 22:53
 **/
public class LC_2523 {

    static final int MX = (int) 1e6;
    static List<Integer> primes = new ArrayList<>();
    // 埃氏筛预处理1e6范围内的质数
    static {
        // 或者，只是单纯想标记一下
        var set = new HashSet<Long>();
        for (long i = 2; i <= MX; i++) {
            if (!set.contains(i)) {
                primes.add((int) i);
                set.add(i);
                for (long j = i * i; j <= MX; j += i) { // 避免溢出
                    set.add(j);
                }
            }
        }
    }

    public int[] closestPrimes(int left, int right) {
        int[] ans = {0, MX+1};
        int idx1 = bisectLeft2(primes, left);
        if (idx1 >= primes.size() || primes.get(idx1) < left) {
            return new int[]{-1, -1};
        }
        for (int i = idx1 + 1; i < primes.size(); i++) {
            if (primes.get(i) > right) break;
            if (ans[1] - ans[0] > primes.get(i) - primes.get(i-1)) {
                ans[0] = primes.get(i-1);
                ans[1] = primes.get(i);
            }
        }
        if (ans[0] == 0 && ans[1] == MX+1) {
            return new int[]{-1, -1};
        }
        return ans;
    }

    /**
     * 返回 `target` 在 `a` 中最左边的插入位置。
     * 存在多个相同的值时，返回最左边的位置。
     * @param a         list集合
     * @param target    搜索的值
     * @return
     */
    public static int bisectLeft2(List<Integer> a, long target) {
        int left = 0, right = a.size() - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (a.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }


//    2523. 范围内最接近的两个质数
//    第 326 场周赛
//            Q4
//    1650
//    相关标签
//            相关企业
//    提示
//    给你两个正整数 left 和 right ，请你找到两个整数 num1 和 num2 ，它们满足：
//
//    left <= nums1 < nums2 <= right  。
//    nums1 和 nums2 都是 质数 。
//    nums2 - nums1 是满足上述条件的质数对中的 最小值 。
//    请你返回正整数数组 ans = [nums1, nums2] 。如果有多个整数对满足上述条件，请你返回 nums1 最小的质数对。如果不存在符合题意的质数对，请你返回 [-1, -1] 。
//
//    如果一个整数大于 1 ，且只能被 1 和它自己整除，那么它是一个 质数。

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new LC_2523().closestPrimes(999998, 1000000)));
    }
}
