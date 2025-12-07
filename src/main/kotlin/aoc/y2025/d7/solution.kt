package aoc.y2025.d7

import java.io.File
import kotlin.math.max
import kotlin.math.min

//1535
private fun solution_1(): Int{
    val lines = File("src/main/kotlin/aoc/y2025/d7/input.txt").readLines()
    var total = 0
    val b = ArrayList<Int>()
    b.add(lines[0].length/2)
    for (i in 2 until lines.size){
        val newB = HashSet<Int>(b)
        val line = lines[i].mapIndexed { index, c -> Pair(index, c) }.associateBy { it.first }
        b.forEach { index ->
            line[index]?.let {
                if (it.second == '^'){
                    newB.remove(index)
                    newB.add(max(0, index - 1))
                    newB.add(min(index + 1, lines[0].length - 1))
                    total ++
                }
            }
        }
        b.clear()
        b.addAll(newB)
    }

    return total
}

//4404709551015
private fun solution_2(): Long{
    val lines = File("src/main/kotlin/aoc/y2025/d7/input.txt").readLines()
    val dp = Array(lines.size){ LongArray(lines[0].length){ -1 } }

    fun dfs(lineIndex: Int, bIndex: Int): Long{
        if (lineIndex == lines.size)
            return 1
        if (dp[lineIndex][bIndex] != -1L) return dp[lineIndex][bIndex]
        val line = lines[lineIndex]
        var total = 0L
        if (line[bIndex] == '^'){
            if (bIndex != 0) total += dfs(lineIndex + 1, bIndex - 1)
            if (bIndex != lines[0].length - 1) total += dfs(lineIndex + 1, bIndex + 1)
        } else
            total += dfs(lineIndex + 1, bIndex)
        dp[lineIndex][bIndex] = total
        return total
    }
    return dfs(2, lines[0].length/2)
}