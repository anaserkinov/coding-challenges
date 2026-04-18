package leetcode.p0229_majority_element_II

class Solution {
    fun majorityElement(nums: IntArray): List<Int> {
        var vote1 = 0; var vote2 = 0
        var candidate1 = 0; var candidate2 = 0

        for (num in nums){
            if (num == candidate1)
                vote1 ++
            else if (num == candidate2)
                vote2 ++
            else if (vote1 == 0) {
                candidate1 = num
                vote1 = 1
            } else if (vote2 == 0) {
                candidate2 = num
                vote2 = 1
            } else {
                vote1 --
                vote2 --
            }
        }
        vote1 = 0; vote2 = 0
        for (num in nums){
            if (num == candidate1) vote1++
            else if (num == candidate2) vote2++
        }
        return when{
            vote1 > nums.size/3 && vote2 > nums.size/3 -> listOf(candidate1, candidate2)
            vote1 > nums.size/3 -> listOf(candidate1)
            vote2 > nums.size/3 -> listOf(candidate2)
            else -> emptyList()
        }
    }
}