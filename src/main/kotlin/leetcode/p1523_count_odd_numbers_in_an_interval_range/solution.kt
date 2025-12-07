package leetcode.p1523_count_odd_numbers_in_an_interval_range

class Solution {
    fun countOdds(low: Int, high: Int): Int {
        return ((high + high % 2) - (low - low  % 2))/2
    }
}