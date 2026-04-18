package leetcode.p0560_subarray_sum_equals_k

class Solution {
    fun subarraySum(nums: IntArray, k: Int): Int {
        for (i in 1 until nums.size)
            nums[i] += nums[i - 1]

        var result = 0
        val map = HashMap<Int, Int>()
        for (i in 0 until nums.size){
            val sum = nums[i]
            if (sum == k) result ++
            map[sum - k]?.let { result += it }
            map[sum] = (map[sum] ?: 0) + 1
        }

        return result
    }
}