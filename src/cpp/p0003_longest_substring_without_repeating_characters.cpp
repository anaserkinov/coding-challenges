#include <algorithm>
#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;

class Solution {
   public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        if (strs.size() < 2) {
            return vector<vector<string>>(strs.size(), strs);
        }

        vector<vector<string>> result;
        unordered_map<string, vector<string>> map;

        for (auto str : strs) {
            string key = str;
            sort(key.begin(), key.end());
            map[key].push_back(str);
        }

        for (auto& pair : map) {
            result.push_back(pair.second);
        }

        return result;
    }
};

int main() {
    Solution* s = new Solution();

    int count;
    cin >> count;

    vector<string> strs;

    for (size_t i = 0; i < count; i++) {
        string input;
        cin >> input;
        strs.push_back(input);
    }

    auto res = s->groupAnagrams(strs);

    for (size_t i = 0; i < res.size(); i++) {
        cout << "\n\nItems: \n";
        auto items = res[i];
        for (size_t j = 0; j < items.size(); j++) {
            cout << items[j] << ", ";
        }
    }

    return 0;
}
