package leetcode.p3607_power_grid_maintenance

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

class Solution {
    fun processQueries(c: Int, connections: Array<IntArray>, queries: Array<IntArray>): IntArray {
        val powerGrids = Array<PriorityQueue<Int>?>(c + 1) { null }
        Array<ArrayList<Int>?>(c + 1){ null }.also{ array ->
            connections.forEach { cn ->
               (array[cn[0]] ?: ArrayList<Int>().also { array[cn[0]] = it })
                    .add(cn[1])
                (array[cn[1]] ?: ArrayList<Int>().also { array[cn[1]] = it })
                    .add(cn[0])
            }
            fun fill(id: Int, queue: PriorityQueue<Int>){
                if (powerGrids[id] != null) return
                powerGrids[id] = queue
                array[id]?.forEach {
                    queue.add(it)
                    fill(it, queue)
                }
            }
            repeat(c){ id ->
                val queue = powerGrids[id + 1] ?: PriorityQueue<Int>()
                queue.add(id + 1)
                fill(id + 1, queue)
            }
        }
        val result = ArrayList<Int>()
        val offline = HashSet<Int>()
        queries.forEach { q ->
            if (q[0] == 2) offline.add(q[1])
            else {
                if (!offline.contains(q[1])) result.add(q[1])
                else {
                    val queue = powerGrids[q[1]]!!
                    while (queue.isNotEmpty()){
                        if (offline.contains(queue.peek()))
                            queue.poll()
                        else {
                            result.add(queue.peek())
                            break
                        }
                    }
                    if (queue.isEmpty()) result.add(-1)
                }
            }
        }
        return result.toIntArray()
    }
}