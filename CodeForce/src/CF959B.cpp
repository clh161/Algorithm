#include <iostream>
#include <unordered_map>

using namespace std;

int main() {
    int n, k, m;
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> n >> k >> m;
    unordered_map<string, int> strings;
    for (int i = 0; i < n; ++i) {
        string s;
        cin >> s;
        strings[s] = i;
    }
    int costs[n];
    for (int j = 0; j < n; ++j) {
        int cost;
        cin >> cost;
        costs[j] = cost;
    }
    for (int l = 0; l < k; ++l) {
        int count;
        cin >> count;
        if (count == 1) {
            cin >> count;
            continue;
        }
        int indices[count];
        int min = (int) 1e9;
        for (int i = 0; i < count; ++i) {
            int index;
            cin >> index;
            index--;
            indices[i] = index;
            if (costs[index] < min) min = costs[index];
        }
        for (int j = 0; j < count && count != 1; ++j) {
            costs[indices[j]] = min;
        }
    }
    long long total = 0;
    for (int o = 0; o < m; ++o) {
        string s;
        cin >> s;
        total += costs[strings[s]];
    }
    cout << total;
    return 0;
}
