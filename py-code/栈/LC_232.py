

# 232. 用栈实现队列
# 已解答
# 简单
# 相关标签
# 相关企业
# 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：

# 实现 MyQueue 类：

# void push(int x) 将元素 x 推到队列的末尾
# int pop() 从队列的开头移除并返回元素
# int peek() 返回队列开头的元素
# boolean empty() 如果队列为空，返回 true ；否则，返回 false
# 说明：

# 你 只能 使用标准的栈操作 —— 也就是只有 push to top, peek/pop from top, size, 和 is empty 操作是合法的。
# 你所使用



class MyQueue:

    def __init__(self):
        self.a = []
        self.b = []


    def push(self, x: int) -> None:
        self.a.append(x)

    def pop(self) -> int:
        if len(self.b): return self.b.pop()
        while len(self.a):
            self.b.append(self.a.pop())
        return self.b.pop()

    def peek(self) -> int:
        if len(self.b): return self.b[-1]
        while len(self.a):
            self.b.append(self.a.pop())
        return self.b[-1]


    def empty(self) -> bool:
        return not self.a and not self.b



# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()

