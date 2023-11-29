package com.fqh.数据结构设计;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * @Author: vq
 * @Date: 2023/11/29 15:44
 * @Version V1.0
 */
public class LC_2336 {

//    2336. 无限集中的最小数字
//        第 301 场周赛
//                Q2
//    1375
//        相关标签
//                相关企业
//        提示
//        现有一个包含所有正整数的集合 [1, 2, 3, 4, 5, ...] 。
//
//        实现 SmallestInfiniteSet 类：
//
//        SmallestInfiniteSet() 初始化 SmallestInfiniteSet 对象以包含 所有 正整数。
//        int popSmallest() 移除 并返回该无限集中的最小整数。
//        void addBack(int num) 如果正整数 num 不 存在于无限集中，则将一个 num 添加 到该无限集最后。

//    1 <= num <= 1000
//    最多调用 popSmallest 和 addBack 方法 共计 1000 次

    class SmallestInfiniteSet {
        private PriorityQueue<Integer> pq;
        private HashSet<Integer> set;

        public SmallestInfiniteSet() {
            pq = new PriorityQueue<>((a, b) -> a - b);
            set = new HashSet<>();
            for (int i = 1; i <= 1000; ++i) {
                pq.offer(i);
                set.add(i);
            }
        }

        public int popSmallest() {
            Integer x = pq.poll();
            set.remove(x);
            return x;
        }

        public void addBack(int num) {
            if (set.contains(num)) {
                return;
            }
            pq.offer(num);
            set.add(num);
        }
    }
}
