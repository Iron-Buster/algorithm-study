# 1359. 有效的快递序列数目
# 提示
# 1723
# 57
# 第 20 场双周赛
# Q4
# 相关企业
# 给你 n 笔订单，每笔订单都需要快递服务。
#
# 请你统计所有有效的 收件/配送 序列的数目，确保第 i 个物品的配送服务 delivery(i) 总是在其收件服务 pickup(i) 之后。
#
# 由于答案可能很大，请返回答案对 10^9 + 7 取余的结果。
from math import factorial


class Solution:
    def countOrders(self, n: int) -> int:
        MOD = 10 ** 9 + 7
        # 求逆元
        # 不考虑限制的方案数量是 (2n)!
        # 考虑限制的方案数量是    2^n
        return factorial(2 * n) * pow(2 ** n, -1, MOD) % MOD  # 费马小定理


if __name__ == '__main__':

    print("ok")