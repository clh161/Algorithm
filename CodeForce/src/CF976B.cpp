#include <iostream>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    long long n, m, k;
    cin >> n >> m >> k;
    if (k < n) {
        cout << k + 1 << ' ' << 1;
        return 0;
    }
    k -= n;
    long long row = n - k / (m - 1);
    long long col = 0;
    if (row % 2 == 0) {
        col = 2 + k % (m - 1);
    } else {
        col = m - k % (m - 1);
    }
    cout << row << ' ' << col;
    return 0;
}
