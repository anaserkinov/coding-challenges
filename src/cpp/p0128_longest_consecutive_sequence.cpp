#include <iostream>
#include <unordered_set>
#include <vector>

using namespace std;

class Solution {
   public:
    int lengthOfLongestSubstring(string s) {        
        int m = 0,  length = s.length();
        int array[128];
        for (size_t i = 0; i < 128; i++){ array[i] = -1; }
        
        int left = 0;

        for (int i = 0; i < length; i++) {
            int pre = array[s[i]];
            if (pre >= left){
                left = pre + 1;
            }
            m = max(m, i - left + 1);
            array[s[i]] = i;
        }

        return m;
    }
};


int main() {
    Solution* s = new Solution();

    string input;
    cin >> input;

    auto res = s->lengthOfLongestSubstring(input);

    cout << endl
         << res << endl;

    return 0;
}
