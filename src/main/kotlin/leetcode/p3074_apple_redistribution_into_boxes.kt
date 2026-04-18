package leetcode.p3074_apple_redistribution_into_boxes

import kotlin.math.min

class Solution {
    fun minimumBoxes(apple: IntArray, capacity: IntArray): Int {
        capacity.sortDescending()
        var left = apple.sum()
        var cIndex = 0
        while (left != 0) {
            if (capacity[cIndex] == 0) cIndex ++
            val min = min(left, capacity[cIndex])
            left -= min
            capacity[cIndex] -= min
        }
        return cIndex + 1
    }
}