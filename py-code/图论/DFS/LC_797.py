from typing import List


# 797. 所有可能的路径
# 中等
# 416
# 相关企业
# 给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
#
#  graph[i] 是一个从节点 i 可以访问的所有节点的列表（即从节点 i 到节点 graph[i][j]存在一条有向边）。
class Solution:
    def allPathsSourceTarget(self, graph: List[List[int]]) -> List[List[int]]:
        ans = list()
        path = list()

        def dfs(u: int):
            if u == len(graph) - 1:
                ans.append(path[:])
                return
            for v in graph[u]:
                path.append(v)
                dfs(v)
                path.pop()

        path.append(0)
        dfs(0)
        return ans

if __name__ == '__main__':
    print("ok")