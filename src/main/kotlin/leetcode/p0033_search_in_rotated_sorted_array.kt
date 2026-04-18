package leetcode.p0033_search_in_rotated_sorted_array


class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.lastIndex

        while (left <= right){
            val mid = (left + right) / 2
            if (nums[mid] == target) return mid

            if(nums[left] <= nums[mid]){
                if(target in nums[left]..nums[mid])
                    right = mid
                else
                    left = mid + 1
            } else {
                if(target in nums[mid]..nums[right])
                    left = mid
                else
                    right = mid - 1
            }
        }
        return -1
    }
}

fun main() {
    println(
        Solution()
            .search(intArrayOf(1), 0)
    )
    println(
        Solution()
            .search(
                intArrayOf(5,1,2,3,4), 1
            )
    )
    println(
        Solution()
            .search(
                intArrayOf(4,5,6,7,0,1,2), 0
            )
    )
    println(
        Solution()
            .search(intArrayOf(1,3), 3)
    )
}
