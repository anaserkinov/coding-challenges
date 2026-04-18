package leetcode.p1970_last_day_where_you_can_still_cross

class Solution {
    fun latestDayToCross(row: Int, col: Int, cells: Array<IntArray>): Int {
        val n = row * col
        val bottom = n + 1

        val parent = IntArray(n + 2) { it }
        val rank = IntArray(n + 2)
        val grid = BooleanArray(n)

        fun find(x: Int): Int {
            if (parent[x] != x) parent[x] = find(parent[x])
            return parent[x]
        }

        fun union(a: Int, b: Int) {
            val x = find(a)
            val y = find(b)
            if (x == y) return
            if (rank[x] < rank[y]) {
                parent[x] = y
            } else {
                parent[y] = x
                if (rank[x] == rank[y]) rank[x]++
            }
        }

        val dr = intArrayOf(1, -1, 0, 0)
        val dc = intArrayOf(0, 0, 1, -1)

        for (d in n - 1 downTo 0) {
            val r = cells[d][0] - 1
            val c = cells[d][1] - 1
            val id = r * col + c
            grid[id] = true

            if (r == 0) union(id, n)
            if (r == row - 1) union(id, bottom)

            for (k in 0..3) {
                val nr = r + dr[k]
                val nc = c + dc[k]
                if (nr in 0 until row && nc in 0 until col) {
                    val nid = nr * col + nc
                    if (grid[nid]) union(id, nid)
                }
            }

            if (find(n) == find(bottom)) return d
        }
        return 0
    }
}