package leetcode.p2013_detect_squares

import kotlin.math.abs

class DetectSquares() {

    private val map = HashMap<Int, Int>()

    private fun key(x: Int, y: Int) = x * 10000 + y

    fun add(point: IntArray) {
        val key = key(point[0], point[1])
        map[key] = (map[key] ?: 0) + 1
    }

    fun count(point: IntArray): Int {
        var count = 0
        map.forEach {
            if (it.key%10_000 == point[1] && it.key/10_000 != point[0]){
                val distance = point[0] - it.key/10_000
                val distanceAbs = abs(distance)

                count += it.value *
                        (map[key(point[0], point[1] + distanceAbs)] ?: 0) *
                        (map[key(point[0] - distance, point[1] + distanceAbs)] ?: 0)

                count += it.value *
                        (map[key(point[0], point[1] - distanceAbs)] ?: 0) *
                        (map[key(point[0] - distance, point[1] - distanceAbs)] ?: 0)
            }
        }
        return count
    }
}