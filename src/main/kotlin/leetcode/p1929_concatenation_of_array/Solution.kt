package leetcode.p1929_concatenation_of_array

class Solution {
    fun getConcatenation(nums: IntArray): IntArray {
        val result = IntArray(2 * nums.size)
        System.arraycopy(
            nums,
            0,
            result,
            0,
            nums.size
        )
        System.arraycopy(
            nums,
            0,
            result,
            nums.size,
            nums.size
        )
        return result
    }
}