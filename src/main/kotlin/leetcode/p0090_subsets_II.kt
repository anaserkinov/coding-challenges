package leetcode.p0090_subsets_II

class Solution {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        if (nums.isEmpty()) return emptyList()
        nums.sort()
        val result = ArrayList<List<Int>>()
        val subset = ArrayList<Int>()
        fun backtrack(index: Int){
            if (index >= nums.size) {
                result.add(subset.toList())
                return
            }
            subset.add(nums[index])
            backtrack(index + 1)
            subset.removeLast()
            var j = index
            while (j + 1 < nums.size && nums[j] == nums[j + 1]) j++
            backtrack(j + 1)
        }
        backtrack(0)
        return result
    }
}