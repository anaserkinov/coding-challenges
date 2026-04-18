package leetcode.p1611_minimum_one_bit_operations_to_make_integers_zero

class Solution {
    fun minimumOneBitOperations(n: Int): Int {
        if (n <= 1) return n
        var result = 0
        var c = n
        var index = 1
        while (c != 0){
            if (c and 0b1 != 0) result = (1 shl index) - 1 - result
            c = c shr 1
            index ++
        }
        return result
    }
}