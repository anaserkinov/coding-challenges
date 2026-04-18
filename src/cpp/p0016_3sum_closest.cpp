#include <math.h>
#include <memory.h>

#include <algorithm>
#include <iostream>
#include <string>
#include <unordered_map>
#include <vector>

using namespace std;

class Solution {
   public:
    int threeSumClosest(vector<int>& nums, int target) {
        int result = 0;
        int d = INT32_MAX;
        int size = nums.size();

        sort(nums.begin(), nums.end());
        for (int i = 0; i < size - 2; i++) {
            int l = i + 1, r = size - 1;

            while (l < r) {
                int c = nums[i] + nums[l] + nums[r];
                if (c == target)
                    return target;
                else if (c > target)
                    r--;
                else
                    l++;

                if (abs(target - c) < d) {
                    result = c;
                    d = abs(target - c);
                }
            }
        }

        return result;
    }
};

int main() {
    Solution* s = new Solution();

    int target;

    cin >> target;

    int size;
    cin >> size;

    vector<int> nums;

    for (size_t i = 0; i < size; i++) {
        int num;
        cin >> num;
        nums.push_back(num);
    }

    int res = s->threeSumClosest(nums, target);
    cout << "Result: " << res << "\n";

    return 0;
}
