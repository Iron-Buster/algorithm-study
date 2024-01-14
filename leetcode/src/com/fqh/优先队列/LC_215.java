package com.fqh.优先队列;

import java.util.PriorityQueue;

/**
 * @author ikun
 * @version v1.0.0
 * @since 2024/1/14 21:46
 **/
public class LC_215 {

//    215. 数组中的第K个最大元素
//            中等
//    相关标签
//            相关企业
//    给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
//
//    请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
//
//    你必须设计并实现时间复杂度为 O(n) 的算法解决此问题。

    public int findKthLargest(int[] nums, int k) {
        var pq = new PriorityQueue<Integer>((a, b) -> a - b);
        for (int x : nums) {
            pq.offer(x);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.poll();
    }

}
