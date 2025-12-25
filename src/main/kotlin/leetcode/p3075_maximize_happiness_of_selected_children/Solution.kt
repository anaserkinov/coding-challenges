package leetcode.p3075_maximize_happiness_of_selected_children

import kotlin.math.max

class Solution {
    fun maximumHappinessSum(happiness: IntArray, k: Int): Long {
        happiness.sortDescending()
        var max = 0L
        for (i in 0 until k){
            max += max(0, happiness[i] - i)
        }
        return max
    }
}