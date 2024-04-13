from itertools import *
from collections import *
from math import *
from cmath import *
from heapq import *
from functools import *
from bisect import *
from typing import List

MOD = 10 ** 9 + 7
inf = float('inf')
def PF(a):
    return [0] + list(accumulate(a))


# https://leetcode.cn/problems/tree-of-coprimes/description/?envType=daily-question&envId=2024-04-11

# 预处理：coprime[i] 保存 [1, MX) 中与 i 互质的所有元素
MX = 51
coprime = [[j for j in range(1, MX) if gcd(i, j) == 1]
           for i in range(MX)]

class Solution:
    def getCoprimes(self, nums: List[int], edges: List[List[int]]) -> List[int]:
        n = len(nums)
        g = defaultdict(list)
        for x, y in edges:
            g[x].append(y)
            g[y].append(x)
        ans = [0] * n
        val_depth_id = [(-1, -1)] * MX # 包含深度和节点编号
        def dfs(x: int, fa: int, depth: int) -> None:
            val = nums[x]
            # 计算与 val 互质的祖先节点值中，节点深度最大的节点编号
            ans[x] = max(val_depth_id[j] for j in coprime[val])[1]
            tmp = val_depth_id[val] # 用于恢复现场
            val_depth_id[val] = (depth, x)  # 保存 val 对应的节点深度和节点编号
            for y in g[x]:
                if y != fa:
                    dfs(y, x, depth + 1)
            val_depth_id[val] = tmp  # 恢复现场

        dfs(0, -1, 0)
        return ans