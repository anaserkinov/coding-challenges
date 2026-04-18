package leetcode.p0621_task_scheduler

import java.util.*
import kotlin.collections.ArrayDeque

class Solution {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val count = IntArray(26)
        tasks.forEach { count[it.code - 65]++ }

        val heap = PriorityQueue<Int>(compareBy { it * -1 })
        count.forEach {
            if (it > 0) heap.offer(it)
        }

        var time = 0
        val queue = ArrayDeque<Pair<Int, Int>>()

        while (heap.isNotEmpty()) {
            time++

            val cnt = heap.poll() - 1
            if (cnt != 0)
                queue.addLast(Pair(cnt, time + n))

            if (queue.isNotEmpty() && (heap.isEmpty() || queue.first().second == time)){
                val task = queue.removeFirst()
                time = task.second
                heap.offer(task.first)
            }
        }
        return time
    }
}