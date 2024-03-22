# 274. H 指数
# 提示
# 中等
# 354
# 相关企业
# 给你一个整数数组 citations ，其中 citations[i] 表示研究者的第 i 篇论文被引用的次数。计算并返回该研究者的 h 指数。
#
# 根据维基百科上 h 指数的定义：h 代表“高引用次数” ，一名科研人员的 h 指数 是指他（她）至少发表了 h 篇论文，
# 并且每篇论文 至少 被引用 h 次。如果 h 有多种可能的值，h 指数 是其中最大的那个。

from typing import List


class Solution:
    def hIndex(self, citations: List[int]) -> int:
        def check(m: int) -> bool:
            return sum(x >= m for x in citations) >= m
        l, r = 0, 1001
        while l < r:
            mid = l + r + 1 >> 1
            if check(mid):
                l = mid
            else:
                r = mid - 1
        return l

if __name__ == '__main__':
    print("Ok")