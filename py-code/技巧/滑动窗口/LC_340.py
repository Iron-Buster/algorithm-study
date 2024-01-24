# 340. 至多包含 K 个不同字符的最长子串
# 中等
# 241
# company
# 亚马逊
# company
# 谷歌 Google
# 给你一个字符串 s 和一个整数 k ，请你找出 至多 包含 k 个 不同 字符的最长子串，并返回该子串的长度。
from collections import Counter


class Solution:
    def lengthOfLongestSubstringKDistinct(self, s: str, k: int) -> int:
        return self.lengthOfLongestSubstringTwoDistinct(s, k)

    def lengthOfLongestSubstringTwoDistinct(self, s: str, k: int) -> int:
        cnt = Counter()
        i = j = ans = 0
        for i, v in enumerate(s):
            cnt[v] += 1
            while len(cnt) > k:
                cnt[s[j]] -= 1
                if cnt[s[j]] == 0:
                    del cnt[s[j]]
                j += 1
            ans = max(ans, i - j + 1)
        return ans


if __name__ == '__main__':
    print("ok")
