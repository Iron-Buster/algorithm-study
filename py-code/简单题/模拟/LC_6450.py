
# 6450. k-avoiding 数组的最小总和
# 提示
# 中等
# 1
# 相关企业
# 给你两个整数 n 和 k 。
#
# 对于一个由 不同 正整数组成的数组，如果其中不存在任何求和等于 k 的不同元素对，则称其为 k-avoiding 数组。
#
# 返回长度为 n 的 k-avoiding 数组的可能的最小总和。





class Solution:
    def minimumSum(self, n: int, k: int) -> int:
        vis = set()
        res = 0
        i = 1
        while n:
            if (k - i) in vis:
                for nx in range(k - i + 1, 51):
                    if (k - nx) not in vis:
                        i = nx
                        break
            res += i
            vis.add(i)
            i += 1
            n -= 1
        return res

if __name__ == '__main__':
    print("ok")