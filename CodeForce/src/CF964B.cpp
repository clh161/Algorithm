#include <iostream>

using namespace std;


int main() {
    int n, a, b, c, t;
    cin >> n >> a >> b >> c >> t;
    int time[n];
    for (int i = 0; i < n; ++i) {
        cin >> time[i];
    }
    int total = a * n;
    if (c > b) {
        for (int i = 0; i < n; ++i) {
            total += (t - time[i]) * (c - b);
        }
    }
    cout << total;

    return 0;
}
