#include <iostream>
#include <vector>
#include <queue>

#define ll long long
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int n, m;
    cin >> n >> m;
    vector<pair<int, ll>> routes[n];
    for (int i = 0; i < m; i++) {
        ll a, b, fee;
        cin >> a >> b >> fee;
        fee *= 2;
        a--;
        b--;
        vector<pair<int, ll>> &v = routes[a];
        v.emplace_back(b, fee);
        vector<pair<int, ll>> &v2 = routes[b];
        v2.emplace_back(a, fee);
    }
    ll prices[n];
    for (int j = 0; j < n; ++j)
        cin >> prices[j];
    priority_queue<ll, vector<ll>, greater<> > queue;
    for (int k = 0; k < n; ++k)
        queue.push(prices[k] * n + k);
    while (!queue.empty()) {
        ll price = queue.top() / n;
        int from = (int) (queue.top() % n);
        queue.pop();
        if (price <= prices[from]) {
            for (pair<int, ll> route :routes[from]) {
                int to = route.first;
                ll fee = route.second;
                ll total = fee + prices[from];
                if (total < prices[to]) {
                    prices[to] = total;
                    queue.push(total * n + to);
                }
            }
        }

    }
    for (int l = 0; l < n; ++l) {
        cout << prices[l] << " ";
    }
    return 0;
}