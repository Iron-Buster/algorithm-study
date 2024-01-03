package com.fqh.二分答案;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/3 16:36
 **/
public class LC_1283 {

    public boolean check(long x, int[] a, int threshold) {
        long s = 0;
        for (int y : a) {
            s += (y + x - 1) / x;
        }
        return s <= threshold;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        long l = 1;
        long r = (int) 5e10;
        while (l < r) {
            long mid = l + r >> 1;
            if (check(mid, nums, threshold)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return (int) l;
    }

//    1283. 使结果不超过阈值的最小除数
//    第 166 场周赛
//            Q3
//    1542
//    相关标签
//            相关企业
//    提示
//    给你一个整数数组 nums 和一个正整数 threshold  ，你需要选择一个正整数作为除数，然后将数组里每个数都除以它，并对除法结果求和。
//
//    请你找出能够使上述结果小于等于阈值 threshold 的除数中 最小 的那个。
//
//    每个数除以除数后都向上取整，比方说 7/3 = 3 ， 10/2 = 5 。
//
//    题目保证一定有解。
//
//
//
//    示例 1：
//
//    输入：nums = [1,2,5,9], threshold = 6
//    输出：5
//    解释：如果除数为 1 ，我们可以得到和为 17 （1+2+5+9）。
//    如果除数为 4 ，我们可以得到和为 7 (1+1+2+3) 。如果除数为 5 ，和为 5

    public static void main(String[] args) {
        int[] a = {1, 2, 5, 9};
        System.out.println(new LC_1283().smallestDivisor(a, 6));
    }
}
