#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int n;
    string s;
    cin >> n >> s;
    if (s == "0") {
        cout << "0";
        return 0;
    }
    string ans = "1";
    int count = 0;
    for (int i = 0; i < n; ++i) {
        if (s[i] == '0') count++;
    }
    for (int j = 0; j < count; ++j) {
        ans += '0';
    }
    cout << ans;
    return 0;
}
