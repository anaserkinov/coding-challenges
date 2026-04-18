package leetcode.p0039_combination_sum

class Solution {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val result = ArrayList<List<Int>>()
        val subset = ArrayList<Int>()

        fun i(index: Int, sum: Int){
            if (sum == target) {
                result.add(subset.toList())
                return
            }
            if (sum > target) return
            for (j in index until candidates.size){
                val value = candidates[j]
                subset.add(value)
                i(j, sum + value)
                subset.removeLast()
            }
        }

        i(0, 0)

        return result
    }
}