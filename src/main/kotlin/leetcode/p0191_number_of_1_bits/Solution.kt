package leetcode.p0191_number_of_1_bits


class Solution {
    fun hammingWeight(n: Int): Int {
        var n = n
        var result = 0
        while (n != 0){
            if (n and 0b1 != 0) result ++
            n = n shr 1
        }
        return result
    }
}