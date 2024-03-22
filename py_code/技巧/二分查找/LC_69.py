
# 69. x 的平方根
# 提示
# 简单
# 1.4K
# 相关企业
# 给你一个非负整数 x ，计算并返回 x 的 算术平方根 。
#
# 由于返回类型是整数，结果只保留 整数部分 ，小数部分将被 舍去 。
#
# 注意：不允许使用任何内置指数函数和算符，例如 pow(x, 0.5) 或者 x ** 0.5 。

class Solution:
    def mySqrt(self, x: int) -> int:
        if x == 0 or x == 1:
            return x
        l, r = 0, x
        while l < r:
            mid = l + r >> 1
            if mid * mid <= x:
                l = mid + 1
            else:
                r = mid
        return l - 1

if __name__ == '__main__':

    print("ok")
