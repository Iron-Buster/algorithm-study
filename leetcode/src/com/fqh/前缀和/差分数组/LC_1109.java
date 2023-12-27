package com.fqh.前缀和.差分数组;

import java.util.Arrays;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2023/12/27 15:29
 **/
public class LC_1109 {

    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] diff = new int[n + 1];
        for (int[] b : bookings) {
            diff[b[0]-1] += b[2];
            diff[b[1]] -= b[2];
        }
        for (int i = 1; i <= n; i++) {
            diff[i] += diff[i-1];
        }
        return Arrays.copyOfRange(diff, 0, n);
    }

//    1109. 航班预订统计
//            已解答
//    第 144 场周赛
//            Q2
//1570
//    相关标签
//            相关企业
//    这里有 n 个航班，它们分别从 1 到 n 进行编号。
//
//    有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi] 意味着在从 firsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。
//
//    请你返回一个长度为 n 的数组 answer，里面的元素是每个航班预定的座位总数。
}
