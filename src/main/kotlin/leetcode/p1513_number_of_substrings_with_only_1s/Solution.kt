package leetcode.p1513_number_of_substrings_with_only_1s

class Solution {
    fun numSub(s: String): Int {
        var result = 0L
        var count = 0L
        s.forEach {
            if (it == '1') count ++
            else if (count != 0L){
                result += count * (count + 1)/2
                count = 0
            }
        }
        Int.MAX_VALUE
        if (count != 0L) result += count * (count + 1)/2
        return (result % 1000000007).toInt()
    }
}