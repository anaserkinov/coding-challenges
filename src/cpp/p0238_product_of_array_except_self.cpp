#include <iostream>
#include <vector>

using namespace std;

class Solution {
   public:
    vector<int> productExceptSelf(vector<int>& nums) {
        int size = nums.size();

        vector<int> result(size, 1);

        int l = 0;
        int r = size - 1;
        int prefix = 1;
        int suffix = 1;
        while (l != size) {
            result[l] *= prefix;
            prefix *= nums[l];
            result[r] *= suffix;
            suffix *= nums[r];
            l ++;
            r --;
        }
        
        return result;
    }
};

int main() {
    Solution* s = new Solution();

    int count;
    cin >> count;

    vector<int> vec;

    for (size_t i = 0; i < count; i++) {
        int l;
        cin >> l;
        vec.push_back(l);
    }

    auto res = s->productExceptSelf(vec);

    cout << endl;
    for (size_t i = 0; i < res.size(); i++) {
        cout << res[i] << "\n";
    }

    return 0;
}
