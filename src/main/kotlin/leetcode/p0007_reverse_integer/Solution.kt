package leetcode.p0007_reverse_integer

class Solution {
    fun reverse(x: Int): Int {
        var result = 0
        var x = x
        while (x != 0){
            if (result > Int.MAX_VALUE/10 || result < Int.MIN_VALUE/10) return 0
            result = result * 10 + x%10
            x /= 10
        }
        return result
    }
}