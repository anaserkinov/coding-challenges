package leetcode.p0069_sqrt_x

class Solution {
    fun mySqrt(x: Int): Int {
        if (x == 0) return 0
        if (x <= 3) return 1
        var left = 2
        var right = x/2
        while (left <= right) {
            val mid = left + (right - left)/2
            when {
                x / mid == mid -> return mid
                x / mid > mid -> left = mid + 1
                else -> right = mid - 1
            }
        }
        return right
    }
}