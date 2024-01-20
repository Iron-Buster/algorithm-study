package com.fqh.二分答案;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/20 17:28
 **/
public class LC_1891 {


//    1891. 割绳子
//            中等
//    相关标签
//            相关企业
//    提示
//    给定一个整数数组 ribbons 和一个整数 k，数组每项 ribbons[i] 表示第 i 条绳子的长度。
//    对于每条绳子，你可以将任意切割成一系列长度为正整数的部分，或者选择不进行切割。
//
//    例如，如果给你一条长度为 4 的绳子，你可以：
//
//    保持绳子的长度为 4 不变；
//    切割成一条长度为 3 和一条长度为 1 的绳子；
//    切割成两条长度为 2 的绳子；
//    切割成一条长度为 2 和两条长度为 1 的绳子；
//    切割成四条长度为 1 的绳子。
//    你的任务是最终得到 k 条完全一样的绳子，他们的长度均为相同的正整数。如果绳子切割后有剩余，你可以直接舍弃掉多余的部分。
//
//    对于这 k 根绳子，返回你能得到的绳子最大长度；如果你无法得到 k 根相同长度的绳子，返回 0。

//    示例 1:
//
//    输入: ribbons = [9,7,5], k = 3
//    输出: 5
//    解释:
//            - 把第一条绳子切成两部分，一条长度为 5，一条长度为 4；
//            - 把第二条绳子切成两部分，一条长度为 5，一条长度为 2；
//            - 第三条绳子不进行切割；
//    现在，你得到了 3 条长度为 5 的绳子。
//    示例 2:
//
//    输入: ribbons = [7,5,9], k = 4
//    输出: 4
//    解释:
//            - 把第一条绳子切成两部分，一条长度为 4，一条长度为 3；
//            - 把第二条绳子切成两部分，一条长度为 4，一条长度为 1；
//            - 把第二条绳子切成三部分，一条长度为 4，一条长度为 4，还有一条长度为 1；
//    现在，你得到了 4 条长度为 4 的绳子。

    public boolean check(long x, int[] ribbons, int k) {
        int cnt = 0;
        for (int r : ribbons) {
            cnt += (int) (r / x);
        }
        return cnt >= k;
    }
    // 二分答案
    public int maxLength(int[] ribbons, int k) {
        long l = 0;
        long r = (long) (1e9 + 1);
        while (l < r) {
            long mid = l + r + 1 >> 1;
            if (check(mid, ribbons, k)) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return (int) l;
    }

    public static void main(String[] args) {
        int[] r = {9, 7, 5};
        int k = 3;
        System.out.println(new LC_1891().maxLength(r, k));
    }
}
