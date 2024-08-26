"""
# Definition for Employee.
class Employee:
    def __init__(self, id: int, importance: int, subordinates: List[int]):
        self.id = id
        self.importance = importance
        self.subordinates = subordinates
"""
from collections import defaultdict
from typing import List

# https://leetcode.cn/problems/employee-importance/

class Solution:
    def getImportance(self, employees: List['Employee'], id: int) -> int:
        v = {}
        for i, e in enumerate(employees):
            v[e.id] = e.importance
        g = defaultdict(list)
        for i, e in enumerate(employees):
            for j in e.subordinates:
                g[e.id].append(j)
        ans = 0

        def dfs(x: int) -> None:
            nonlocal ans
            ans += v[x]
            for y in g[x]:
                dfs(y)

        dfs(id)
        return ans
