# 1109. 航班预订统计
# 1570
# 475
# 第 144 场周赛
# Q2
# 相关企业
# 这里有 n 个航班，它们分别从 1 到 n 进行编号。
#
# 有一份航班预订表 bookings ，表中第 i 条预订记录 bookings[i] = [firsti, lasti, seatsi] 意味着在从 firsti 到 lasti （包含 firsti 和 lasti ）的 每个航班 上预订了 seatsi 个座位。
#
# 请你返回一个长度为 n 的数组 answer，里面的元素是每个航班预定的座位总数。
from typing import List


class Solution:
    def corpFlightBookings(self, bookings: List[List[int]], n: int) -> List[int]:
        diff = [0] * n  # 差分数组
        for left, right, seat in bookings:
            diff[left - 1] += seat
            if right < n:
                diff[right] -= seat
        for i in range(1, n):
            diff[i] += diff[i - 1]  # 差分的前缀和 复原数组 a
        return diff


if __name__ == '__main__':
    print("ok")