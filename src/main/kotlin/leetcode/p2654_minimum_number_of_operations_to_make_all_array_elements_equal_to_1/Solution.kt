package leetcode.p2654_minimum_number_of_operations_to_make_all_array_elements_equal_to_1

class Solution {
    fun minOperations(nums: IntArray): Int {
        nums.count { it == 1 }.let {
            if (it != 0) return nums.size - it
        }
        val gcd = nums.copyOf()
        fun gcd(a: Int, b: Int): Int =
            if (b == 0) a else gcd(b, a % b)
        for (i in 1 until nums.size){
            for (j in 0 until nums.size - i){
                gcd[j] = gcd(gcd[j], nums[j + i])
                if (gcd[j] == 1) return i + nums.size - 1
            }
        }
        return -1
    }
}