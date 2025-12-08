package aoc.y2025.d8

import java.io.File
import kotlin.math.pow
import kotlin.math.sqrt


data class Edge(val a: Int, val b: Int, val dist: Double)

private fun distance(p: List<Double>, q: List<Double>): Double =
    sqrt((p[0] - q[0]).pow(2) + (p[1] - q[1]).pow(2) + (p[2] - q[2]).pow(2))

//72150
fun solution_1(): Long {
    val boxes = File("src/main/kotlin/aoc/y2025/d8/input.txt")
        .readLines()
        .map { it.split(',').map(String::toDouble) }

    val n = boxes.size
    val edges = ArrayList<Edge>()
    for (i in 0 until n - 1)
        for (j in i + 1 until n)
            edges += Edge(i, j, distance(boxes[i], boxes[j]))

    edges.sortBy { it.dist }

    val adj = Array(n) { HashSet<Int>() }

    var added = 0
    for (e in edges) {
        if (e.a !in adj[e.b]) {
            adj[e.a].add(e.b)
            adj[e.b].add(e.a)
            added++
            if (added == 1000) break
        }
    }

    val visited = BooleanArray(n)
    val sizes = ArrayList<Int>()
    for (i in 0 until n) {
        if (!visited[i]) {
            var size = 0
            val q = ArrayDeque<Int>()
            q.add(i)
            visited[i] = true
            while (q.isNotEmpty()) {
                val cur = q.removeFirst()
                size++
                for (nx in adj[cur]) {
                    if (!visited[nx]) {
                        visited[nx] = true
                        q.add(nx)
                    }
                }
            }
            sizes += size
        }
    }

    sizes.sortDescending()
    return sizes[0].toLong() * sizes[1] * sizes[2]
}



//3926518899
private fun solution_2(): Long{
    val boxes = File("src/main/kotlin/aoc/y2025/d8/input.txt")
        .readLines()
        .map { it.split(',').map(String::toDouble) }

    val n = boxes.size
    val edges = ArrayList<Edge>()
    for (i in 0 until n)
        for (j in i + 1 until n)
            edges += Edge(i, j, distance(boxes[i], boxes[j]))

    edges.sortBy { it.dist }

    val adj = Array(n) { HashSet<Int>() }

    fun allConnected(): Boolean {
        val visited = BooleanArray(n)
        val q = ArrayDeque<Int>()
        q.add(0)
        visited[0] = true
        while (q.isNotEmpty()) {
            val cur = q.removeFirst()
            for (nx in adj[cur]) {
                if (!visited[nx]) {
                    visited[nx] = true
                    q.add(nx)
                }
            }
        }
        return visited.all { it }
    }

    var lastEdge: Edge? = null
    for (e in edges) {
        if (e.a !in adj[e.b]) {
            adj[e.a].add(e.b)
            adj[e.b].add(e.a)
            lastEdge = e
            if (allConnected()) break
        }
    }

    return boxes[lastEdge!!.a][0].toLong() * boxes[lastEdge.b][0].toLong()
}