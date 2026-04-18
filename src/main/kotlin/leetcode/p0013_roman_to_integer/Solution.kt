package leetcode.p0013_roman_to_integer

class Solution {
    fun romanToInt(s: String): Int {
        var lastNumber = 0
        fun fun1(n: Int): Int{
            var result = 0
            if (lastNumber == n) result += n
            else if (n != 1 && lastNumber == n/10){
                result += n - n/10
                lastNumber = 0
            } else {
                result += lastNumber
                lastNumber = n
            }
            return result
        }
        fun fun5(n: Int): Int{
            var result = n
            if (lastNumber == n/5)
                result -= result/5
            else
                result += lastNumber
            lastNumber = 0
            return result
        }
        var result = 0
        for (c in s){
            result += when(c){
                'I' -> fun1(1)
                'V' -> fun5(5)
                'X' -> fun1(10)
                'L' -> fun5(50)
                'C' -> fun1(100)
                'D' -> fun5(500)
                else -> fun1(1000)
            }
        }
        return result + lastNumber
    }
}