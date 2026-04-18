package leetcode.p1046_last_stone_weight

import java.util.PriorityQueue
import kotlin.math.abs

class Solution {
    fun lastStoneWeight(stones: IntArray): Int {
        val heap = PriorityQueue<Int>()
        stones.forEach { heap.add(-it) }
        while (heap.size > 1){
            val stone1 = heap.poll()
            val stone2 = heap.poll()
            if (stone1 != stone2)
                heap.add(stone1 - stone2)
        }
        heap.add(0)
        return abs(heap.peek())
    }
}