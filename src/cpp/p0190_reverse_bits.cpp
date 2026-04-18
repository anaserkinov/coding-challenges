#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    uint32_t reverseBits(uint32_t n) {
      uint32_t result = 0;
      for (int i = 31; i >= 0; i--){
        result |= ((n & 1) << i);
        n>>=1;
      }
      
      return result;
    }
};

int main() {
  uint32_t input;
  cin >> input;
  Solution s;

  cout << endl << s.reverseBits(input) << endl;

  return 0;
}