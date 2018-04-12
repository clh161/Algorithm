#include <iostream>


using namespace std;

int main() {
    int n, m;
    cin >> n >> m;
    int s[n];
    for (int i = 0; i < n; ++i) {
        s[i] = 0;
    }
    for (int i = 0; i < m; ++i) {
        int l;
        cin >> l;
        s[l - 1]++;
    }
    int min = 1000;
    for (int i = 0; i < n; ++i) {
        if (min > s[i])
            min = s[i];
    }
    cout << min;

    return 0;
}
