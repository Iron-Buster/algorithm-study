
# 2249. 统计圆内格点数目
# 已解答
# 第 290 场周赛
# Q2
# 1603
# 相关标签
# 相关企业
# 提示
# 给你一个二维整数数组 circles ，其中 circles[i] = [xi, yi, ri] 表示网格上圆心为 (xi, yi) 且半径为 ri 的第 i 个圆，返回出现在 至少一个 圆内的 格点数目 。

# 注意：

# 格点 是指整数坐标对应的点。
# 圆周上的点 也被视为出现在圆内的点。



from typing import List


class Solution:
    def countLatticePoints(self, circles: List[List[int]]) -> int:
        vis = set()
        for x, y, r in circles:
            for i in range(x - r, x + r + 1):
                for j in range(y - r, y + r + 1):
                    d = (i - x) * (i - x) + (j - y) * (j - y)
                    if d <= r * r: vis.add(201 * i + j)
        return len(vis)