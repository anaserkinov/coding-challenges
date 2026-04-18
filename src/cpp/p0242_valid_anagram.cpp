#include <iostream>
#include <unordered_map>
#include <vector>

using namespace std;

class Solution {
   public:
    bool isAnagram(string s, string t) {
        if (s.length() != t.length()) {
            return false;
        }

        unordered_map<char, int> sMap;
        unordered_map<char, int> tMap;

        for (size_t i = 0; i < s.length(); i++) {
            sMap[s[i]]++;
            tMap[t[i]]++;
        }
        
        for(auto p: sMap){
            if (p.second != tMap[p.first]){
                return false;
            }
        }
        return true;
    }
};

int main() {
    Solution* s = new Solution();

    string s1;
    cin >> s1;

    string s2;
    cin >> s2;

    auto res = s->isAnagram(s1, s2);
    cout << "Result: " << res << "\n";

    return 0;
}
