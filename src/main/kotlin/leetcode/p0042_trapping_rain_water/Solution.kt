package leetcode.p0042_trapping_rain_water

import kotlin.math.max

class Solution {
    fun trap(height: IntArray): Int {
        if (height.size < 3) return 0

        var l = 0
        var lMax = height[l]
        var r = height.size - 1
        var rMax = height[r]

        var result = 0
        repeat(height.size){
            if (lMax < rMax) {
                lMax = max(lMax, height[l])
                result += lMax - height[l]
                l++
            } else {
                rMax = max(rMax, height[r])
                result += rMax - height[r]
                r--
            }
        }

        return result
    }
}