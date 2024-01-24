# 436. 寻找右区间
# 中等
# 245
# 相关企业
# 给你一个区间数组 intervals ，其中 intervals[i] = [starti, endi] ，且每个 starti 都 不同 。

# 区间 i 的 右侧区间 可以记作区间 j ，并满足 startj >= endi ，且 startj 最小化 。注意 i 可能等于 j 。

# 返回一个由每个区间 i 的 右侧区间 在 intervals 中对应下标组成的数组。如果某个区间 i 不存在对应的 右侧区间 ，则下标 i 处的值设为 -1 。



from bisect import bisect_left
from typing import List


class Solution:
    def findRightInterval(self, intervals: List[List[int]]) -> List[int]:
        for i, interval in enumerate(intervals):
            interval.append(i)
        intervals.sort()
        n = len(intervals)
        res = [-1] * n
        for _, end, id in intervals:
            idx = bisect_left(intervals, [end]) # 二分查找大于等于[end]的最小值
            if idx < n: res[id] = intervals[idx][2]
        return res
    
if __name__ == '__main__':
    res = Solution().findRightInterval([[3, 4], [2, 3], [1, 2]])
    print(res)