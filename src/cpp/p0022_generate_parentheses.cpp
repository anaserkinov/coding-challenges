#include <iostream>
#include <vector>

using namespace std;

class Solution {
 public:
  vector<string> generateParenthesis(int n) {
    vector<string> result;
    if (n == 0)
      result.push_back("");
    else
      for (size_t i = 0; i < n; i++) {
        vector<string> lefts = generateParenthesis(i);
         size_t sizeL = lefts.size();
        for (size_t j = 0; j < sizeL; j++) {
          vector<string> rights = generateParenthesis(n-i-1);
          size_t sizeR =rights.size();
          for (size_t k = 0; k < sizeR; k++)
          result.push_back("(" + lefts[j] + ")" + rights[k]);
        }
      }

    return result;
  }
};

int main() {
  int input;
  cin >> input;

  cout << endl;

  Solution s;

  vector<string> result = s.generateParenthesis(input);
  for (size_t i = 0; i < result.size(); i++) {
    cout << result[i] << endl;
  }
  return 0;
}