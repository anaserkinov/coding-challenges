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
    vector<int> twoSum(vector<int>& numbers, int target) {
        int size = numbers.size();

        for (int i = 0; i < size; i++){
            int start = i + 1, end = size - 1;
            int sf = target - numbers[i];
            while(end >= start){
                int mid = start + (end- start)/2;
                int midV = numbers[mid];
                if (midV == sf){
                    return {i + 1, mid + 1};
                } else if (midV > sf){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }
        
        return {};
    }
};

int main() {
    Solution* s = new Solution();

    int target;
    cin >> target;

    int size;
    cin >> size;

    vector<int> nums;

    for (int i = 0; i < size; i++) {
        int num;
        cin >> num;
        nums.push_back(num);
    }

    vector<int> res = s->twoSum(nums, target);
    cout << "Result: \n";
    for (auto a : res) {
        cout << a << "\n";
    }

    return 0;
}