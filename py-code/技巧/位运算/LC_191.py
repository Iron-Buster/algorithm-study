
# 191. 位1的个数
# 简单
# 602
# 相关企业
# 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量）




class Solution:
    def hammingWeight(self, n: int) -> int:
        # n & (n - 1) 可以消除二进制最后一个1，当n等于0说明没有1可以消除了
        cnt = 0
        while n:
            cnt += 1
            n = n & (n - 1)
        return cnt

        # return sum(1 for i in range(33) if n >> i & 1 == 1)


if __name__ == '__main__':

    print("ok")
