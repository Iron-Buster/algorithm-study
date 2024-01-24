# 461. 汉明距离
# 简单
# 717
# 相关企业
# 两个整数之间的 汉明距离 指的是这两个数字对应二进制位不同的位置的数目。
#
# 给你两个整数 x 和 y，计算并返回它们之间的汉明距离。

def lowbit(x: int) -> int:
    return x & -x

class Solution:
    # 方法1：枚举二进制每一位 时间复杂度为O(32)
    def hammingDistance(self, x: int, y: int) -> int:
        return sum((x >> i) & 1 ^ (y >> i) & 1 for i in range(32, -1, -1))

    # 方法2：右移统计
    def hammingDistance2(self, x: int, y: int) -> int:
        cnt = 0
        while x | y:
            a = x & 1
            b = y & 1
            cnt += a ^ b
            x >>= 1
            y >>= 1
        return cnt

    # 方法3：lowbit
    def hammingDistance3(self, x: int, y: int) -> int:
        cnt = 0
        i = x ^ y
        # 将x和y xor后，lowbit快速计算二进制中1的个数
        while i:
            i -= lowbit(i)
            cnt += 1
        return cnt



if __name__ == '__main__':
    print("ok")