from collections import deque
from typing import List

# 1926. 迷宫中离入口最近的出口
# 提示
# 中等
# 55
# 相关企业
# 给你一个 m x n 的迷宫矩阵 maze （下标从 0 开始），矩阵中有空格子（用 '.' 表示）和墙（用 '+' 表示）。同时给你迷宫的入口 entrance ，用 entrance = [entrancerow, entrancecol] 表示你一开始所在格子的行和列。
#
# 每一步操作，你可以往 上，下，左 或者 右 移动一个格子。你不能进入墙所在的格子，你也不能离开迷宫。你的目标是找到离 entrance 最近 的出口。出口 的含义是 maze 边界 上的 空格子。entrance 格子 不算 出口。
#
# 请你返回从 entrance 到最近出口的最短路径的 步数 ，如果不存在这样的路径，请你返回 -1 。

class Solution:
    def nearestExit(self, maze: List[List[str]], entrance: List[int]) -> int:
        m, n = len(maze), len(maze[0])
        i, j = entrance[0], entrance[1]
        maze[i][j] = '+'
        q = deque([(i, j, 0)])
        while q:
            x, y, step = q.popleft()
            for nx, ny in (x+1, y), (x-1, y), (x, y+1), (x, y-1):
                if 0 <= nx < m and 0 <= ny < n and maze[nx][ny] == '.':
                    if nx == 0 or nx == m - 1 or ny == 0 or ny == n - 1:
                        return step + 1
                    maze[nx][ny] = '+'
                    q.append((nx, ny, step + 1))
        return -1




if __name__ == '__main__':
    print("ok")