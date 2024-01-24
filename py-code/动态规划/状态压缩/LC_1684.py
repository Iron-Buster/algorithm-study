# 1684. 统计一致字符串的数目
# 提示
# 1289
# 116
# 第 41 场双周赛
# Q1
# 相关企业
# 给你一个由不同字符组成的字符串 allowed 和一个字符串数组 words 。如果一个字符串的每一个字符都在 allowed 中，就称这个字符串是 一致字符串 。

# 请你返回 words 数组中 一致字符串 的数目。

# 示例 1：

# 输入：allowed = "ab", words = ["ad","bd","aaab","baa","badab"]
# 输出：2
# 解释：字符串 "aaab" 和 "baa" 都是一致字符串，因为它们只包含字符 'a' 和 'b' 。


from typing import List

# 将字符串s以二进制集合表示
def solve(s: str) -> int:
    mask = 0
    for c in s:
        mask |= 1 << (ord(c) - ord('a'))
    return mask

class Solution:
    def countConsistentStrings(self, allowed: str, words: List[str]) -> int:
        s1 = solve(allowed)
        cnt = 0
        for w in words:
            s2 = solve(w)
            # 求个并集，如果还是等于s1，说明w和allowed是一致的
            if (s1 | s2) == s1:
                cnt += 1
        return cnt

if __name__ == '__main__':
    print("ok")

