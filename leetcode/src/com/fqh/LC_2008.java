package com.fqh;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: vq
 * @Date: 2023/12/8 9:31
 * @Version V1.0
 */
public class LC_2008 {


//    2008. 出租车的最大盈利
//            已解答
//    第 61 场双周赛
//            Q3
//    1872
//    相关标签
//            相关企业
//    提示
//    你驾驶出租车行驶在一条有 n 个地点的路上。这 n 个地点从近到远编号为 1 到 n ，你想要从 1 开到 n ，通过接乘客订单盈利。你只能沿着编号递增的方向前进，不能改变方向。
//
//    乘客信息用一个下标从 0 开始的二维数组 rides 表示，其中 rides[i] = [starti, endi, tipi] 表示第 i 位乘客需要从地点 starti 前往 endi ，愿意支付 tipi 元的小费。
//
//    每一位 你选择接单的乘客 i ，你可以 盈利 endi - starti + tipi 元。你同时 最多 只能接一个订单。
//
//    给你 n 和 rides ，请你返回在最优接单方案下，你能盈利 最多 多少元。
//
//    注意：你可以在一个地点放下一位乘客，并在同一个地点接上另一位乘客。

    Long[] f;
    public long maxTaxiEarnings(int n, int[][] rides) {
        f = new Long[n + 1];
        var map = new HashMap<Integer, List<int[]>>();
        // 将rides按照start 进行分组
        for (int[] ride : rides) {
            map.computeIfAbsent(ride[0], v -> new ArrayList<>());
            map.get(ride[0]).add(ride);
        }
        return dfs(0, n, map);
    }

    long dfs(int i, int n, Map<Integer, List<int[]>> map) {
        if (i >= n) return 0;
        if (f[i] != null) return f[i];
        long ans = 0;
        ans = dfs(i + 1, n, map);
        if (map.containsKey(i)) {
            for (int[] r : map.get(i)) {
                int v = r[1] - r[0] + r[2]; // 这段订单收益
                ans = Math.max(ans, dfs(r[1], n, map) + v);
            }
        }
        return f[i] = ans;
    }
}
