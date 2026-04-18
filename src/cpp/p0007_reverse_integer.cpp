#include <memory.h>

#include <iostream>
#include <string>

using namespace std;

class Solution {
   public:
    int reverse(int x) {
        int result;
        int input;
        int max;
        if (x > 0) {
            input = -x;
            max = -INT32_MAX;
        } else {
            input = x;
            max = INT32_MIN;
        }

        while (input != 0) {
            int8_t numberToAdd = input % 10;
            int k = max - numberToAdd ;
            if (k/10 > -result || k/10 + k%10 > -result)
                return 0;

            result *= 10;
            result -= numberToAdd;
            input /= 10;
        }

        return x < 0 ? (-1 * result) : result;
    }
};

int main() {
    Solution* s = new Solution();

    int input;
    cin >> input;

    cout << s->reverse(input) << endl;

    return 0;
}
