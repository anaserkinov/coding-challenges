package aoc.y2025.d2

import java.io.File
import java.math.BigDecimal
import kotlin.math.abs
import kotlin.math.pow

//13919717792
private fun solution_1(): BigDecimal{
    var sum = BigDecimal(0.0)

    fun isRepeatedTwice(s: String): Boolean {
        val len = s.length
        if (len % 2 != 0) return false

        val half = len / 2
        val first = s.substring(0, half)
        val second = s.substring(half)

        return first == second
    }

    File("src/main/kotlin/aoc/y2025/d2/input.txt").readText()
        .split(',')
        .forEach {
            it.split('-').let {
                for (i in it[0].toLong()..it[1].toLong()){
                    if (isRepeatedTwice(i.toString()))
                        sum += i.toBigDecimal()
                }
            }
        }

    return sum
}

//14582313461
private fun solution_2(): BigDecimal{
    var sum = BigDecimal(0.0)

    fun isRepeatedSequence(s: String): Boolean {
        val len = s.length
        for (sub in 1..len / 2) {
            if (len % sub != 0) continue
            val times = len / sub
            if (times < 2) continue

            val piece = s.substring(0, sub)
            if (piece.repeat(times) == s) return true
        }
        return false
    }

    File("src/main/kotlin/aoc/y2025/d2/input.txt").readText()
        .split(',')
        .forEach {
            it.split('-').let {
                for (i in it[0].toLong()..it[1].toLong()){
                    if (isRepeatedSequence(i.toString()))
                        sum += i.toBigDecimal()
                }
            }
        }

    return sum
}