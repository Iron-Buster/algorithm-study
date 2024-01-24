from typing import List


# 1218. 最长定差子序列
# 提示
# 1597
# 253
# 第 157 场周赛
# Q2
# 相关企业
# 给你一个整数数组 arr 和一个整数 difference，请你找出并返回 arr 中最长等差子序列的长度，该子序列中相邻元素之间的差等于 difference 。
#
# 子序列 是指在不改变其余元素顺序的情况下，通过删除一些元素或不删除任何元素而从 arr 派生出来的序列。

# TODO
class Solution:
    def longestSubsequence(self, arr: List[int], difference: int) -> int:
        def dfs(i: int, pre: int) -> int:
            if i < 0:
                return 0
            ans = 1
            if pre - arr[i] == difference:
                ans += max(dfs(i - 1, pre), dfs(i - 1, arr[i]) + 1)
            ans += max(ans, dfs(i - 1, pre))
            return ans
        return dfs(len(arr) - 1, 0)



if __name__ == '__main__':
    res = Solution().longestSubsequence([1, 2, 3, 4], 1)
    print(res)

