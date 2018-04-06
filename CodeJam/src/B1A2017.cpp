#include <iostream>

using namespace std;

int main() {
    int t;
    cin >> t;
    for (int l = 1; l <= t; ++l) {
        double d, n;
        cin >> d >> n;
        double maxTime = 0;
        for (int i = 0; i < n; ++i) {
            double position, speed;
            cin >> position >> speed;
            double time = (d - position) / speed;
            if (time > maxTime) maxTime = time;
        }

        cout << "Case #" << l << ": ";
        printf("%.6f", d / maxTime);
        cout << endl;
    }

    return 0;
}