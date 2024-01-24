
# 1876. 长度为三且各字符不同的子字符串
# 已解答
# 第 53 场双周赛
# Q1
# 1249
# 相关标签
# 相关企业
# 提示
# 如果一个字符串不含有任何重复字符，我们称这个字符串为 好 字符串。

# 给你一个字符串 s ，请你返回 s 中长度为 3 的 好子字符串 的数量。

# 注意，如果相同的好子字符串出现多次，每一次都应该被记入答案之中。

# 子字符串 是一个字符串中连续的字符序列。


from typing import Counter


class Solution:
    def countGoodSubstrings(self, s: str) -> int:
        ans = 0
        j = 0
        cnt = Counter()
        for i, c in enumerate(s):
            cnt[ord(c)] += 1
            if i - j + 1 > 3:
                cnt[ord(s[j])] -= 1
                if not cnt[ord(s[j])]: del cnt[ord(s[j])]
                j += 1
            if i - j + 1 == 3 and len(cnt) == 3:
                ans += 1
        return ans