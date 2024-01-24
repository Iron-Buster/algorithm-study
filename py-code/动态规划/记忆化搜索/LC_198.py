from functools import cache
from typing import List


# 198. 打家劫舍
# 中等
# 2.7K
# 相关企业
# 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
#
# 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。



class Solution:
    def rob(self, nums: List[int]) -> int:
        @cache
        def dfs(i: int) -> int:
            return 0 if i < 0 else max(dfs(i - 1), dfs(i - 2) + nums[i])
        return dfs(len(nums) - 1)



if __name__ == '__main__':
    print("ok")