#include <iostream>


using namespace std;

string solve(string str);

int main() {
    string str;
    cin >> str;
    cout << str;
    int len = str.length();
    for (int i = len - 2; i >= 0; i--)
        cout << str[i];
    return 0;
}
