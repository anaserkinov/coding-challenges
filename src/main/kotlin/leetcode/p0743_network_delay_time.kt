package leetcode.p0743_network_delay_time

import java.util.*
import kotlin.collections.ArrayList


class Solution {
    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {
        val emptyList = ArrayList<IntArray>(0)
        val graph = Array<ArrayList<IntArray>?>(n + 1){ null }
        val heap = PriorityQueue<Pair<Int, Int>>( compareBy { it.first } )
        var maxTime = 0
        var visited = 0

        for (time in times) {
            var list = graph[time[0]]
            if (list == null){
                list = ArrayList()
                graph[time[0]] = list
            }
            list.add(time)
        }

        heap.add(Pair(0, k))

        while (heap.isNotEmpty()) {
            val (currentTime, node) = heap.poll()

            if (graph[node] === emptyList) continue
            visited ++

            maxTime = maxOf(maxTime, currentTime)

            graph[node]?.forEach {
                if (graph[it[1]] !== emptyList)
                    heap.add(Pair(currentTime + it[2], it[1]))
            }
            graph[node] = emptyList
        }

        return if (visited >= n) maxTime else -1
    }
}