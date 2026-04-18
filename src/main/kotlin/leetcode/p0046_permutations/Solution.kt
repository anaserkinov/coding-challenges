package leetcode.p0046_permutations

class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        val result = ArrayList<List<Int>>()
        val subset = ArrayList<Int>()
        val state = BooleanArray(nums.size)

        fun backtrack(){
            if (subset.size == nums.size) {
                result.add(subset.toList())
                return
            }
            for (j in nums.indices){
                if (state[j]) continue
                subset.add(nums[j])
                state[j] = true
                backtrack()
                subset.removeLast()
                state[j] = false
            }
        }

        backtrack()

        return result
    }
}