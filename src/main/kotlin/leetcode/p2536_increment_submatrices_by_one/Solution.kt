package leetcode.p2536_increment_submatrices_by_one

class Solution {
    fun rangeAddQueries(n: Int, queries: Array<IntArray>): Array<IntArray> {
        val result = Array(n) { IntArray(n) }
        queries.forEach {
            result[it[0]][it[1]] += 1
            if (it[3] != n - 1)
                result[it[0]][it[3] + 1] -= 1
            if (it[3] != n - 1 && it[2] != n - 1)
                result[it[2] + 1][it[3] + 1] += 1
            if (it[2] != n - 1)
                result[it[2] + 1][it[1]] -= 1
        }
        for (i in 0 until n){
            for (j in 1 until n){
                result[i][j] = result[i][j] + result[i][j - 1]
            }
        }
        for (i in 0 until n){
            for (j in 1 until n){
                result[j][i] = result[j][i] + result[j - 1][i]
            }
        }
        return result
    }
}