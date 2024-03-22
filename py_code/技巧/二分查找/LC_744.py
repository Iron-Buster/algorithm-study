# 744. 寻找比目标字母大的最小字母
# 提示
# 简单
# 280
# 相关企业
# 给你一个字符数组 letters，该数组按非递减顺序排序，以及一个字符 target。letters 里至少有两个不同的字符。

# 返回 letters 中大于 target 的最小的字符。如果不存在这样的字符，则返回 letters 的第一个字符


from typing import List


class Solution:
    def nextGreatestLetter(self, letters: List[str], target: str) -> str:
        l, r = 0, len(letters) - 1
        while l < r:
            mid = l + r >> 1
            if letters[mid] > target: r = mid
            else: l = mid + 1
        return letters[l] if letters[l] > target else letters[0]