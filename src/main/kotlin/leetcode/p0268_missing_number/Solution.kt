package leetcode.p0268_missing_number

class Solution {
    fun missingNumber(nums: IntArray): Int {
        var sum = 0
        for (i in nums) sum += i

        val n = nums.size
        val expectedSum = n*(n+1)/2

        return expectedSum - sum
    }
}