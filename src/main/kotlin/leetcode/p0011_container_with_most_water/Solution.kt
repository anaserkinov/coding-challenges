package leetcode.p0011_container_with_most_water

import kotlin.math.min

class Solution {
    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.size - 1
        var result = 0
        while (left < right){
            val area = min(height[left], height[right]) * (right - left)
            if (area > result)
                result = area
            if (height[left] < height[right])
                left ++
            else
                right --
        }
        return result
    }
}