package leetcode.p0287_find_the_duplicate_number

class Solution {
    fun findDuplicate(nums: IntArray): Int {
        var next = 0
        while (true){
            val current = nums[next]
            nums[next] = -1
            if (nums[current] == -1) return current
            next = current
        }
    }
}