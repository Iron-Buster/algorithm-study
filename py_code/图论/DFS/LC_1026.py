from itertools import *
from collections import *
from math import *
from cmath import *
from heapq import *
from functools import *
from bisect import *
from typing import List, Optional

MOD = 10 ** 9 + 7
inf = float('inf')
def PF(a):
    return [0] + list(accumulate(a))

# https://leetcode.cn/problems/maximum-difference-between-node-and-ancestor/description/?envType=daily-question&envId=2024-04-05




# Definition for a binary tree node.
class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

class Solution:
    def maxAncestorDiff(self, root: Optional[TreeNode]) -> int:
        res = -inf
        def dfs(o: Optional[TreeNode]) -> List[int]:
            if o is None:
                return [inf, -inf]
            left = dfs(o.left)
            right = dfs(o.right)

            ans = [inf, -inf]
            ans[0] = min(left[0], right[0], o.val)
            ans[1] = max(left[1], right[1], o.val)
            nonlocal res
            res = max(res, abs(o.val - ans[0]), abs(o.val - ans[1]))
            return ans

        dfs(root)
        return res
