# 207. 课程表
# 提示
# 中等
# 1.8K
# 相关企业
# 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。

# 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。

# 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
# 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 


from collections import deque
from typing import List


class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        g = [[] for _ in range(numCourses)]
        rd = [0 for _ in range(numCourses)]                 # 入度
        for a, b in prerequisites:
            g[b].append(a)
            rd[a] += 1
        q = deque()
        for i, x in enumerate(rd):
            if x == 0: q.append(i)
        while q:
            u = q.popleft()
            numCourses -= 1
            for v in g[u]:
                rd[v] -= 1
                if rd[v] == 0: q.append(v)
        return numCourses == 0
        
if __name__ == '__main__':
    print("ok")