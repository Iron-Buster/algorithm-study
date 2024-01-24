# 788. 旋转数字
# 1397
# 202
# 第 73 场周赛
# Q1
# 相关企业
# 我们称一个数 X 为好数, 如果它的每位数字逐个地被旋转 180 度后，我们仍可以得到一个有效的，且和 X 不同的数。要求每位数字都要被旋转。
#
# 如果一个数的每位数字被旋转以后仍然还是一个数字， 则这个数是有效的。0, 1, 和 8 被旋转后仍然是它们自己；2 和 5 可以互相旋转成对方（在这种情况下，它们以不同的方向旋转，换句话说，2 和 5 互为镜像）；6 和 9
# 同理，除了这些以外其他的数字旋转以后都不再是有效的数字。
#
# 现在我们有一个正整数 N, 计算从 1 到 N 中有多少个数 X 是好数？


# 数位中包含 2 5 6 9 的数字一定是好数
# 好数中不能包含 3 4 7

from functools import cache

DIFFS = (0, 0, 1, -1, -1, 1, 1, -1, 0, 1)


class Solution:

    def rotatedDigits(self, n: int) -> int:
        s = str(n)
        @cache
        def dfs(i: int, isLimit: bool, hasDiff: bool):
            if i == len(s):
                return 1 if hasDiff else 0
            ans = 0
            up = int(s[i]) if isLimit else 9
            for d in range(up + 1):
                if DIFFS[d] != -1:
                    ans += dfs(i + 1, isLimit and d == up, hasDiff or DIFFS[d] == 1)
            return ans

        return dfs(0, True, False)


if __name__ == '__main__':
    print("ok")
