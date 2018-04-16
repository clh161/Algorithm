#include <iostream>
#include <unordered_map>

using namespace std;

bool solve(string s);

int main() {
    string s;
    cin >> s;
    cout << (solve(s) ? "YES" : "NO");
    return 0;
}

bool solve(string s) {
    if (s.size() < 4) return false;
    unordered_map<char, int> chars;
    for (int i = 0; i < s.size(); ++i) {
        if (chars.find(s[i]) == chars.end()) {
            chars.insert({s[i], 1});
            if (chars.size() > 4) return false;
        } else {
            chars[s[i]]++;
        }
    }
    if (chars.size() < 2) return false;
    else if (chars.size() == 2) {
        for (pair<char, int> p: chars)
            if (p.second < 2) return false;
        return true;
    } else if (chars.size() == 3) {
        for (pair<char, int> p: chars)
            if (p.second > 1) return true;
        return false;
    }


    return true;
}
