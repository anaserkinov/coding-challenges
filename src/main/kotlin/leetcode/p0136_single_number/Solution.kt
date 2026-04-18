package leetcode.p0136_single_number

class Solution {
    fun singleNumber(nums: IntArray): Int {
        var sum = 0
        for (it in nums){
            sum = sum xor it
        }
        return sum
    }
}