package leetcode.p3318_find_x_sum_of_all_k_long_subarrays_I

import java.util.*
import kotlin.collections.HashSet

class Solution {
    fun findXSum(nums: IntArray, k: Int, x: Int): IntArray {
        val frequency = IntArray(51)
        repeat(k - 1){ frequency[nums[it]] ++ }
        val set = HashSet<Int>(k)

        val queue = PriorityQueue<Int>(x + 1) { p0, p1 ->
            if (frequency[p0] == frequency[p1]) p0 - p1
            else frequency[p0] - frequency[p1]
        }

        val result = IntArray(nums.size - k + 1)

        var left = 0
        var right = k - 1
        while (right < nums.size){
            frequency[nums[right++]] ++
            set.clear()
            repeat(k){ set.add(nums[left + it]) }
            queue.clear()
            set.forEach {
                queue.offer(it)
                if (queue.size == x + 1) queue.poll()
            }
            result[left] = queue.sumOf { frequency[it] * it }
            frequency[nums[left++]] --
        }

        return result
    }
}