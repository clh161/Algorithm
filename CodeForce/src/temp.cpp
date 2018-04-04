#include <cmath>
#include <vector>
#include <iostream>

using namespace std;


int main() {
    int t;
    cin >> t;
    while (t > 0) {
        string s1, s2;
        cin >> s1 >> s2;
        int i = 0;
        int j = 0;
        while (i < s1.length() || j < s2.length()) {
            int k;
            int count = 1;
            if (j == s2.length()) {
                k = 0;
            } else if (i == s1.length()) {
                k = 1;
            } else if (s1[i] < s2[j]) {
                k = 0;
            } else if (s1[i] > s2[j]) {
                k = 1;
            } else {
                char c = s1[i];
                int m = 1;
                while (i + m < s1.length() && j + m < s2.length()) {
                    if (s1[i + m] == c && s2[j + m] == c) {
                        if (i + m >= s1.length() - 1) {
                            k = 1;
                            break;
                        } else if (j + m >= s2.length() - 1) {
                            k = 0;
                            break;
                        } else {
                            count += m;
                            m++;
                            continue;
                        }
                    } else if (i + m >= s1.length() - 1) {
                        k = 1;
                        break;
                    } else if (j + m >= s2.length() - 1) {
                        k = 0;
                        break;
                    } else if (s1[i + m] == s2[j + m]) {
                        break;
                    } else if (s1[i + m] < s2[j + m]) {
                        k = 0;
                        break;
                    } else if (s1[i + m] > s2[j + m]) {
                        k = 1;
                        break;
                    }
                }
            }
            while (count > 0) {
                cout << (k == 0 ? s1[i++] : s2[j++]);
                count--;
            }
        }
        cout << endl;
        t--;
    }
    return 0;
}
