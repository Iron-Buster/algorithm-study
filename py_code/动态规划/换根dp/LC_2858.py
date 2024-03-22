# 2858. 可以到达每一个节点的最少边反转次数
# 困难
# 相关标签
# 相关企业
# 提示
# 给你一个 n 个点的 简单有向图 （没有重复边的有向图），节点编号为 0 到 n - 1 。如果这些边是双向边，那么这个图形成一棵 树 。

# 给你一个整数 n 和一个 二维 整数数组 edges ，其中 edges[i] = [ui, vi] 表示从节点 ui 到节点 vi 有一条 有向边 。

# 边反转 指的是将一条边的方向反转，也就是说一条从节点 ui 到节点 vi 的边会变为一条从节点 vi 到节点 ui 的边。

# 对于范围 [0, n - 1] 中的每一个节点 i ，你的任务是分别 独立 计算 最少 需要多少次 边反转 ，从节点 i 出发经过 一系列有向边 ，可以到达所有的节点。

# 请你返回一个长度为 n 的整数数组 answer ，其中 answer[i]表示从节点 i 出发，可以到达所有节点的 最少边反转 次数



from collections import defaultdict
from typing import List


class Solution:
    def minEdgeReversals(self, n: int, edges: List[List[int]]) -> List[int]:
        g = defaultdict(list)
        ans = [0] * n
        for u, v in edges:
            g[u].append([v, 1]) 
            g[v].append([u, -1])
        # 预处理根节点和子树
        def dfs(u: int, fa: int) -> None:
            for v, d in g[u]:
                if v == fa: continue
                ans[0] += d < 0
                dfs(v, u)
        # 换根dp
        def dfs1(u: int, fa: int) -> None:
            for v, d in g[u]:
                if v == fa: continue
                if d == -1:   
                    ans[v] = ans[u] - 1
                else:
                    ans[v] = ans[u] + 1
                dfs1(v, u)
                
        dfs(0, -1)
        dfs1(0, -1)
        return ans  
    