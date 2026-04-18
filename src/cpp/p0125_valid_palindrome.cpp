#include <iostream>
#include <unordered_set>
#include <vector>

using namespace std;

class Solution {
   public:
    bool isPalindrome(string s) {
        int size = s.length(), l = 0, r = size - 1;

        while (l < r) {
            char lC = s[l];
            char rC = s[r];
            if (lC >= 65 && lC <= 90) lC += 32;
            if (rC >= 65 && rC <= 90) rC += 32;

            if ((lC < 97 || lC > 122) && (lC < 48 || lC > 57)) {
                l++;
                continue;
            }

            if ((rC < 97 || rC > 122) && (rC < 48 || rC > 57)) {
                r--;
                continue;
            }

            l++;
            r--;
            if (lC != rC)
                return false;
        }

        return true;
    }
};

int main() {
    Solution* s = new Solution();

    string input;
    cin >> input;

    auto res = s->isPalindrome(input);

    cout << endl
         << res << endl;

    return 0;
}
