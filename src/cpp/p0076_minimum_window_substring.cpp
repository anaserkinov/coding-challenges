#include <iostream>
#include <unordered_set>
#include <vector>

using namespace std;

class Solution {
   public:
    string minWindow(string s, string t) {
        int m[128];
        for (size_t i = 0; i < 128; i++)
            m[i] = 0;

        for (int i = 0; i < t.size(); i++) {
            m[t[i]]++;
        }

        int i = 0, j = 0;
        int counter = t.size();

        int mStart = 0, mLength = 1000000;

        while (j < s.size()) {
            if (m[s[j]] > 0)
                counter--;
            m[s[j]]--;
            j++;

            while (counter == 0) {
                if (j - i < mLength) {
                    mStart = i;
                    mLength = j - i;
                }

                m[s[i]]++;
                if (m[s[i]] > 0)
                    counter++;
                i++;
            }
        }

        if (mLength != 1000000)
            return s.substr(mStart, mLength);
        return "";
    }
};

int main() {
    Solution* s = new Solution();

    string input1;
    cin >> input1;

    string input2;
    cin >> input2;

    auto res = s->minWindow(input1, input2);

    cout << endl
         << res << endl;

    return 0;
}
