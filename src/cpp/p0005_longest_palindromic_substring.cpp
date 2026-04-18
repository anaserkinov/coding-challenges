#include <memory.h>

#include <iostream>
#include <string>

using namespace std;

class Solution {
   public:
    string longestPalindrome(string s) {
        size_t length = s.length();
        if (length <= 1) {
            return s;
        }

        bool d[length][length];
        memset(d, false, length * length * sizeof(bool));
        size_t start = 0;
        size_t max = 1;

        for (size_t i = 0; i < length; i++) {
            d[i][i] = true;
        }

        for (size_t cLen = 2; cLen <= length; cLen++) {
            for (size_t i = 0; i <= length - cLen; i++) {
                size_t j = i + cLen - 1;
                if (s[i] == s[j] && (d[i + 1][j - 1] || j - i == 1)) {
                    d[i][j] = true;
                    if (cLen > max) {
                        start = i;
                        max = cLen;
                    }
                }
            }
        }

        return s.substr(start, max);
    }
};

int main() {
    Solution* s = new Solution();

    string st;
    cin >> st;

    cout << s->longestPalindrome(st) << endl;

    return 0;
}