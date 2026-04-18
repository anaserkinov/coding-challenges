package leetcode.p0039_combination_sum_II

import java.util.Arrays

class Solution {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        val result = ArrayList<List<Int>>()
        val subset = ArrayList<Int>()
        Arrays.sort(candidates)

        fun i(index: Int, sum: Int){
            if (sum == target) {
                result.add(subset.toList())
                return
            }
            if (sum > target) return
            for (j in index until candidates.size){
                val value = candidates[j]
                if (j > index && value == candidates[j - 1]) continue
                subset.add(value)
                i(j + 1, sum + value)
                subset.removeLast()
            }
        }
        i(0, 0)
        return result
    }
}