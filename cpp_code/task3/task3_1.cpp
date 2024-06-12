#include<bits/stdc++.h>
using namespace std;


const int N = 1e6 + 5;

// 【实验题目1】请使用贪心算法法解决下列问题
// 1、假设要在足够多会场里安排一批活动，n个活动编号为1~n，
// 每个活动有开始时间bi和结束时间ei（1<=i<=n）。设计一个
// 有效的贪心算法求出最少的会场个数


void solve() {
    int n;
    cin >> n;
    vector<pair<int, int>> a(n + 1);
    for (int i = 1; i <= n; i++) {
        cin >> a[i].first;
    }
    for (int i = 1; i <= n; i++) {
        cin >> a[i].second;
    }

    // 按照开始时间排序
    sort(a.begin(), a.end(), [](const pair<int, int>& x, const pair<int, int>& y) {
        return x.first < y.first;
    });

    int last = a[1].second; // 上一个活动的结束时间
    int res = 1;
    for (int i = 2; i <= n; i++) {
        if (last > a[i].first) {    // 这里端点重合也视为不相交，如果要求视为相交 将 > 改为 >= 即可.
            res += 1; // 使用1个会场（区间有交集）
            last = a[i].second;
        } else {
            last = max(last, a[i].second);
        }
    }
    cout << res << endl;
}
int main() {
	ios::sync_with_stdio(false);
  	cin.tie(0);
  	cout.tie(0);
	solve();
	return 0;
}