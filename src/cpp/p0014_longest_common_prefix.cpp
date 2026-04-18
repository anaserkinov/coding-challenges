#include <math.h>
#include <memory.h>

#include <iostream>
#include <string>
#include <vector>

using namespace std;

class Solution {
    public:
    string longestCommonPrefix(vector<string>& strs) {
        string cpref = "";
        size_t l = strs.size();

        size_t j = 0;
        while (true) {
            if (j == strs[0].length())
                break;

            char d = strs[0][j];
            for (size_t i = 1; i < l; i++) {
                if (j == strs[i].length() || strs[i][j] != d) {
                    return cpref;
                }
            }
            cpref += d;

            j++;
        }

        return cpref;
    }
};

int main() {
    Solution* s = new Solution();

    int input;
    cin >> input;

    vector<string> strs;

    for (size_t i = 0; i < input; i++) {
        string s;
        cin >> s;
        strs.push_back(s);
    }

    cout << s->longestCommonPrefix(strs) << endl;

    return 0;
}
