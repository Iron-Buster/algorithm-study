from collections import Counter

from math import comb


# 2514. 统计同位异构字符串数目
# 提示
# 2070
# 14
# 第 94 场双周赛
# Q4
# 相关企业
# 给你一个字符串 s ，它包含一个或者多个单词。单词之间用单个空格 ' ' 隔开。
#
# 如果字符串 t 中第 i 个单词是 s 中第 i 个单词的一个 排列 ，那么我们称字符串 t 是字符串 s 的同位异构字符串。
#
# 比方说，"acb dfe" 是 "abc def" 的同位异构字符串，但是 "def cab" 和 "adc bef" 不是。
# 请你返回 s 的同位异构字符串的数目，由于答案可能很大，请你将它对 109 + 7 取余 后返回。




class Solution:
    def countAnagrams(self, s: str) -> int:
        MOD = 10 ** 9 + 7
        # too hot
        # 把每个单词的方案数算出来，用乘法原理相乘
        # too -> 3!/2! = 3
        # hot -> 3! = 6
        # aab -> 3!/2! = 3
        # 分子分母分开计算
        # 3!*3!*3! / 2!*2! = 216/4 = 54
        # a表示 t字符串全排列个数
        # b表示 t字符串考虑相同字符的全排列个数
        a = b = 1
        for t in s.split(" "):
            cnt = Counter()
            for i, c in enumerate(t, 1):
                a = a * i % MOD
                cnt[c] += 1
                b = b * cnt[c] % MOD
        return a * pow(b, -1, MOD) % MOD  # 费马小定理


if __name__ == '__main__':
    res = Solution().countAnagrams("too hot")
    # print(3 * (3 - 1))
    # print(comb(3, 2))
    print(res)