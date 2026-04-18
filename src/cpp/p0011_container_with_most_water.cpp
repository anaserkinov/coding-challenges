#include <memory.h>

#include <iostream>
#include <string>
#include <vector>
#include <math.h>

using namespace std;

class Solution {
public:
    public:
    int maxArea(vector<int>& height) {
        ios::sync_with_stdio(false);
        cin.tie(NULL);
        cout.tie(NULL);
        size_t l = 0, r = height.size() - 1;
        int max = 0;
        while (l != r){
            int m;
            if(height[l] > height[r]){
                m = height[r --];
            } else {
                m = height[l ++];
            }

            int s = m * (r - l + 1);
            if (s > max){
                max = s;
            }
        }
        

        return max;
    }
};

int main() {
    Solution* s = new Solution();

    size_t size;
    cin >> size;

    vector<int> height;

    for(size_t i = 0; i < size; i++){
        int n;
        cin >> n;
        height.push_back(n);
    }

    cout << s->maxArea(height) << endl;

    return 0;
}
