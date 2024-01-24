# 1534. 统计好三元组
# 提示
# 1279
# 66
# 第 200 场周赛
# Q1
# 相关企业
# 给你一个整数数组 arr ，以及 a、b 、c 三个整数。请你统计其中好三元组的数量。
#
# 如果三元组 (arr[i], arr[j], arr[k]) 满足下列全部条件，则认为它是一个 好三元组 。
#
# 0 <= i < j < k < arr.length
# |arr[i] - arr[j]| <= a
# |arr[j] - arr[k]| <= b
# |arr[i] - arr[k]| <= c
# 其中 |x| 表示 x 的绝对值。
#
# 返回 好三元组的数量 。


from typing import List

class Solution:
    def countGoodTriplets(self, arr: List[int], a: int, b: int, c: int) -> int:
        # TODO 待优化
        n = len(arr)
        res = 0
        for i in range(n):
            for j in range(i + 1, n):
                for k in range(j + 1, n):
                    if abs(arr[i] - arr[j]) <= a and abs(arr[j] - arr[k]) <= b and abs(arr[i] - arr[k]) <= c:
                        res += 1
        return res

if __name__ == '__main__':
    print("ok")