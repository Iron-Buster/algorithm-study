# 1046. 最后一块石头的重量
# 已解答
# 第 137 场周赛
# Q1
# 1173
# 相关标签
# 相关企业
# 提示
# 有一堆石头，每块石头的重量都是正整数。

# 每一回合，从中选出两块 最重的 石头，然后将它们一起粉碎。假设石头的重量分别为 x 和 y，且 x <= y。那么粉碎的可能结果如下：

# 如果 x == y，那么两块石头都会被完全粉碎；
# 如果 x != y，那么重量为 x 的石头将会完全粉碎，而重量为 y 的石头新重量为 y-x。
# 最后，最多只会剩下一块石头。返回此石头的重量。如果没有石头剩下，就返回 0。


import heapq
from typing import List


class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        pq = [-x for x in stones]
        heapq.heapify(pq)
        while len(pq) > 1:
            x, y = heapq.heappop(pq), heapq.heappop(pq)
            if x == y: continue
            heapq.heappush(pq, x - y)
        return -pq[0] if pq else 0

            