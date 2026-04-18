#include <iostream>
#include <vector>

using namespace std;

class Solution {
 public:
  int searchInsert(vector<int>& nums, int target) {
    int index = 0;
    int size = nums.size();
    for (size_t i = 0; i < size; i++) {
      if (target > nums[index])
        index = i + 1;
      else if (target == nums[index])
        return i;
    }
    return index;
  }
};

int main() {
  int size;
  vector<int> input;
  int target;
  cout << "Target: ";
  cin >> target;
  cout << endl << "Size: ";
  cin >> size;

  for (size_t i = 0; i < size; i++) {
    int o;
    cin >> o;
    input.push_back(o);
  }

  Solution s;

  cout << endl << s.searchInsert(input, target) << endl;

  return 0;
}