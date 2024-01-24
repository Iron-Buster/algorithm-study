# 3. 无重复字符的最长子串
# 中等
# 9.4K
# 相关企业
# 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
from collections import Counter


class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        cnt = Counter() # 哈希表
        i = j = 0
        ans = 0
        while i < len(s):
            cnt[s[i]] += 1
            while cnt[s[i]] > 1:
                cnt[s[j]] -= 1
                j += 1
            ans = max(ans, i - j + 1)
            i += 1
        return ans

if __name__ == '__main__':
    s = "abcabcbb"
    ret = Solution().lengthOfLongestSubstring(s)
    print(ret)