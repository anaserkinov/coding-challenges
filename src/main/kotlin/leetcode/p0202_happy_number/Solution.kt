package leetcode.p0202_happy_number

class Solution {
    fun isHappy(n: Int): Boolean {
        fun next(num: Int) : Int{
            var sum = 0
            var n = num
            while (n > 0){
                val x = n % 10
                sum += x * x
                n /= 10
            }
            return sum
        }
        var left = n
        var right = next(n)
        while (left != right){
            left = next(left)
            right = next(next(right))
        }
        return right == 1
    }
}