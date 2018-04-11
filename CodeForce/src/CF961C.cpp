#include <iostream>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int n;
    cin >> n;
    int toWhite[4];
    int toBlack[4];

    for (int i = 0; i < 4; ++i) {
        toWhite[i] = 0;
        toBlack[i] = 0;
        for (int j = 0; j < n; ++j) {
            string s;
            cin >> s;
            for (int k = 0; k < n; ++k) {
                if ((j * n + k) % 2 == s[k] - '0') {
                    toBlack[i]++;
                } else {
                    toWhite[i]++;
                }
            }
        }
    }
    int min = n * n * 4;
    int sumBlack = 0;
    for (int i = 0; i < 4; ++i) {
        sumBlack += toBlack[i];
    }
    for (int i = 0; i < 4; ++i) {
        for (int j = i + 1; j < 4; ++j) {
            int sum = sumBlack - toBlack[i] + toWhite[i] - toBlack[j] + toWhite[j];
            if (sum < min) min = sum;
        }
    }
    cout << min;
    return 0;
}


