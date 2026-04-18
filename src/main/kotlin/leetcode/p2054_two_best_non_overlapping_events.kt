package leetcode.p2054_two_best_non_overlapping_events

import kotlin.math.max

class Solution {
    fun maxTwoEvents(events: Array<IntArray>): Int {
        events.sortBy { it[0] }
        val dp = Array(events.size) { IntArray(3){ -1 } }

        fun f(idx: Int, cnt: Int): Int {
            if (cnt == 2 || idx >= events.size) return 0
            dp[idx][cnt].let { if (it != -1) return it }

            val end = events[idx][1]
            var lo = idx + 1
            var hi = events.size - 1
            while (lo < hi) {
                val mid = lo + ((hi - lo) shr 1)
                if (events[mid][0] > end) hi = mid
                else lo = mid + 1
            }
            val include = events[idx][2] +
                    if (lo < events.size && events[lo][0] > end) f(lo, cnt + 1)
                    else 0
            val exclude = f(idx + 1, cnt)
            dp[idx][cnt] = max(include, exclude)
            return dp[idx][cnt]
        }

        return f(0, 0)
    }
}