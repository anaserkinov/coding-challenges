package leetcode.p3190_find_minimum_operations_to_make_all_elements_divisible_by_three

class Solution {
    fun minimumOperations(nums: IntArray): Int {
        var result = 0
        for (num in nums){
            if (num%3 != 0) result++
        }
        return result
    }
}