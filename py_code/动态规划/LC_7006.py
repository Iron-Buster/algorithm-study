# 7006. 销售利润最大化
# 提示
# 中等
# 13
# 相关企业
# 给你一个整数 n 表示数轴上的房屋数量，编号从 0 到 n - 1 。
#
# 另给你一个二维整数数组 offers ，其中 offers[i] = [starti, endi, goldi] 表示第 i 个买家想要以 goldi 枚金币的价格购买从 starti 到 endi 的所有房屋。
#
# 作为一名销售，你需要有策略地选择并销售房屋使自己的收入最大化。
#
# 返回你可以赚取的金币的最大数目。
#
# 注意 同一所房屋不能卖给不同的买家，并且允许保留一些房屋不进行出售。
from collections import defaultdict
from functools import cache
from typing import List


class Solution:
    def maximizeTheProfit(self, n: int, offers: List[List[int]]) -> int:
        mp = defaultdict(list)
        for x, y, z in offers:
            mp[x].append([y, z])
        @cache
        def dfs(i: int) -> int:
            if i == n:
                return 0
            res = dfs(i + 1)
            for y, z in mp[i]:
                res = max(res, dfs(y + 1) + z)
            return res
        return dfs(0)


if __name__ == '__main__':
    print("ok")


