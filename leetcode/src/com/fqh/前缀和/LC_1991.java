package com.fqh.前缀和;

/**
 * @Author: vq
 * @Date: 2023/12/18 21:59
 * @Version V1.0
 */
public class LC_1991 {

    // 前缀和
    static int[] prefixSum(int[] a) {
        int[] sum = new int[a.length + 1];
        for (int i = 0; i < a.length; i++) {
            sum[i + 1] = sum[i] + a[i];
        }
        return sum;
    }

    // 后缀和
    static int[] suffixSum(int[] a) {
        int[] sum = new int[a.length + 1];
        for (int i = a.length - 1; i >= 0; i--) {
            sum[i] = sum[i + 1] + a[i];
        }
        return sum;
    }


    public int findMiddleIndex(int[] nums) {
        int[] pre = prefixSum(nums);
        int[] suf = suffixSum(nums);
        for (int i = 0; i < nums.length; i++) {
            if (pre[i] == suf[i + 1]) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new LC_1991().findMiddleIndex(new int[]{2, 3, -1, 8, 4}));
    }

//    1991. 找到数组的中间位置
//    第 60 场双周赛
//            Q1
//1303
//    相关标签
//            相关企业
//    提示
//    给你一个下标从 0 开始的整数数组 nums ，请你找到 最左边 的中间位置 middleIndex （也就是所有可能中间位置下标最小的一个）。
//
//    中间位置 middleIndex 是满足 nums[0] + nums[1] + ... + nums[middleIndex-1] == nums[middleIndex+1] + nums[middleIndex+2] + ... + nums[nums.length-1] 的数组下标。
//
//    如果 middleIndex == 0 ，左边部分的和定义为 0 。类似的，如果 middleIndex == nums.length - 1 ，右边部分的和定义为 0 。
//
//    请你返回满足上述条件 最左边 的 middleIndex ，如果不存在这样的中间位置，请你返回 -1 。


}
