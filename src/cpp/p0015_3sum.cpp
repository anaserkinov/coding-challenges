#include <math.h>
#include <memory.h>
#include <iostream>
#include <algorithm>
#include <string>
#include <unordered_map>
#include <vector>

using namespace std;

class Solution {
   public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        vector<vector<int>> result;

        int size = nums.size();
        std::unordered_map<int, int> map;
        for (int i = 0; i < size; i++) {
            map[nums[i]] = i;
        }

        for (int i = 0; i < size - 2; i++) {
            if (nums[i] > 0)
                break;

            for (int j = i + 1; j < size - 1; j++) {
                int s = -nums[i] - nums[j];
                auto f = map.find(s);
                if (f != map.end() && f->second > j){
                    result.push_back({nums[i], nums[j], s});
                }
                j = map.find(nums[j])->second;
            }
            i = map.find(nums[i])->second;
        }

        return result;
    }
};

int main() {
    Solution* s = new Solution();

    int size;
    cin >> size;

    vector<int> nums;

    for (size_t i = 0; i < size; i++) {
        int num;
        cin >> num;
        nums.push_back(num);
    }

    vector<vector<int>> res = s->threeSum(nums);
    cout << "Result: \n";
    for (auto a : res) {
        cout << "List: \n";
        for (auto i : a) {
            cout << i << "\n";
        }
    }

    return 0;
}
