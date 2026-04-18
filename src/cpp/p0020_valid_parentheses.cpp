#include <iostream>
#include <unordered_set>
#include <vector>

using namespace std;

class Solution {
public:
    bool isValid(string s) {
        vector<int> stack;
        size_t lenght = s.length();
        for (size_t i = 0; i < lenght; i++){
            char c = s[i];
            if (stack.size() != 0 && (c - stack.back() == 1 || c - stack.back() == 2)){
                stack.pop_back();
            } else {
                stack.push_back(c);
            }
        }
        return stack.empty();
    }
};

int main() {
    Solution* s = new Solution();

    string input;
    cin >> input;

    auto res = s->isValid(input);

    cout << endl
         << res << endl;

    return 0;
}
