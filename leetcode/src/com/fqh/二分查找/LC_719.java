package com.fqh.二分查找;

import java.util.Arrays;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/8 18:36
 **/
public class LC_719 {

    // 二分check距离为mid时 a种的距离对数是否 <= k
    public boolean check(int[] a, int mid, int k) {
        int cnt = 0;
        // 可以使用滑动窗口来 查询子数组数对距离不超过mid的个数
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            while (a[i] - a[j] > mid) { // 缩小窗口
                j++;
            }
            cnt += i - j;
        }
        return cnt < k;
    }

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = (int) (1e6 + 1);
        while (l < r) {
            int mid = l + r >> 1;
            if (check(nums, mid, k)) { //往k逼近
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l;
    }

//    719. 找出第 K 小的数对距离
//            困难
//    相关标签
//            相关企业
//    提示
//    数对 (a,b) 由整数 a 和 b 组成，其数对距离定义为 a 和 b 的绝对差值。
//
//    给你一个整数数组 nums 和一个整数 k ，数对由 nums[i] 和 nums[j] 组成且满足 0 <= i < j < nums.length 。返回 所有数对距离中 第 k 小的数对距离。
//
//
//
//    示例 1：
//
//    输入：nums = [1,3,1], k = 1
//    输出：0
//    解释：数对和对应的距离如下：
//            (1,3) -> 2
//            (1,1) -> 0
//            (3,1) -> 2
//    距离第 1 小的数对是 (1,1) ，距离为 0 。
//    示例 2：
//
//    输入：nums = [1,1,1], k = 2
//    输出：0
//    示例 3：
//
//    输入：nums = [1,6,1], k = 3
//    输出：5

    public static void main(String[] args) {
        int[] a = {1, 6, 1};
        int k = 3;
        System.out.println(new LC_719().smallestDistancePair(a, k));
    }
}
