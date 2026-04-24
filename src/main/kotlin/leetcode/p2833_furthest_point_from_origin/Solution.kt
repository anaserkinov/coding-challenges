package leetcode.p2833_furthest_point_from_origin

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun furthestDistanceFromOrigin(moves: String): Int {
        var l = 0
        var r = 0
        for(m in moves) {
            if (m == 'L') l ++
            else if (m == 'R') r ++
        }

        return max(l, r) - min(l, r) + moves.length - l - r
    }
}