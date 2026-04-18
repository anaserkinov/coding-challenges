package leetcode.p1411_number_of_ways_to_paint_n_3_grid

class Solution {
    fun numOfWays(n: Int): Int {
        val mod = 1000_000_007L
        var type1 = 6L
        var type2 = 6L
        repeat(n - 1) {
            val type11 = (type1 * 2)%mod
            val type21 = (type2 * 2)%mod
            val type1Next = (type11 + type21)%mod

            val type12 = (type1 * 2)%mod
            val type22 = (type2 * 3)%mod
            val type2Next = (type12 + type22)%mod

            type1 = type1Next
            type2 = type2Next
        }
        return ((type1 + type2)%mod).toInt()
    }
}