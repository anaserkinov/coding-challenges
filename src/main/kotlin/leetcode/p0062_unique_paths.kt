package leetcode.p0062_unique_paths

class Solution {
    fun uniquePaths(m: Int, n: Int): Int {
        val mm = IntArray(m * n)
        fun s(y: Int, x: Int): Int {
            if (y == m || x == n) return 0
            if (y == m - 1 && x == n - 1) return 1
            if (mm[y * n + x] != 0) return mm[y * n + x]
            val r =  s(y + 1, x) + s(y, x + 1)
            mm[y * n + x] = r
            return r
        }
        return s(0, 0)
    }
}