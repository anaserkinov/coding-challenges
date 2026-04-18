package leetcode.p0167_two_sum_II_input_array_sorted

class Solution {
    fun twoSum(numbers: IntArray, target: Int): IntArray {
        if (numbers.size == 2) return intArrayOf(1, 2)
        var left = 0
        var right = numbers.size - 1
        while (left < right){
            val v = numbers[left] + numbers[right]
            if (v < target)
                left ++
            else if (v > target)
                right --
            else
                return intArrayOf(left + 1, right + 1)
        }
        return intArrayOf()
    }
}