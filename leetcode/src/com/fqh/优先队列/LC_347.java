package com.fqh.优先队列;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/13 18:35
 **/
public class LC_347 {

//    347. 前 K 个高频元素
//            中等
//    相关标签
//            相关企业
//    给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。

    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        var map = new HashMap<Integer, Integer>();
        for (int x : nums) {
            map.merge(x, 1, Integer::sum);
        }
        var pq = new PriorityQueue<Map.Entry<Integer, Integer>>(Comparator.comparingInt(Map.Entry::getValue));
        for (var entry : map.entrySet()) {
            pq.offer(entry);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        for (int i = 0; i < k; i++) {
            ans[k-i-1] = pq.poll().getKey();
        }
        return ans;
    }
}
