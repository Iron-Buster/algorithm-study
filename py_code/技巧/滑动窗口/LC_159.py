# 159. 至多包含两个不同字符的最长子串
# 中等
# 209
# company
# 彭博 Bloomberg
# 给你一个字符串 s ，请你找出 至多 包含 两个不同字符 的最长子串，并返回该子串的长度。
from collections import Counter


class Solution:
    def lengthOfLongestSubstringTwoDistinct(self, s: str) -> int:
        cnt = Counter()
        i = j = ans = 0
        for i, v in enumerate(s):
            cnt[v] += 1
            while len(cnt) > 2:
                cnt[s[j]] -= 1
                if cnt[s[j]] == 0:
                    del cnt[s[j]]
                j += 1
            ans = max(ans, i - j + 1)
        return ans


if __name__ == '__main__':
    print("ok")