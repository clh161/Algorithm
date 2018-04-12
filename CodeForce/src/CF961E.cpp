#include <iostream>
#include <vector>

using namespace std;
vector<int> tree[200001];
int s[200001];
int n;

void add(int i, int val);

int getSum(int i, int min);

int main() {
    cin >> n;
    for (int i = 1; i <= n; ++i) {
        int e;
        cin >> e;
        e = min(e, n);
        s[i] = e;
        add(i, e);
    }
    long long sum = 0;
    for (int i = 1; i <= n; ++i) {
        sort(tree[i].begin(), tree[i].end());
    }
    for (int i = 1; i <= n; ++i) {
        if (s[i] <= i) continue;
        sum += getSum(s[i], i) - getSum(i, i);
    }
    cout << sum;
    return 0;
}

void add(int i, int val) {
    while (i < n + 1) {
        tree[i].push_back(val);
        i += i & (-i);
    }
}

int getSum(int i, int min) {
    int sum = 0;
    while (i > 0) {
        sum += tree[i].size() - (lower_bound(tree[i].begin(), tree[i].end(), min) -
                                 tree[i].begin());
        i -= i & (-i);
    }
    return sum;
}