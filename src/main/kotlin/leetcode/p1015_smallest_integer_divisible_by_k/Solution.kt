package leetcode.p1015_smallest_integer_divisible_by_k

class Solution {
    fun smallestRepunitDivByK(k: Int): Int {
        if (k % 2 == 0 || k % 5 == 0) return -1
        var rem = 0
        var count = 0
        while (true){
            val r = (rem * 10 + 1) % k
            if (r == 0) return count + 1
            if (r == rem) return -1
            rem = r
            count++
        }
    }
}