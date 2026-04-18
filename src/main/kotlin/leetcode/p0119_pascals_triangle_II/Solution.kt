package leetcode.p0119_pascals_triangle_II

class Solution {

    fun getRow(rowIndex: Int): List<Int> {
        val row = MutableList(rowIndex + 1) { 0 }
        row[0] = 1

        for (i in 1..rowIndex) {
            for (j in i downTo 1) {
                row[j] += row[j - 1]
            }
        }

        return row
    }

    //stolen solution, O(n) time/space
    fun getRow1(rowIndex: Int): List<Int> {
        val res = ArrayList<Int>(rowIndex + 1)
        res[0] = 1
        var prev = 1
        for (i in 1..rowIndex) {
            prev = prev * (rowIndex - i + 1) / i
            res[i] = prev
        }
        return res
    }
}