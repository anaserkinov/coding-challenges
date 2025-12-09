package aoc.y2025.d9

import java.io.File
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min

//4761736832
fun solution_1(): Long {
    val reds = File("src/main/kotlin/aoc/y2025/d9/input.txt")
        .readLines()
        .map { it.split(',').map(String::toLong) }
    var max: Long = 0
    for (i in 0 until reds.size - 1){
        for (j in i + 1 until reds.size){
            val ax = reds[i][0]
            val ay = reds[i][1]
            val bx = reds[j][0]
            val by = reds[j][1]
            if (ax == bx || ay == by) continue
            val w = abs(ax - bx) + 1
            val h = abs(ay - by) + 1
            val area = h * w
            if (area > max) max = area
        }
    }
    return max
}


data class Point(val x: Int, val y: Int)

//1452422268
private fun solution_2(): Int {
    val reds = File("src/main/kotlin/aoc/y2025/d9/input.txt")
        .readLines()
        .map { it.split(',').let { Point(it[0].toInt(), it[1].toInt()) } }

    val n = reds.size
    val edges = ArrayList<Pair<Point, Point>>(n)
    for (i in 0 until n) {
        val a = reds[i]
        val b = reds[(i + 1) % n]
        edges.add(a to b)
    }

    fun inPolygon(px: Int, py: Int): Boolean {
        var inside = false
        for ((a, b) in edges) {
            val x1 = a.x
            val y1 = a.y
            val x2 = b.x
            val y2 = b.y

            val intersect = (y1 > py) != (y2 > py) &&
                    px < (x2 - x1) * (py - y1) / (y2 - y1) + x1
            if (intersect) inside = !inside
        }
        return inside
    }

    fun edgeIntersectsRect(a: Point, b: Point, xmin: Int, xmax: Int, ymin: Int, ymax: Int): Boolean {
        if (a.y == b.y) {
            val y = a.y
            if (y > ymin && y < ymax) {
                val x1 = min(a.x, b.x)
                val x2 = max(a.x, b.x)
                if (x2 > xmin && x1 < xmax) return true
            }
        } else if (a.x == b.x) { // vertical edge
            val x = a.x
            if (x > xmin && x < xmax) {
                val y1 = min(a.y, b.y)
                val y2 = max(a.y, b.y)
                if (y2 > ymin && y1 < ymax) return true
            }
        }
        return false
    }

    var max = 0

    for (i in 0 until n) {
        for (j in i + 1 until n) {
            val p = reds[i]
            val q = reds[j]

            val xmin = min(p.x, q.x)
            val xmax = max(p.x, q.x)
            val ymin = min(p.y, q.y)
            val ymax = max(p.y, q.y)

            var invalid = false
            for ((a, b) in edges) {
                if (edgeIntersectsRect(a, b, xmin, xmax, ymin, ymax)) {
                    invalid = true
                    break
                }
            }
            if (invalid) continue

            if (!inPolygon(xmin, ymin)) continue

            val area = (xmax - xmin + 1) * (ymax - ymin + 1)
            if (area > max) max = area
        }
    }

    return max
}