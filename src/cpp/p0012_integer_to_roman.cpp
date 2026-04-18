#include <math.h>
#include <memory.h>

#include <iostream>
#include <string>
#include <vector>

using namespace std;

class Solution {
   public:
   public:
    string intToRoman(int num) {
        string result = "";

        char f = 'I';
        char s = 'V';
        char l = 'X';

        do {
            int d = num % 10;

            switch (d) {
                case 1:
                    result = f + result;
                    break;
                case 2:
                    result = f + result;
                    result = f + result;
                    break;
                case 3:
                    result = f + result;
                    result = f + result;
                    result = f + result;
                    break;
                case 4:
                    result = s + result;
                    result = f + result;
                    break;
                case 5:
                    result = s + result;
                    break;
                case 6:
                    result = f + result;
                    result = s + result;
                    break;
                case 7:
                    result = f + result;
                    result = f + result;
                    result = s + result;
                    break;
                case 8:
                    result = f + result;
                    result = f + result;
                    result = f + result;
                    result = s + result;
                    break;
                case 9:
                    result = l + result;
                    result = f + result;
                    break;
                default:
                    break;
            }

            if (f == 'I') {
                f = 'X';
                s = 'L';
                l = 'C';
            } else if (f == 'X') {
                f = 'C';
                s = 'D';
                l = 'M';
            } else {
                f = 'M';
                s = 'M';
                l = 'M';
            }

            num /= 10;
        } while (num != 0);

        return result;
    }
};

int main() {
    Solution* s = new Solution();

    int input;
    cin >> input;

    cout << s->intToRoman(input) << endl;

    return 0;
}
