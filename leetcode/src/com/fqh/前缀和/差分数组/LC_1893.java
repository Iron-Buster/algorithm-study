package com.fqh.前缀和.差分数组;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2023/12/30 14:36
 **/
public class LC_1893 {


    public boolean isCovered(int[][] ranges, int left, int right) {
        int[] diff = new int[301];
        for (int[] r : ranges) {
            diff[r[0]] += 1;
            diff[r[1]+1] -= 1;
        }
        for (int i = 1; i <= 300; i++) {
            diff[i] += diff[i-1];
        }
        for (int i = left; i <= right; i++) {
            if (diff[i] <= 0) return false;
        }
        return true;
    }

//    1893. 检查是否区域内所有整数都被覆盖
//            已解答
//    第 54 场双周赛
//            Q1
//1307
//    相关标签
//            相关企业
//    提示
//    给你一个二维整数数组 ranges 和两个整数 left 和 right 。每个 ranges[i] = [starti, endi] 表示一个从 starti 到 endi 的 闭区间 。
//
//    如果闭区间 [left, right] 内每个整数都被 ranges 中 至少一个 区间覆盖，那么请你返回 true ，否则返回 false 。
//
//    已知区间 ranges[i] = [starti, endi] ，如果整数 x 满足 starti <= x <= endi ，那么我们称整数x 被覆盖了。
}
