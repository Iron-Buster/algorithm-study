package com.fqh.二分查找;

/**
 * @Author: vq
 * @Date: 2023/12/18 12:01
 * @Version V1.0
 */
public class LC_162 {

//    162. 寻找峰值
//            中等
//    相关标签
//            相关企业
//    峰值元素是指其值严格大于左右相邻值的元素。
//
//    给你一个整数数组 nums，找到峰值元素并返回其索引。数组可能包含多个峰值，在这种情况下，返回 任何一个峰值 所在位置即可。
//
//    你可以假设 nums[-1] = nums[n] = -∞ 。
//
//    你必须实现时间复杂度为 O(log n) 的算法来解决此问题。

//    输入：nums = [1,2,1,3,5,6,4]
//    输出：1 或 5
//    解释：你的函数可以返回索引 1，其峰值元素为 2；
//    或者返回索引 5， 其峰值元素为 6。

    public int findPeakElement(int[] nums) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] > nums[mid + 1]) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        int[] a = {1, 2, 1, 3, 5, 6, 4};
        System.out.println(new LC_162().findPeakElement(a));
    }
}
