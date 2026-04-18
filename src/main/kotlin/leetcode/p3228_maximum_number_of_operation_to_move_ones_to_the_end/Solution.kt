package leetcode.p3228_maximum_number_of_operation_to_move_ones_to_the_end

class Solution {
    fun maxOperations(s: String): Int {
        var result = 0
        var ones = 0
        var pre = '0'
        s.forEach {
            if (it == '1')
                ones ++
            else if (pre == '1')
                result += ones
            pre = it
        }
        return result
    }
}