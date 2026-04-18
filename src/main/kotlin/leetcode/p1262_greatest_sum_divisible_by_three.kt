package leetcode.p1262_greatest_sum_divisible_by_three

import kotlin.math.max

class Solution {
    fun maxSumDivThree(nums: IntArray): Int {
        var array1 = IntArray(3)
        var array2 = IntArray(3)
        var result = 0
        for (i in nums.size - 1 downTo 0){
            val number = nums[i]
            array1[0] = array2[0]
            array1[1] = array2[1]
            array1[2] = array2[2]
            for (j in 0 until 3){
                val sum = array2[j] + number
                when (sum % 3){
                    0 -> if (sum > array1[0]) array1[0] = sum
                    1 -> if (sum > array1[1]) array1[1] = sum
                    2 -> if (sum > array1[2]) array1[2] = sum
                }
            }
            result = max(result, array1[0])
            array2 = array1.also {
                array1 = array2
            }
        }
        return result
    }
}

fun main() {
    Solution()
        .maxSumDivThree(
            intArrayOf(11,22,33,44,55,66,77,88,99,110,152,11,142,2,10,12,3)
        )
}