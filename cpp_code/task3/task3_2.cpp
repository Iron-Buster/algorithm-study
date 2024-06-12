#include<bits/stdc++.h>
using namespace std;


const int N = 1e6 + 5;

// 2、求解乘船问题。有n个人，第i个人的体重为wi。每艘船的
// 最大载重量均为C，且最多能乘坐2人。试用最少的船装载所
// 有人。

void solve() {
    int n, c;
    cin >> n >> c;
    vector<int> w(n + 1);
    for (int i = 1; i <= n; i++) {
        cin >> w[i];
    }
    // 将体重从小到大排序
    sort(w.begin(), w.end());
    // 然后双指针枚举，由于一艘船最多坐2人，所有一个比较轻的和一个比较重的搭配在一起是比较优的方案
    int i = 1, j = n;
    int res = 0;
    while (i <= j) {
        if (i == j) {
            res += 1;
            break;
        }
        if (w[i] + w[j] <= c) { // 能够坐1艘船
            res += 1;
            i++;
            j--;
        } else {
            res += 1;           // 重的人单独坐1艘船
            j--;
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