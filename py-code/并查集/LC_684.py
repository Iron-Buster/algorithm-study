# 684. 冗余连接
# 中等
# 578
# 相关企业
# 树可以看成是一个连通且 无环 的 无向 图。

# 给定往一棵 n 个节点 (节点值 1～n) 的树中添加一条边后的图。添加的边的两个顶点包含在 1 到 n 中间，且这条附加的边不属于树中已存在的边。图的信息记录于长度为 n 的二维数组 edges ，edges[i] = [ai, bi] 表示图中在 ai 和 bi 之间存在一条边。

# 请找出一条可以删去的边，删除后可使得剩余部分是一个有着 n 个节点的树。如果有多个答案，则返回数组 edges 中最后出现的那个

from collections import defaultdict
from typing import Callable, List

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
    def findRedundantConnection(self, edges: List[List[int]]) -> List[int]:
        dsu = DSU(len(edges))
        for e in edges:
            if dsu.isConnected(e[0], e[1]):
                return [e[0], e[1]]
            dsu.union(e[0], e[1])
        return [0, 0]



if __name__ == '__main__':
    print("ok")
        