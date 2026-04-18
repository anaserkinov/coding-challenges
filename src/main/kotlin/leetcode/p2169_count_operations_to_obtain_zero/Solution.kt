package leetcode.p2169_count_operations_to_obtain_zero

class Solution {
    fun countOperations(num1: Int, num2: Int): Int {
        if (num1 == 0 || num2 == 0) return 0
        if (num1 == num2) return 1
        var greater = num1
        var less = num2
        if (num2 > num1){
            greater = num2
            less = num1
        }
        var result = 0
        while (less != 0){
            result += greater/less
            val temp = less
            less = greater%less
            greater = temp
        }
        return result
    }
}