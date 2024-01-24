#
# 57. 插入区间
# 中等
# 764
# 相关企业
# 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
#
# 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
from typing import List


def merge(intervals: List[List[int]]) -> List[List[int]]:
    intervals.sort(key=lambda x: x[0])
    res = []
    for interval in intervals:
        if not res or res[-1][1] < interval[0]:
            res.append(interval)
        else:
            res[-1][1] = max(res[-1][1], interval[1])
    return res

class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        intervals.append(newInterval)
        return merge(intervals)



