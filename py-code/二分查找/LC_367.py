# 367. 有效的完全平方数
# 简单
# 527
# 相关企业
# 给你一个正整数 num 。如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
#
# 完全平方数 是一个可以写成某个整数的平方的整数。换句话说，它可以写成某个整数和自身的乘积。
#
# 不能使用任何内置的库函数，如  sqrt 。



class Solution:
    def isPerfectSquare(self, num: int) -> bool:
        l, r = 1, num
        while l <= r:
            mid = l + r >> 1
            if mid * mid < num:
                l = mid + 1
            elif mid * mid > num:
                r = mid - 1
            else:
                return True
        return False

if __name__ == '__main__':
    res = Solution().isPerfectSquare(14)
    print(res)