package leetcode.p0332_reconstruct_itinerary

import java.util.*


class Solution {
    fun findItinerary(tickets: List<List<String>>): List<String> {
        val adj = HashMap<String, PriorityQueue<String>>()

        tickets.forEach { (src, dst) ->
            var list = adj[src]
            if (list == null){
                list = PriorityQueue()
                adj[src] = list
            }
            list.add(dst)
        }

        val res = LinkedList<String>()

        fun dfs(src: String) {
            val queue = adj[src]
            while (!queue.isNullOrEmpty()){
                dfs(queue.poll())
            }
            res.addFirst(src)
        }
        dfs("JFK")

        return res
    }
}