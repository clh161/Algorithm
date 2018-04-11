#include <iostream>

using namespace std;

string solve(string str);

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int n, k;
    cin >> n >> k;
    int max = 0;
    int total = 0;
    int l[n];
    int awake[n];
    for (int i = 0; i < n; ++i) {
        cin >> l[i];
    }
    for (int i = 0; i < n; ++i) {
        cin >> awake[i];
    }
    int count = 0;
    for (int i = 0; i < k && i < n; ++i) {
        if (awake[i] == 0) count += l[i];
    }
    for (int i = 0; i < n; ++i) {
        if (awake[i] == 1) total += l[i];
        if (i > 0 && i + k - 1 < n) {
            if (awake[i - 1] == 0) count -= l[i - 1];
            if (awake[i + k - 1] == 0) count += l[i + k - 1];
        }
        if (max < count) max = count;
    }
    cout << max + total;
    return 0;
}


