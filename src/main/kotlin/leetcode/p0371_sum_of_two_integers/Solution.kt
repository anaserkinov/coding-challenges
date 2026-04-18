package leetcode.p0371_sum_of_two_integers

class Solution {
    fun getSum(a: Int, b: Int): Int {
        var result = 0
        var carry = 0
        for (i in 0 until 32){
            val aValue = (a shr i) and 0b1
            val bValue = (b shr i) and 0b1
            val value =if (aValue == 1 && bValue == 1) {
                if (carry == 1) 3 else 2
            } else if (aValue == 1 || bValue == 1){
                if (carry == 1) 2 else 1
            } else carry
            result = result or ((value and 0b1) shl i)
            carry = value shr 1
        }
        return result
    }
}