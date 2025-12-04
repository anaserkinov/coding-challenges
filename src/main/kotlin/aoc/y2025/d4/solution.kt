package aoc.y2025.d4

import java.io.File

//1460
private fun solution_1(): Int{
    val grid = File("src/main/kotlin/aoc/y2025/d4/input.txt").readLines()
        .map { it.map { if (it == '.') 0 else 1 } }
    fun checkNeighbours(x: Int, y: Int) = (if (x != 0 && grid[y][x- 1] == 1) 1 else 0) +
            (if (x != grid[0].size - 1 && grid[y][x + 1] == 1) 1 else 0)
    fun countAdj(x: Int, y: Int): Int {
        var count = checkNeighbours(x, y)
        if (y != 0){
            if (grid[y - 1][x] == 1) count++
            count += checkNeighbours(x, y - 1)
        }
        if (y != grid.size - 1){
            if (grid[y + 1][x] == 1) count++
            count += checkNeighbours(x, y + 1)
        }
        return count
    }
    var count = 0
    for (y in 0 until grid.size){
        for (x in 0 until grid[0].size){
            if (grid[y][x] == 0) continue
            if (countAdj(x, y) < 4) count ++
        }
    }
    return count
}

//9243
private fun solution_2(): Int{
    val grid = File("src/main/kotlin/aoc/y2025/d4/input.txt").readLines()
        .map { it.map { if (it == '.') 0 else 1 } as ArrayList }
    fun checkNeighbours(x: Int, y: Int) = (if (x != 0 && grid[y][x- 1] == 1) 1 else 0) +
            (if (x != grid[0].size - 1 && grid[y][x + 1] == 1) 1 else 0)
    fun countAdj(x: Int, y: Int): Int {
        var count = checkNeighbours(x, y)
        if (y != 0){
            if (grid[y - 1][x] == 1) count++
            count += checkNeighbours(x, y - 1)
        }
        if (y != grid.size - 1){
            if (grid[y + 1][x] == 1) count++
            count += checkNeighbours(x, y + 1)
        }
        return count
    }
    var count = 0
    while (true){
        var removed = 0
        for (y in 0 until grid.size){
            for (x in 0 until grid[0].size){
                if (grid[y][x] == 0) continue
                if (countAdj(x, y) < 4) {
                    grid[y][x] = 0
                    removed ++
                }
            }
        }
        count += removed
        if (removed == 0) break
    }
    return count
}