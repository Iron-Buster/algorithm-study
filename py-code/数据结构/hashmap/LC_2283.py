
# 283. 判断一个数的数字计数是否等于数位的值
# 已解答
# 第 79 场双周赛
# Q1
# 1253
# 相关标签
# 相关企业
# 提示
# 给你一个下标从 0 开始长度为 n 的字符串 num ，它只包含数字。

# 如果对于 每个 0 <= i < n 的下标 i ，都满足数位 i 在 num 中出现了 num[i]次，
# 那么请你返回 true ，否则返回 false 



from collections import Counter


class Solution:
    def digitCount(self, num: str) -> bool:
        cnt = Counter(num)
        return all(cnt[str(i)] == int(v) for i, v in enumerate(num))