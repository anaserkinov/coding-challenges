#include <iostream>
#include <vector>

using namespace std;

class Solution {
 public:
  int maxProfit(vector<int>& prices) {
    int bought = 0;
    int sold = 1;
    int result = 0;
    int size = prices.size();

    while (sold < size) {
      int p = prices[sold] - prices[bought];
      if (p < 0){
        bought++;
        sold = bought;
      } else if (p > result) 
        result = p;

      sold++;
    }

    return result;
  }
};

int main() {
  int size;
  vector<int> input;
  cout << "Size: ";
  cin >> size;

  for (size_t i = 0; i < size; i++) {
    int o;
    cin >> o;
    input.push_back(o);
  }

  Solution s;

  cout << endl << s.maxProfit(input) << endl;

  return 0;
}