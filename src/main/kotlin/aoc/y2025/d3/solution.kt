package aoc.y2025.d3

import java.io.File
import java.math.BigDecimal
import kotlin.math.max

//16842
private fun solution_1(): Int{
    var sum = 0
    fun max(start: Int, end: Int, list: List<Int>): Int{
        var max = start
        for (i in start..end){
            if (list[i] > list[max]) max = i
        }
        return max
    }
    File("src/main/kotlin/aoc/y2025/d3/input.txt").readLines()
        .forEach { line ->
            val list = line.map { it.digitToInt() }
            val leftCharIndex = max(0, list.size - 2, list)
            var total = list[leftCharIndex]
            total = total * 10 + list[max(
                leftCharIndex + 1,
                list.size - 1,
                list
            )]
            sum += total
        }

    return sum
}

//167523425665348
private fun solution_2(): Long{
    var sum = 0L
    fun max(start: Int, end: Int, list: List<Int>): Int{
        var max = start
        for (i in start..end){
            if (list[i] > list[max]) max = i
        }
        return max
    }
    File("src/main/kotlin/aoc/y2025/d3/input.txt").readLines()
        .forEach { line ->
            var total = 0L
            val list = line.map { it.digitToInt() }
            var left = 0
            var right = list.size - 12
            repeat(12){
                val maxIndex = max(left, right, list)
                total = total * 10 + list[maxIndex]
                left = maxIndex + 1
                right = max(list.size - left - 12, right + 1)
            }
            sum += total
        }

    return sum
}