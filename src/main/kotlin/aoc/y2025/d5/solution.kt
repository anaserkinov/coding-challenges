package aoc.y2025.d5

import java.io.File
import kotlin.math.max

//652
private fun solution_1(): Int{
    val ranges = ArrayList<Pair<Long, Long>>()
    var readingRanges = true

    var count = 0
    File("src/main/kotlin/aoc/y2025/d5/input.txt").readLines()
        .forEach {
            if (readingRanges){
                if (it == "") {
                    readingRanges = false
                    return@forEach
                }
                val list = it.split('-')
                ranges.add(Pair(list[0].toLong(), list[1].toLong()))
            } else {
                val id = it.toLong()
                if (ranges.any { id >= it.first && id <= it.second }) count ++
            }
        }

    return count
}

//341753674214273
private fun solution_2(): Long{
    val ranges = ArrayList<Pair<Long, Long>>()
    run {
        File("src/main/kotlin/aoc/y2025/d5/input.txt").readLines()
            .forEach {
                if (it == "") { return@run }
                val list = it.split("-")
                val start = list[0].toLong()
                val end = list[1].toLong()
                ranges.add(Pair(start, end))
            }
    }
    ranges.sortWith(
        compareBy<Pair<Long, Long>> { it.first }
            .thenBy { it.second }
    )

    var count = ranges.first.second - ranges.first.first + 1
    for (i in 1 until ranges.size){
        var start = ranges[i].first
        for (j in 0 until i)
            start = max(ranges[j].second + 1, ranges[i].first)
        if (ranges[i].second >= start) count += ranges[i].second - start + 1
    }

    return count
}