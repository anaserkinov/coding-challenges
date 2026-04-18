package leetcode.p3321_find_x_sum_of_all_k_long_subarrays_II

import java.util.*
import kotlin.collections.HashMap

class Solution {
    fun findXSum(nums: IntArray, k: Int, x: Int): LongArray {
        val result = LongArray(nums.size - k + 1)
        val frequency = HashMap<Int, Int>()
        val cm = Comparator { p0: Int, p1: Int ->
            if (frequency[p0] == frequency[p1]) p0 - p1
            else (frequency[p0] ?: 0) - (frequency[p1] ?: 0)
        }
        val q = TreeSet(cm)
        val o = TreeSet(cm)
        var sum = 0L

        fun poll() = if (q.size > x) {
            sum -= 1L * (frequency[q.first()] ?: 0) * q.first()
            o += q.pollFirst()
        } else Unit

        fun add(n: Int) {
            q += n
            sum += 1L * frequency[n]!! * n
            poll()
        }
        fun balance() {
            poll()
            if (o.size > 0 && (q.size < x || cm.compare(o.last(), q.first()) > 0))
                add(o.pollLast())
        }

        for (i in nums.indices) {
            val oldF = frequency[nums[i]] ?: 0
            val newF = 1 + oldF
            if (nums[i] in q)
                sum -= 1L * oldF * nums[i]

            q -= nums[i]
            o -= nums[i]
            frequency[nums[i]] = newF
            add(nums[i])

            if (i >= k-1) {
                balance()
                result[i-k+1] = sum
                val n = nums[i-k+1]
                val oldF = frequency[n] ?: 0
                val newF = oldF - 1
                if (n in q) sum -= 1L * oldF * n
                o -= n
                q -= n
                frequency[n] = newF
                if (newF > 0L) add(n) else frequency -= n
            }
        }

        return result
    }
}
