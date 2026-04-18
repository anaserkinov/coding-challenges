 #include <iostream>
#include <string>

using namespace std;

class Solution {
  int lNumber = 0;

 public:
  int romanToInt(string s) {
    int result = 0;
    lNumber = 0;
    int length = s.length();



    for (size_t i = 0; i < length; i++) {
      switch (s[i]) {
        case 73:
          result += fun10(1);
          break;
        case 86:
          result += fun5(5);
          break;
        case 88:
          result += fun10(10);
          break;
        case 76:
          result += fun5(50);
          break;
        case 67:
          result += fun10(100);
          break;
        case 68:
          result += fun5(500);
          break;
        default:
          result += fun10(1000);
          break;
      }
    }

    result += lNumber;

    return result;
  }

  int fun5(int v) {
    if (lNumber == v / 5) {
      v -= v / 5;
    } else
      v += lNumber;
    lNumber = 0;
    return v;
  }

  int fun10(int v) {
    int result = 0;
    if (lNumber == v)
      result += v;
    else if (v != 1 && lNumber == v / 10) {
      result += v - v / 10;
      lNumber = 0;
    } else {
      result += lNumber;
      lNumber = v;
    }
    return result;
  }
};

int main() {
  Solution* s = new Solution();

  string st;
  cin >> st;

  cout << s->romanToInt(st) << endl;

  return 0;
}