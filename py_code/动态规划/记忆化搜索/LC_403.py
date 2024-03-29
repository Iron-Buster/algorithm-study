from functools import cache
from typing import List


# 403. 青蛙过河
# 困难
# 509
# company
# 奥多比 Adobe
# 一只青蛙想要过河。 假定河流被等分为若干个单元格，并且在每一个单元格内都有可能放有一块石子（也有可能没有）。 青蛙可以跳上石子，但是不可以跳入水中。
#
# 给你石子的位置列表 stones（用单元格序号 升序 表示）， 请判定青蛙能否成功过河（即能否在最后一步跳至最后一块石子上）。
# 开始时， 青蛙默认已站在第一块石子上，并可以假定它第一步只能跳跃 1 个单位（即只能从单元格 1 跳至单元格 2 ）。
#
# 如果青蛙上一步跳跃了 k 个单位，那么它接下来的跳跃距离只能选择为 k - 1、k 或 k + 1 个单位。 另请注意，青蛙只能向前方（终点的方向）跳跃。

class Solution:
    def canCross(self, stones: List[int]) -> bool:
        st = set(stones)
        @cache
        def dfs(i: int, k: int) -> bool:
            if i > stones[-1]:
                return False
            if i == stones[-1]:
                return True
            ans = False
            if (i + k - 1) in st and (i + k - 1) > i:
                ans |= dfs(i + k - 1, k - 1)
            if (i + k) in st and (i + k != i):
                ans |= dfs(i + k, k)
            if (i + k + 1) in st:
                ans |= dfs(i + k + 1, k + 1)
            return ans
        return dfs(stones[0], 0)




if __name__ == '__main__':
    res = Solution().canCross([0, 1, 2, 3, 4, 8, 9, 11])
    print(res)
