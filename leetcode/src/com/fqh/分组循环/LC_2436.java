package com.fqh.分组循环;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/19 23:02
 **/
public class LC_2436 {

//    2436. 使子数组最大公约数大于一的最小分割数
//            已解答
//    中等
//            相关标签
//    提示
//    给定一个由正整数组成的数组 nums。
//
//    将数组拆分为 一个或多个 互相不覆盖的子数组，如下所示:
//
//    数组中的每个元素都 只属于一个 子数组，并且
//    每个子数组元素的 最大公约数 严格大于 1。
//    返回拆分后可获得的子数组的最小数目。
//
//    注意:
//
//    子数组的 最大公约数 是能将子数组中所有元素整除的最大正整数。
//    子数组 是数组的连续部分。
//
//
//
//    示例 1:
//
//    输入: nums = [12,6,3,14,8]
//    输出: 2
//    解释: 我们可以把数组分成子数组:[12,6,3] 和 [14,8]。
//            - 12、6、3 的最大公约数是 3，严格大于 1。
//            - 14 和 8 的最大公约数是 2，严格来说大于 1。
    public int minimumSplits(int[] nums) {
        return f(nums);
    }

    // 分组循环
    public int f(int[] a) {
        int n = a.length;
        int i = 0, g = 0;
        int ans = 0;
        while (i < n) {
            int st = i;
            g = a[st];
            for (++i; i < n && (g = gcd(g, a[i])) > 1; i++);
            ans++; // 划分一次
        }
        return ans;
    }

    // 最大公约数
    static int gcd(int a, int b) {
        while (a != 0) {
            int temp = a;
            a = b % a;
            b = temp;
        }
        return b;
    }
}
