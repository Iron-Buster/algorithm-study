package main

import "fmt"

// 2865. 美丽塔 I
// 已解答
// 第 364 场周赛
// Q2
// 1519
// 相关标签
// 相关企业
// 提示
// 给你一个长度为 n 下标从 0 开始的整数数组 maxHeights 。
//
// 你的任务是在坐标轴上建 n 座塔。第 i 座塔的下标为 i ，高度为 heights[i] 。
//
// 如果以下条件满足，我们称这些塔是 美丽 的：
//
// 1 <= heights[i] <= maxHeights[i]
// heights 是一个 山脉 数组。
// 如果存在下标 i 满足以下条件，那么我们称数组 heights 是一个 山脉 数组：
//
// 对于所有 0 < j <= i ，都有 heights[j - 1] <= heights[j]
// 对于所有 i <= k < n - 1 ，都有 heights[k + 1] <= heights[k]
// 请你返回满足 美丽塔 要求的方案中，高度和的最大值 。

//输入：maxHeights = [5,3,4,1,1]
//输出：13
//解释：和最大的美丽塔方案为 heights = [5,3,3,1,1] ，这是一个美丽塔方案，因为：
//- 1 <= heights[i] <= maxHeights[i]
//- heights 是个山脉数组，峰值在 i = 0 处。
//13 是所有美丽塔方案中的最大高度和。

func maximumSumOfHeights(h []int) (ans int64) {
	n := len(h)
	left := make([]int, n+1)
	right := make([]int, n+1)
	stk := []int{-1}
	for i := 0; i < n; i++ {
		for len(stk) > 1 && h[stk[len(stk)-1]] > h[i] {
			stk = stk[:len(stk)-1]
		}
		left[i] = stk[len(stk)-1]
		stk = append(stk, i)
	}
	stk = []int{n}
	for i := n - 1; i >= 0; i-- {
		for len(stk) > 1 && h[stk[len(stk)-1]] > h[i] {
			stk = stk[:len(stk)-1]
		}
		right[i] = stk[len(stk)-1]
		stk = append(stk, i)
	}
	a := make([]int64, n)
	b := make([]int64, n)
	a[0] = int64(h[0])
	for i := 1; i < n; i++ {
		l := left[i]
		a[i] = int64((i - l) * h[i])
		if l != -1 {
			a[i] += a[left[i]]
		}
	}
	b[n-1] = int64(h[n-1])
	for i := n - 2; i >= 0; i-- {
		r := right[i]
		b[i] = int64((r - i) * h[i])
		if r != n {
			b[i] += b[right[i]]
		}
	}
	for i, x := range h {
		ans = max(ans, a[i]+b[i]-int64(x))
	}
	return ans
}

func main() {
	h := []int{5, 3, 4, 1, 1}
	fmt.Println(maximumSumOfHeights(h))
}
