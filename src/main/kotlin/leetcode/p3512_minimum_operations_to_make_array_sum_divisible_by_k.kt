package leetcode.p3512_minimum_operations_to_make_array_sum_divisible_by_k

class Solution {
    fun minOperations(nums: IntArray, k: Int): Int {
        var sum = 0
        for (item in nums) sum += item
        return sum - (sum/k) * k
    }
}