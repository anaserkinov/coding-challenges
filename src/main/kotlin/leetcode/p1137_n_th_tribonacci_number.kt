package leetcode.p1137_n_th_tribonacci_number

class Solution {
    fun tribonacci(n: Int): Int {
        if (n <= 1) return n
        if (n == 2) return 1
        var p0 = 0
        var p1 = 1
        var p2 = 1

        repeat(n-2){
            p1 += p0.also { p0 = p1 }
            p2 += p1.also { p1 = p2 }
        }
        return p2
    }
}