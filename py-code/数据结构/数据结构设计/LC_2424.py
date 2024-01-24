# 2424. 最长上传前缀
# 已解答
# 第 88 场双周赛
# Q2
# 1604
# 相关标签
# 相关企业
# 提示
# 给你一个 n 个视频的上传序列，每个视频编号为 1 到 n 之间的 不同 数字，你需要依次将这些视频上传到服务器。请你实现一个数据结构，在上传的过程中计算 最长上传前缀 。

# 如果 闭区间 1 到 i 之间的视频全部都已经被上传到服务器，那么我们称 i 是上传前缀。最长上传前缀指的是符合定义的 i 中的 最大值 。

# 请你实现 LUPrefix 类：

# LUPrefix(int n) 初始化一个 n 个视频的流对象。
# void upload(int video) 上传 video 到服务器。
# int longest() 返回上述定义的 最长上传前缀 的长度

class LUPrefix:

    # 最长不会减小 用一个maxIndex维护最长前缀
    def __init__(self, n: int):
        self.index = 1
        self.vis = set()


    def upload(self, video: int) -> None:
        self.vis.add(video)


    def longest(self) -> int:
        while self.index in self.vis:   # 更新最长前缀
            self.index += 1     
        return self.index - 1


# Your LUPrefix object will be instantiated and called as such:
# obj = LUPrefix(n)
# obj.upload(video)
# param_2 = obj.longest()