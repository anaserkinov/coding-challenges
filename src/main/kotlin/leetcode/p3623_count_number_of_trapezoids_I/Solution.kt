package leetcode.p3623_count_number_of_trapezoids_I

class Solution {
    fun countTrapezoids(points: Array<IntArray>): Int {
        val map = HashMap<Int, Int>()
        points.forEach {
            map[it[1]] = (map[it[1]] ?: 0) + 1
        }
        var sum = 0L
        var squareSum = 0L
        map.values.forEach {
            val i = it.toLong() * (it - 1)/2L
            sum += i
            squareSum += i * i
        }
        return (((sum * sum - squareSum)%1_000_000_007) * 500000004 % 1_000_000_007).toInt()
    }
}
