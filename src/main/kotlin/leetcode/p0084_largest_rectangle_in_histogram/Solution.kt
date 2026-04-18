package leetcode.p0084_largest_rectangle_in_histogram

import kotlin.math.max

class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        val stack = ArrayDeque<Pair<Int, Int>>()
        var maxArea = 0
        heights.forEachIndexed { index, height ->
            var start = index
            while (stack.isNotEmpty() && stack.last().first > height){
                val (height, i) = stack.removeLast()
                maxArea = max(maxArea, height * (index - i))
                start = i
            }
            stack.add(Pair(height, start))
        }
        stack.forEach {
            maxArea = max(maxArea, it.first * (heights.size - it.second))
        }
        return maxArea
    }
}

fun main() {
    println(
        Solution()
            .largestRectangleArea(
                intArrayOf(2,1,5,6,2,3)
            )
    )
    println(
        Solution()
            .largestRectangleArea(
                intArrayOf(2,4)
            )
    )
    println(
        Solution()
            .largestRectangleArea(intArrayOf(2,1,2))
    )
}