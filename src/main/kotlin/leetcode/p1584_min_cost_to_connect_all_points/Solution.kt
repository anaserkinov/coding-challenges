package leetcode.p1584_min_cost_to_connect_all_points

import kotlin.math.abs
import kotlin.math.min

class Solution {
    fun minCostConnectPoints(points: Array<IntArray>): Int {
        val visited = BooleanArray(points.size)
        val dist = IntArray(points.size) { Int.MAX_VALUE }
        var result = 0
        var node = 0
        repeat(points.size - 1) main@{
            visited[node] = true
            var next = -1
            repeat(points.size){
                if (visited[it]) return@repeat
                val distance = abs(points[node][0] - points[it][0]) +
                        abs(points[node][1] - points[it][1])
                dist[it] = min(dist[it], distance)
                if (next == -1 || dist[it] < dist[next]) next = it
            }
            node = next
            result += dist[next]
        }
        return result
    }
}