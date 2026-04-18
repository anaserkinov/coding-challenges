package leetcode.p2528_maximize_the_minimum_powered_city

import kotlin.math.max
import kotlin.math.min

class Solution {
    fun maxPower(stations: IntArray, r: Int, k: Int): Long {
        val count = stations.size
        val linear = LongArray(count + 1)
        for (i in stations.indices) {
            val power = stations[i].toLong()
            linear[max(i - r, 0)] += power
            linear[min(i + r + 1, count)] -= power
        }

        var minPower = Long.MAX_VALUE
        var maxPower = Long.MIN_VALUE
        var currentPower = 0L
        for (i in 0 until count){
            currentPower += linear[i]
            minPower = min(minPower, currentPower)
            maxPower = max(maxPower, currentPower)
        }

        fun check(minimum: Long): Boolean {
            val temp = linear.copyOf()
            var current = 0L
            var cnt = 0L

            for (i in 0 until count){
                current += temp[i]
                if (current < minimum){
                    val need = minimum - current
                    cnt += need
                    if (cnt > k) return false
                    current = minimum
                    if (i + 2 * r + 1 < count) temp[i + 2 * r + 1] -= need
                }
            }

            return true
        }

        maxPower += k
        while (minPower <= maxPower){
            val mid = minPower + ((maxPower - minPower) shr 1)
            if (check(mid))
                minPower = mid + 1
            else
                maxPower = mid - 1
        }
        return maxPower
    }
}