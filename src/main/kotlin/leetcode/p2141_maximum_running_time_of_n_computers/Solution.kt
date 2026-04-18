package leetcode.p2141_maximum_running_time_of_n_computers

import kotlin.math.min

class Solution {
    fun maxRunTime(n: Int, batteries: IntArray): Long {
        fun check(time: Long): Boolean {
            var s = 0L
            for (t in batteries) s += min(t.toLong(), time)
            return s >= time * n
        }
        var sum = 0L
        for (t in batteries) sum += t

        var result = 0L
        var left = 1L
        var right = sum/n
        while (left <= right){
            val mid = left + (right - left)/2
            if (check(mid)) {
                result = mid
                left = mid + 1
            } else
                right = mid - 1
        }
        return result
    }
}