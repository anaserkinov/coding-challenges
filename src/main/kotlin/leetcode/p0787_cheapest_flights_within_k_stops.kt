package leetcode.p0787_cheapest_flights_within_k_stops

import java.util.ArrayList
import java.util.LinkedList

class Solution {
    fun findCheapestPrice(n: Int, flights: Array<IntArray>, src: Int, dst: Int, k: Int): Int  {
        val prices = IntArray(n) { Int.MAX_VALUE }
        prices[src] = 0

        val adj = arrayOfNulls<ArrayList<IntArray>?>(n)
        flights.forEach {
            var list = adj[it[0]]
            if (list == null){
                list = ArrayList()
                adj[it[0]] = list
            }
            list.add(it)
        }

        val queue = LinkedList<Triple<Int, Int, Int>>()
        queue.offer(Triple(src, 0, 0))

        while (queue.isNotEmpty()){
            val t = queue.poll()
            if (t.third > k) continue
            adj[t.first]?.forEach {
                val newCost = t.second + it[2]
                if (newCost < prices[it[1]]){
                    prices[it[1]] = newCost
                    queue.offer(Triple(it[1], newCost, t.third + 1))
                }
            }
        }

        return if (prices[dst] == Int.MAX_VALUE) -1 else prices[dst]
    }
}