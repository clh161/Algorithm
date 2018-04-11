#include <iostream>

using namespace std;

string solve(string str);

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
    int max = n * n * 4;
    if (toWhite[0] + toWhite[1] + toBlack[2] + toBlack[3] < max)
        max = toWhite[0] + toWhite[1] + toBlack[2] + toBlack[3];
    if (toBlack[0] + toWhite[1] + toWhite[2] + toBlack[3] < max)
        max = toBlack[0] + toWhite[1] + toWhite[2] + toBlack[3];
    if (toBlack[0] + toBlack[1] + toWhite[2] + toWhite[3] < max)
        max = toBlack[0] + toBlack[1] + toWhite[2] + toWhite[3];
    if (toWhite[0] + toBlack[1] + toBlack[2] + toWhite[3] < max)
        max = toWhite[0] + toBlack[1] + toBlack[2] + toWhite[3];
    if (toWhite[0] + toBlack[1] + toWhite[2] + toBlack[3] < max)
        max = toWhite[0] + toBlack[1] + toWhite[2] + toBlack[3];
    if (toBlack[0] + toWhite[1] + toBlack[2] + toWhite[3] < max)
        max = toBlack[0] + toWhite[1] + toBlack[2] + toWhite[3];
    cout << max;
    return 0;
}


