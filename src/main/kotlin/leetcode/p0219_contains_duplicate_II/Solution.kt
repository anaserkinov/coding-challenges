package leetcode.p0219_contains_duplicate_II

class Solution {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val set = HashSet<Int>(k + 1)
        var left = 0
        var right = 0
        while (right < nums.size){
            if (right - left > k)
                set.remove(nums[left++])
            if (set.contains(nums[right])) return true
            set.add(nums[right++])
        }
        return false
    }
}