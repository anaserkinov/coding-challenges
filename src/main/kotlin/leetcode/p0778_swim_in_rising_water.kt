package leetcode.p0778_swim_in_rising_water

import java.util.*

class Solution {
    fun swimInWater(grid: Array<IntArray>): Int {
        if (grid.size == 1) return 0
        val size = grid.size
        val directions = arrayOf(Pair(0, 1), Pair(0, -1), Pair(1, 0), Pair(-1, 0))

        val minHeap = PriorityQueue(compareBy<Pair<Int, Int>> { it.first })
        minHeap.add(Pair(grid[0][0], 0))

        val visited = IntArray(size*size)
        visited[0] = 1

        while (minHeap.isNotEmpty()) {
            val (time, pos) = minHeap.poll()
            val y = pos/size
            val x = pos - y * size

            if (y == size - 1 && x == size - 1) return time

            for ((dx, dy) in directions) {
                val newX = x + dx
                val newY = y + dy
                val index = newY * size + newX

                if (newX in 0 until size &&
                    newY in 0 until size &&
                    visited[index] == 0) {
                    visited[index] = 1
                    minHeap.offer(Pair(maxOf(time, grid[newY][newX]), index))
                }
            }
        }

        return -1
    }
}