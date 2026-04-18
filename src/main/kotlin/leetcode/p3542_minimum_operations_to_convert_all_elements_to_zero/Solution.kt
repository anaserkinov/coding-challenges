package leetcode.p3542_minimum_operations_to_convert_all_elements_to_zero

class Solution {
    fun minOperations(nums: IntArray): Int {
        val stack = ArrayList<Int>()
        stack.add(0)
        var result = 0

        for (num in nums){
            while(stack.last() > num){
                stack.removeLast()
            }
            if (num > stack.last()){
                result++
                stack.add(num)
            }
        }
        return result
    }
}
