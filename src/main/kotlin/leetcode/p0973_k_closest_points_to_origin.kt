package leetcode.p0973_k_closest_points_to_origin

import java.util.*

class Solution {
    fun kClosest(points: Array<IntArray>, k: Int): Array<IntArray> {
        val heap = PriorityQueue(compareBy<IntArray> { it[0] * it[0] + it[1] * it[1] })
        points.forEach { heap.add(it) }
        return Array(k) { heap.poll() }
    }
}