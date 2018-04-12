#include <iostream>
#include <vector>


using namespace std;
vector<pair<double, double>> ps;

bool check(int a, int b);

bool check(pair<double, double> a, pair<double, double> b, pair<double, double> c);

int main() {
    int n;
    cin >> n;
    if (n < 5) {
        cout << "YES";
        return 0;
    }
    for (int i = 0; i < n; ++i) {
        pair<double, double> p;
        cin >> p.first >> p.second;
        ps.push_back(p);
    }
    if (check(0, 1) || check(0, 2) || check(1, 2)) {
        cout << "YES";
    } else {
        cout << "NO";
    }

    return 0;
}

bool check(int a, int b) {
    vector<pair<double, double>> ex;
    for (int i = 0; i < ps.size(); ++i)
        if (a != i && b != i && !check(ps[a], ps[b], ps[i])) ex.push_back(ps[i]);
    for (int i = 2; i < ex.size(); ++i)
        if (!check(ex[0], ex[1], ex[i]))
            return false;
    return true;
}

bool check(pair<double, double> a, pair<double, double> b, pair<double, double> c) {
    return (a.first - b.first) * (a.second - c.second) == (a.first - c.first) * (a.second - b.second);
}