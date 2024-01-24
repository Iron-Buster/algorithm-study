# 2316. 统计无向图中无法互相到达点对数
# 已解答
# 第 81 场双周赛
# Q2
# 1604
# 相关标签
# 相关企业
# 提示
# 给你一个整数 n ，表示一张 无向图 中有 n 个节点，编号为 0 到 n - 1 。同时给你一个二维整数数组 edges ，其中 edges[i] = [ai, bi] 表示节点 ai 和 bi 之间有一条 无向 边。

# 请你返回 无法互相到达 的不同 点对数目 。


from typing import Counter, List

class DSU:
    '''
        元素是 0-n-1的并查集写法
        初始化的联通分量个数为 n
    '''
    __slots__ = ("n", "part", "_parent", "_rank")

    def __init__(self, n: int):
        self.n = n
        self.part = n
        self._parent = list(range(n))
        self._rank = [1] * n

    def find(self, x: int) -> int:
        while self._parent[x] != x:
            self._parent[x] = self._parent[self._parent[x]]
            x = self._parent[x]
        return x

    def union(self, x: int, y: int) -> bool:
        """按秩合并."""
        rootX = self.find(x)
        rootY = self.find(y)
        if rootX == rootY:
            return False
        if self._rank[rootX] > self._rank[rootY]:
            rootX, rootY = rootY, rootX
        self._parent[rootX] = rootY
        self._rank[rootY] += self._rank[rootX]
        self.part -= 1
        return True

    def isConnected(self, x: int, y: int) -> bool:
        return self.find(x) == self.find(y)


class Solution:
    def countPairs(self, n: int, edges: List[List[int]]) -> int:
        dsu = DSU(n)
        for x, y in edges:
            dsu.union(x, y)
        group = Counter()
        for i in range(n):
            root = dsu.find(i)
            group[root] += 1
        ans = 0
        for cnt in group.values():
            ans += cnt * (n - cnt)      # 乘法原理
        return ans // 2