package com.fqh.前缀和.差分数组;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/20 00:31
 **/
public class LC_253 {

//        253. 会议室 II
//    已解答
//            中等
//    相关标签
//            相关企业
//    提示
//    给你一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，返回 所需会议室的最小数量 。
//
//
//
//    示例 1：
//
//    输入：intervals = [[0,30],[5,10],[15,20]]
//    输出：2
//    示例 2：
//
//    输入：intervals = [[7,10],[2,4]]
//    输出：1

    // 差分数组
    public int minMeetingRooms(int[][] intervals) {
        int mx = 0;
        for (int[] iv : intervals) mx = Math.max(mx, iv[1]);
        int[] diff = new int[mx+10];
        for (int[] iv : intervals) {
            int l = iv[0], r = iv[1];
            diff[l] += 1;
            diff[r] -= 1;
            mx = Math.max(mx, r);
        }
        int ans = diff[0], s = diff[0];
        for (int i = 1; i <= mx; i++) {
            s += diff[i];
            ans = Math.max(ans, s);
        }
        return ans;
    }



}
