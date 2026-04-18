#include <iostream>
#include <unordered_set>
#include <vector>

using namespace std;

class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        unordered_set<int> set;
        for (int num : nums) {
            if (set.find(num) != set.end())
                return true;
            set.insert(num);
        }
        return false;
    }
};

int main() {
    Solution* s = new Solution();

    int size;
    cin>>size;

    vector<int> input(size, 0);

    for (size_t i = 0; i < size; i++){
        cin>>input[i];
    }
    

    auto res = s->containsDuplicate(input);
    cout << "Result: " << res << "\n";


    return 0;
}
