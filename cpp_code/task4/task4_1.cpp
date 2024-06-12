#include<bits/stdc++.h>
using namespace std;


const int N = 1e6 + 5;

// 【实验题目1】请使用回溯法解决下列问题
// 1、给定若干个正整数a0
// ,a2
// ,……,an-1，
// 从中选择若干个数，使它
// 们的和正好等于k。

void solve() {
    int n, k;
    cin >> n >> k;
    vector<int> nums(n + 1);
    for (int i = 1; i <= n; i++) {
        cin >> nums[i];
    }
    
    

}
int main() {
	ios::sync_with_stdio(false);
  	cin.tie(0);
  	cout.tie(0);
	solve();
	return 0;
}