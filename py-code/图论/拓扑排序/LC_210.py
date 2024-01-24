# 210. 课程表 II
# 提示
# 中等
# 847
# 相关企业
# 现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。

# 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
# 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。


from collections import deque
from typing import List


class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> List[int]:
        g = [[] for _ in range(numCourses)]
        rd = [0 for _ in range(numCourses)]
        for x, y in prerequisites:
            g[x].append(y)
            rd[y] += 1
        q = deque()
        for i, num in enumerate(rd):
            if num == 0: q.append(i)
        res = []
        while q:
            u = q.popleft()
            res.append(u)
            numCourses -= 1
            for v in g[u]:
                rd[v] -= 1
                if rd[v] == 0: q.append(v)    
        return res[::-1] if numCourses == 0 else []


if __name__ == '__main__':
    print("ok")
    