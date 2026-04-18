package leetcode.p0078_subsets

class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        if (nums.isEmpty()) return emptyList()
        val result = ArrayList<List<Int>>()
        val subset = ArrayList<Int>()
        fun i(index: Int){
            if (index >= nums.size) {
                result.add(subset.toList())
                return
            }
            subset.add(nums[index])
            i(index + 1)
            subset.removeLast()
            i(index + 1)
        }
        i(0)
        return result
    }
}