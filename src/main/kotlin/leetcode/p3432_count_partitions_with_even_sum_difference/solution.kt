package leetcode.p3432_count_partitions_with_even_sum_difference

class Solution {
    fun countPartitions(nums: IntArray): Int {
        var sum = 0
        for (num in nums) sum += num
        if (sum%2 == 1) return 0
        return nums.size - 1
    }
}