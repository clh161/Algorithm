#include <iostream>

using namespace std;

string solve(string pancakes, int flips);

int main() {
    int t;
    cin >> t;
    for (int i = 1; i <= t; ++i) {
        string pancakes;
        int flips;
        cin >> pancakes >> flips;
        cout << "Case #" << i << ": " << solve(pancakes, flips) << "\n";
    }
    return 0;
}

string solve(string pancakes, int flips) {
    int flipCount = 0;
    for (int i = 0; i < pancakes.length() - flips + 1; ++i) {
        if (pancakes.at(i) == '-') {
            flipCount++;
            for (int j = 0; j < flips; ++j) {
                pancakes.at(j + i) = pancakes.at(j + i) == '-' ? '+' : '-';
            }
        }
    }
    for (int k = 0; k < pancakes.length(); ++k) {
        if (pancakes.at(k) == '-')
            return "IMPOSSIBLE";
    }
    return to_string(flipCount);
}