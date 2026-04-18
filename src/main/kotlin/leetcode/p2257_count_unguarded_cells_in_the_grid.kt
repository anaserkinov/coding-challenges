package leetcode.p2257_count_unguarded_cells_in_the_grid

class Solution {
    fun countUnguarded(m: Int, n: Int, guards: Array<IntArray>, walls: Array<IntArray>): Int {
        var result = m * n
        val prison = Array(m) { IntArray(n) }
        walls.forEach {
            result --
            prison[it[0]][it[1]] = 0b100
        }

        var flag = 0
        fun watch(y: Int, x: Int, offsetY: Int, offsetX: Int) {
            val _y = y + offsetY
            val _x = x + offsetX
            if (_y in 0 until m && _x in 0 until n) {
                val value = prison[_y][_x]
                if (value >= 0b11) return
                if (value and flag == 0){
                    if (value == 0) result --
                    prison[_y][_x] = value or flag
                    watch(_y, _x, offsetY, offsetX)
                }
            }
        }
        guards.forEach {
            val value = prison[it[0]][it[1]]
            if (value == 0) result --
            if (value and 0b1 == 0){
                flag = 0b1
                watch(it[0], it[1], -1, 0)
                watch(it[0], it[1], 1, 0)
            }
            if (value and 0b10 == 0){
                flag = 0b10
                watch(it[0], it[1], 0, 1)
                watch(it[0], it[1], 0, -1)
            }
            prison[it[0]][it[1]] = 0b11
        }

        return result
    }
}