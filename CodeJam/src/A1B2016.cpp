#include <iostream>
#include <vector>
#include <unordered_set>

using namespace std;

int main() {
    int t;
    cin >> t;
    for (int l = 1; l <= t; ++l) {
        int n;
        cin >> n;
        unordered_set<int> s;
        for (int i = 0; i < (n * 2 - 1) * n; ++i) {
            int h;
            cin >> h;
            if (s.find(h) == s.end())
                s.insert(h);
            else s.erase(h);
        }
        vector<int> v;
        for (int h : s)
            v.push_back(h);
        sort(begin(v), end(v), [](const int &a, const int &b) {
            return a < b;
        });
        if (v.size() != n) throw;
        cout << "Case #" << l << ": ";
        for (int h:v)
            cout << h << " ";
        cout << endl;
    }

    return 0;
}