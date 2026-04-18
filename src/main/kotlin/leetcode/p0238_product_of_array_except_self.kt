package leetcode.p0238_product_of_array_except_self

class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val size = nums.size
        val answer = IntArray(size) { 1 }

        var left = 0
        var right = size - 1
        var prefix = 1
        var suffix = 1

        while (left != size){
            answer[left] *= prefix
            answer[right] *= suffix

            prefix *= nums[left]
            suffix *= nums[right]

            left ++
            right --
        }

        return answer
    }
}