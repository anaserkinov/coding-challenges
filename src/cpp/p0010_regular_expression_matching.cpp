#include <math.h>
#include <memory.h>

#include <algorithm>
#include <iostream>
#include <string>
#include <unordered_map>
#include <vector>

using namespace std;

class Solution {
   private:
    string res, pattern;
    int resSize = 0, pSize = 0;
    vector<vector<int>> dp;

   public:
    bool check(int resIndex, int pIndex) {
        if (resIndex >= resSize && pIndex >= pSize) return true;
        if (pIndex >= pSize) return false;
        if (resIndex >= resSize) {
            for (int k = pIndex; k < pSize; k++) {
                if ((pattern[k] == '*') || (k + 1 < pSize && pattern[k + 1] == '*'))
                    continue;
                else
                    return false;
            }
            return true;
        }
        if (dp[resIndex][pIndex] != -1) return dp[resIndex][pIndex];
        if (pIndex + 1 < pSize && pattern[pIndex + 1] == '*') {
            bool left = check(resIndex, pIndex + 2);
            bool right = ((res[resIndex] == pattern[pIndex] || pattern[pIndex] == '.')) 
            ? check(resIndex + 1, pIndex) 
            : false;
            return dp[resIndex][pIndex] = left || right;
        }
        if ((res[resIndex] == pattern[pIndex] || pattern[pIndex] == '.'))
            return dp[resIndex][pIndex] = check(resIndex + 1, pIndex + 1);
        return dp[resIndex][pIndex] = false;
    }

    bool isMatch(string s, string p) {
        this->res = s;
        this->pattern = p;
        this->resSize = s.size();
        this->pSize = p.size();
        dp.resize(resSize + 1, vector<int>(pSize + 1, -1));
        return check(0, 0);
    }
};

int main() {
    Solution* s = new Solution();

    string input;
    cin >> input;

    string pattern;
    cin >> pattern;

    bool res = s->isMatch(input, pattern);
    cout << "Result: " << res << "\n";

    return 0;
}
