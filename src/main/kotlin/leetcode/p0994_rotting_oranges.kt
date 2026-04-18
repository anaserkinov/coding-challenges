package leetcode.p0994_rotting_oranges

class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {
        var fresh = 0
        var time = 0
        val queue = ArrayDeque<Pair<Int, Int>>()
        val dirs = arrayOf(
            Pair(0, 1), Pair(0, -1), Pair(1, 0), Pair(-1, 0)
        )
        val height = grid.size
        val width = grid[0].size
        repeat(height){ y ->
            repeat(width) {x ->
                if (grid[y][x] == 1)
                    fresh ++
                else if (grid[y][x] == 2)
                    queue.add(Pair(y, x))
            }
        }

        while (fresh != 0 && queue.isNotEmpty()){
            repeat(queue.size) {
                val rotten = queue.removeFirst()
                dirs.forEach { dir ->
                    val newY = rotten.first + dir.first
                    val newX = rotten.second + dir.second
                    if (newY in 0..<height && newX in 0..<width && grid[newY][newX] == 1){
                        grid[newY][newX] = 2
                        fresh --
                        queue.addLast(Pair(newY, newX))
                    }
                }
            }
            time ++
        }

        return if (fresh == 0) time else -1
    }
}