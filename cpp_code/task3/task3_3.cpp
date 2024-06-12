#include<bits/stdc++.h>
using namespace std;


const int N = 1e6 + 5;

// 1、求解一个序列中出现次数最多的元素
// 【问题描述】给定n个正整数，编写程序找出它们中出现次数
// 最多的数，如果这样的数有多个，输出其中最小的数。

void solve() {
    int n;
    cin >> n;
    vector<int> nums(n + 1);
    for (int i = 1; i <= n; i++) {
        cin >> nums[i];
    }
    int v = nums[1];
    int cnt = 1;
    // 使用摩尔投票法
    for (int i = 1; i <= n; i++) {
        if (nums[i] != v) {
            cnt -= 1;
            if (cnt == 0) {
                v = nums[i];
                cnt = 1;
            }
        } else {
            cnt += 1;
        }
    }
    cout << v << endl;


}
int main() {
	ios::sync_with_stdio(false);
  	cin.tie(0);
  	cout.tie(0);
	solve();
	return 0;
}