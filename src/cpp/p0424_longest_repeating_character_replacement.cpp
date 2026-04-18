#include <iostream>
#include <unordered_set>
#include <vector>

using namespace std;

class Solution {
   public:
    int characterReplacement(string s, int k) {
        int m = 0, mCh = 0, length = s.length();
        int l = 0, r = 0;
        int array[26];
        for (size_t i = 0; i < 26; i++) {
            array[i] = 0;
        }

        while (r < length) {
            array[s[r] - 'A']++;
            mCh = max(mCh, array[s[r] - 'A']);
            if (r - l + 1 - mCh > k) {
                array[s[l] - 'A']--;
                l++;
            }
            m = max(m, r - l + 1);
            r++;
        }

        return m;
    }
};

int main() {
    Solution* s = new Solution();

    int k;
    cin >> k;

    string input;
    cin >> input;

    auto res = s->characterReplacement(input, k);

    cout << endl
         << res << endl;

    return 0;
}
