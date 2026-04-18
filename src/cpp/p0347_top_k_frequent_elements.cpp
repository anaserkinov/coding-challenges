#include <iostream>
#include <unordered_map>
#include <vector>
#include <math.h>

using namespace std;

class Solution {
   public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int, int> map;

        for (auto i : nums) {
            map[i]++;
        }

        vector<vector<int>> bucket(nums.size() + 1);

        for (auto pair : map) {
            bucket[pair.second].push_back(pair.first);
        }

        vector<int> result;
        for (int i = nums.size(); i >= 0; i--) {
            if (!bucket[i].empty()) {
                int c = min(k, (int)bucket[i].size());
                result.insert(result.end(), bucket[i].begin(), bucket[i].begin() + c);
                k-=c;
                if (k == 0)
                    break;
            }
        }
        
        return result;
    }
};

int main() {
    Solution* s = new Solution();

    int k;
    cin >> k;

    int count;
    cin >> count;

    vector<int> vec;

    for (size_t i = 0; i < count; i++) {
        int l;
        cin >> l;
        vec.push_back(l);
    }

    auto res = s->topKFrequent(vec, k);

    for (size_t i = 0; i < res.size(); i++) {
        cout << res[i] << "\n";
    }

    return 0;
}
