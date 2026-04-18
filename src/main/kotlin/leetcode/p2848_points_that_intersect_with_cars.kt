package leetcode.p2848_points_that_intersect_with_cars

class Solution {
    fun numberOfPoints(nums: List<List<Int>>): Int {
        val linear = IntArray(102)
        nums.forEach {
            linear[it[0]] ++
            linear[it[1] + 1] --
        }
        var sum = 0
        var result = 0
        linear.forEach {
            sum += it
            if (sum != 0) result ++
        }
        return result
    }
}