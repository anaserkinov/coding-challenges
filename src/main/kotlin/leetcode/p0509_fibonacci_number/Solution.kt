package leetcode.p0509_fibonacci_number

class Solution {
    fun fib(n: Int): Int {
        if (n <= 1) return n
        var pre = 0
        var result = 1
        for (i in 2..n){
            result += pre.also { pre = result }
        }
        return result

//        return round(((sqrt(5.0) + 1) / 2).pow(n)/sqrt(5.0)).toInt()
    }
}