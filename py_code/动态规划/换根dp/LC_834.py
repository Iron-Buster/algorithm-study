# 834. 树中距离之和
# 已解答
# 第 84 场周赛
# Q4
# 2197
# 相关标签
# 相关企业
# 给定一个无向、连通的树。树中有 n 个标记为 0...n-1 的节点以及 n-1 条边 。

# 给定整数 n 和数组 edges ， edges[i] = [ai, bi]表示树中的节点 ai 和 bi 之间有一条边。

# 返回长度为 n 的数组 answer ，其中 answer[i] 是树中第 i 个节点与所有其他节点之间的距离之和。




from collections import defaultdict
from typing import List


class Solution:
    def sumOfDistancesInTree(self, n: int, edges: List[List[int]]) -> List[int]:
        g = defaultdict(list)
        ans = [0] * n
        size = [0] * n
        dep = [0] * n
        for u, v in edges:
            g[u].append(v)
            g[v].append(u)
        # 预处理出 ans[0] 以及每个子树的大小
        def dfs(u: int, fa: int) -> None:
            ans[0] += ans[fa]
            dep[u] = 0 if fa == -1 else dep[fa] + 1
            size[u] = 1
            for v in g[u]:
                if v == fa: continue
                dfs(v, u)
                size[u] += size[v]
        dfs(0, -1)
        for i in range(n): 
            ans[0] += dep[i]
        # 换根dp
        def dfs1(u: int, fa: int) -> None:
            for v in g[u]:
                if v == fa: continue
                ans[v] = ans[u] + (n - size[v]) - size[v]
                dfs1(v, u)
        dfs1(0, -1)
        return ans