package aoc.y2025.d1

import java.io.File
import kotlin.math.abs

//1172
private fun solution_1(): Int{
    var current = 50
    var result = 0

    File("src/main/kotlin/aoc/y2025/d1/input.txt").readLines()
        .map {
            it.substring(1).toInt() * if (it.first() == 'R') 1 else -1
        }.forEach {
            current += it
            current %= 100
            if (current < 0) current += 100
            if (current == 0) result++
        }

    return result
}

//6932
private fun solution_2(): Int{
    var current = 50
    var result = 0

    File("src/main/kotlin/aoc/y2025/d1/input.txt").readLines()
        .map {
            it.substring(1).toInt() * if (it.first() == 'R') 1 else -1
        }.forEach {
            current += it
            val count = current/100
            result += abs(count)
            current -= count * 100
            if (current < 0){
                if (current != it%100) result ++
                current += 100
            }
            if (current == 0 && (count == 0 || it < 0)) result ++
        }

    return result
}