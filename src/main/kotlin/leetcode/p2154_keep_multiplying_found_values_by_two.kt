package leetcode.p2154_keep_multiplying_found_values_by_two

class Solution {
    fun findFinalValue(nums: IntArray, original: Int): Int {
        var n = 0
        for (i in nums.indices){
            val v = nums[i]/original
            if (nums[i]%original == 0 && (v and (v - 1)) == 0){
                n = n or v
            } else
                nums[i] = 0
        }
        n ++
        return original * (n and (-n))
    }
}