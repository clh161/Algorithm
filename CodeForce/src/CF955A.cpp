#include <iostream>
#include <cmath>


using namespace std;

double solve(int h, int m, int hunger, int increaseRate, int cost, int decreaseRate);

int main() {
    int h, m, hunger, increaseRate, cost, decreaseRate;
    cin >> h >> m >> hunger >> increaseRate >> cost >> decreaseRate;
    printf("%.4f", solve(h, m, hunger, increaseRate, cost, decreaseRate));
    return 0;
}

double solve(int h, int m, int hunger, int increaseRate, int cost, int decreaseRate) {
    double cost1 = ceil(((double) max(1200 - h * 60 - m, 0) * increaseRate + hunger) / decreaseRate) * cost * 0.8;
    double cost2 = ceil((double) hunger / decreaseRate) * cost;
    return min(cost1, cost2);
}