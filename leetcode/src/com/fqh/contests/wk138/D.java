package com.fqh.contests.wk138;

import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @Author: vq
 * @Date: 2023/11/25 13:49
 * @Version V1.0
 */
public class D {
//    1054. 距离相等的条形码
//            已解答
//    第 138 场周赛
//            Q4
//1702
//    相关标签
//            相关企业
//    提示
//    在一个仓库里，有一排条形码，其中第 i 个条形码为 barcodes[i]。
//
//    请你重新排列这些条形码，使其中任意两个相邻的条形码不能相等。 你可以返回任何满足该要求的答案，此题保证存在答案。
//
//
//
//    示例 1：
//
//    输入：barcodes = [1,1,1,2,2,2]
//    输出：[2,1,2,1,2,1]
//    示例 2：
//
//    输入：barcodes = [1,1,1,1,2,2,3,3]
//    输出：[1,3,1,3,2,1,2,1]

    public int[] rearrangeBarcodes(int[] barcodes) {
        var map = new HashMap<Integer, Integer>();
        for (int x : barcodes) {
            map.merge(x, 1, Integer::sum);
        }
        var pq = new PriorityQueue<Pair>((a, b) -> b.cnt - a.cnt);
        for (var entry : map.entrySet()) {
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
        }
        int n = barcodes.length, i = 0;
        var ans = new int[n];
        while (pq.size() > 0) {
            // 构造ab
            if (pq.size() > 1) {
                var p1 = pq.poll();
                var p2 = pq.poll();
                ans[i++] = p1.v;
                ans[i++] = p2.v;
                p1.cnt--; p2.cnt--;
                if (p1.cnt != 0) pq.offer(p1);
                if (p2.cnt != 0) pq.offer(p2);
            } else {
                var p1 = pq.poll();
                ans[i++] = p1.v;
                p1.cnt--;
                if (p1.cnt != 0) pq.offer(p1);
            }
        }
        return ans;
    }

    static class Pair {
        int v;
        int cnt;

        public Pair(int v, int cnt) {
            this.v = v;
            this.cnt = cnt;
        }
    }
}
