package leetcode.p0085_maximal_rectangle

import kotlin.math.max

class Solution {
    fun maximalRectangle(matrix: Array<CharArray>): Int {
        val stack = ArrayDeque<Pair<Int, Int>>()
        fun largestRectangleArea(heights: IntArray): Int {
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
            repeat(stack.size) {
                val (height, i) = stack.removeLast()
                maxArea = max(maxArea, height * (heights.size - i))
            }
            return maxArea
        }

        var result = 0
        val array = IntArray(matrix[0].size)
        for (row in matrix){
            for (i in row.indices){
                array[i] = (row[i].code - 48) * (array[i] + 1)
            }
            result = max(result, largestRectangleArea(array))
        }
        return result
    }
}