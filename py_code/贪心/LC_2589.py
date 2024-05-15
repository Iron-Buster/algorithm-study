# https://leetcode.cn/problems/minimum-time-to-complete-all-tasks/description/?envType=daily-question&envId=2024-05-15

class Solution:
    def findMinimumTime(self, tasks: List[List[int]]) -> int:
        tasks.sort(key=lambda t:t[1])
        run = [False] * 2001
        for start, end, d in tasks:
            d -= sum(run[start: end+1]) # 去掉运行中的时间点
            if d <= 0:
                continue
            # 从后往前找没有运行的时间点
            for i in range(end, start-1, -1):
                if run[i]:
                    continue
                run[i] = True
                d -= 1
                if d == 0:
                    break
        return sum(run)

