# 6988. 统计距离为 k 的点对
# 已解答
# 中等
# 相关企业
# 提示
# 给你一个 二维 整数数组 coordinates 和一个整数 k ，其中 coordinates[i] = [xi, yi] 是第 i 个点在二维平面里的坐标。

# 我们定义两个点 (x1, y1) 和 (x2, y2) 的 距离 为 (x1 XOR x2) + (y1 XOR y2) ，XOR 指的是按位异或运算。

# 请你返回满足 i < j 且点 i 和点 j之间距离为 k 的点对数目


from collections import Counter
from typing import List


class Solution:
    '''
        (x1 ^ x2) + (y1 ^ y2) = k
        将 (x1 ^ x2) 看作i -> i的范围一定在[0, k]
        1.i + (y1 ^ y2) = k
        2.x1 ^ x2 = i -> x1 = i ^ x2
        3.(y1 ^ y2) = k - i -> y1 = y2 ^ (k - i) -> i的范围一定在[0, k] 
    '''
    def countPairs(self, coordinates: List[List[int]], k: int) -> int:
        cnt = Counter()
        ans = 0
        for x2, y2 in coordinates:
            # 枚举i
            for i in range(k + 1):
                # 累加map中{x2, y2}的个数
                ans += cnt[i ^ x2, (k - i) ^ y2] 
            cnt[x2, y2] += 1
        return ans
