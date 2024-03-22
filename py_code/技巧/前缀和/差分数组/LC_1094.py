from typing import List


# 1094. 拼车
# 提示
# 1441
# 268
# 第 142 场周赛
# Q2
# 相关企业
# 车上最初有 capacity 个空座位。车 只能 向一个方向行驶（也就是说，不允许掉头或改变方向）
#
# 给定整数 capacity 和一个数组 trips ,  trip[i] = [numPassengersi, fromi, toi] 表示第 i 次旅行有 numPassengersi 乘客，接他们和放他们的位置分别是 fromi 和 toi 。这些位置是从汽车的初始位置向东的公里数。
#
# 当且仅当你可以在所有给定的行程中接送所有乘客时，返回 true，否则请返回 false。




class Solution:
    def carPooling(self, trips: List[List[int]], capacity: int) -> bool:
        diff = [0] * 1001  # 差分数组
        for num, left, right in trips:
            diff[left] += num
            diff[right] -= num
        for i in range(0, 1001):
            diff[i] += diff[i - 1]  # 差分的前缀和 复原数组 a
            if diff[i] > capacity:
                return False
        return True

if __name__ == '__main__':
    print("ok")