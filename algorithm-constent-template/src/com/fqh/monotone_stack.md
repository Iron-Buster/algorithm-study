**单调栈求最后一个比它大的元素**
**0x3f**
```text
1.倒着遍历维护max的下标
2.维护一个从左到右递减的栈，然后在栈上面二分，这个栈没有pop只有push
```
