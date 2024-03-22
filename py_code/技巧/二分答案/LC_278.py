# 278. 第一个错误的版本
# 简单
# 976
# 相关企业
# 你是产品经理，目前正在带领一个团队开发新的产品。不幸的是，你的产品的最新版本没有通过质量检测。由于每个版本都是基于之前的版本开发的，所以错误的版本之后的所有版本都是错的。
#
# 假设你有 n 个版本 [1, 2, ..., n]，你想找出导致之后所有版本出错的第一个错误的版本。
#
# 你可以通过调用 bool isBadVersion(version) 接口来判断版本号 version 是否在单元测试中出错。实现一个函数来查找第一个错误的版本。你应该尽量减少对调用 API 的次数。


# The isBadVersion API is already defined for you.
# def isBadVersion(version: int) -> bool:

class Solution:
    def firstBadVersion(self, n: int) -> int:
        l, r = 0, n
        while l < r:
            mid = l + r >> 1
            # if isBadVersion(mid) == False:
            #     l = mid + 1
            # else:
            #     r = mid
        return l


if __name__ == '__main__':
    print("Ok")