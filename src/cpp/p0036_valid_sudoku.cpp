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
    bool isValidSudoku(vector<vector<char>>& board) {
        
        bool hCheck[10];
        bool vCheck[10];
        bool bCheck[10];

        for (size_t i = 0; i < 9; i++){
            int rowStart = (i/3) * 3;
            int columnStart = (i%3) * 3;

            for (size_t j = 0; j < 9; j++){
                // horizontal
                char s = board[i][j];
                if (s != 46){
                    int num = (int)s - 48;
                    if (hCheck[num])
                        return false;
                    hCheck[num] = true;
                }

                // vertical
                s = board[j][i];
                if (s != 46){
                    int num = (int)s - 48;
                    if (vCheck[num])
                        return false;
                    vCheck[num] = true;
                }

                // box
                s = board[rowStart + j/3][columnStart + j%3];
                if (s != 46){
                    int num = (int)s - 48;
                    if (bCheck[num])
                        return false;
                    bCheck[num] = true;
                }
            }

            for (size_t j = 0; j < 10; j++){
                hCheck[j] = false;
                vCheck[j] = false;
                bCheck[j] = false;
            }
        }
        
        return true;
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

    return 0;
}
