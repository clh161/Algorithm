#include <iostream>
#include <array>
#include <vector>

using namespace std;


string getString(string s, vector<int> unicorns, int total, int last, int first);

bool valid(int a, int b);

char colors[]{'R', 'O', 'Y', 'G', 'B', 'V'};

int main() {
    int t;
    cin >> t;
    for (int l = 1; l <= t; ++l) {
        int total;
        cin >> total;
        vector<int> unicorns;
        for (int j = 0; j < 6; ++j) {
            int n;
            cin >> n;
            unicorns.push_back(n);
        }
        string ans = getString("", unicorns, total, -1, 0);
        cout << "Case #" << l << ": " << ans << endl;
    }

    return 0;
}

string getString(string s, vector<int> unicorns, int total, int last, int first) {
    if (total == 0) {
        if (valid(first, last))
            return s;
    }
    if (total > 6) {
        int biggest = 0;
        int index = 0;
        for (int j = 0; j < 6; ++j) {
            if (valid(last, j) && unicorns[j] > biggest) {
                biggest = unicorns[j];
                index = j;
            }
        }
        if (unicorns[index] <= 0)
            return "IMPOSSIBLE";
        vector<int> unicorns2(unicorns);
        unicorns2[index] = unicorns2[index] - 1;
        return getString(s + colors[index], unicorns2, total - 1, index, last == -1 ? index : first);
    } else {
        for (int i = 0; i < 6; ++i) {
            if (valid(last, i) && unicorns[i] != 0) {
                vector<int> unicorns2(unicorns);
                unicorns2[i] = unicorns2[i] - 1;
                string ans = getString(s + colors[i], unicorns2, total - 1, i, last == -1 ? i : first);
                if (ans != ("IMPOSSIBLE"))
                    return ans;
            }
        }

    }
    return "IMPOSSIBLE";
}


bool valid(int a, int b) {
    if (a == -1) return true;
    switch (a) {
        case 0:
            return b == 2 || b == 4 || b == 3;
        case 2:
            return b == 0 || b == 4 || b == 5;
        case 4:
            return b == 0 || b == 2 || b == 1;
        case 1:
            return b == 4;
        case 3:
            return b == 0;
        case 5:
            return b == 2;
    }
    return false;
}
//
//1
//41 20 0 8 0 13 0
