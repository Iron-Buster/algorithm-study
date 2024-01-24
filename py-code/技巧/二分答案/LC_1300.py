# 1300. 转变数组后最接近目标值的数组和
# 第 16 场双周赛
# Q2
# 1607
# 相关标签
# 相关企业
# 提示
# 给你一个整数数组 arr 和一个目标值 target ，请你返回一个整数 value ，使得将数组中所有大于 value 的值变成 value 后，数组的和最接近  target （最接近表示两者之差的绝对值最小）。

# 如果有多种使得和最接近 target 的方案，请你返回这些整数中的最小值。

# 请注意，答案不一定是 arr 中的数字

from typing import List



class Solution:
    '''
        二分答案猜value
    '''
    def findBestValue(self, arr: List[int], target: int) -> int:
        l, r = 1, max(arr)
        def check(mid: int) -> bool:
            s = 0
            for x in arr:
                s += min(x, mid)
            return s
        while l <= r:
            mid = l + r >> 1
            s = check(mid)
            if s == target: return mid      # 数组和刚好等于target 此时mid是最合适的 直接返回
            if s < target:
                l = mid + 1
            else:
                r = mid - 1
        # 最后判断是取l合适 还是r
        if abs(check(l) - target) < abs(check(r) - target):
            return l
        return r