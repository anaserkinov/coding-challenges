package leetcode.p0217_contains_duplicate

class Solution {
    fun containsDuplicate(nums: IntArray): Boolean {
        val set = hashSetOf<Int>()
        nums.forEach {
            if (set.contains(it))
                return true
            set.add(it)
        }
        return false
    }
}