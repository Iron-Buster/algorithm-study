#include<bits/stdc++.h>
using namespace std;


const int N = 1e6 + 5;

// 会议安排问题:一个会议室某一时刻只能安排一个会议，现有n
// 个会议申请，每个会议给出开始时间和结束时间，请给出该会议室
// 兼容会议持续时间最长的会议安排方案——即使用会议室时间最长的
// 会议安排方案。（下表中的数据已经按照结束时间排序）

// TODO 
void solve() {
    int n;
    cin >> n;
    vector<int> a(n + 1);
    vector<int> b(n + 1);
    for (int i = 1; i <= n; i++) {
        cin >> a[i];
    }
    for (int i = 1; i <= n; i++) {
        cin >> b[i];
    }
        
    cout << n << endl;
}
int main() {
	ios::sync_with_stdio(false);
  	cin.tie(0);
  	cout.tie(0);
	solve();
	return 0;
}