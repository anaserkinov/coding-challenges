package leetcode.p0001_two_sum

class Solution {
    fun twoSum_0(nums: IntArray, target: Int): IntArray {
        if (nums.size == 2) return intArrayOf(0, 1)
        nums.forEachIndexed { index, i ->
            for (n in index + 1 until nums.size){
                if (i + nums[n] == target)
                    return intArrayOf(index, n)
            }
        }
        return intArrayOf(0, 1)
    }

    fun twoSum(nums: IntArray, target: Int): IntArray {
        if (nums.size == 2) return intArrayOf(0, 1)

        val map = HashMap<Int, Int>(nums.size - 1)
        nums.forEachIndexed { index, i ->
            val diff = target - i
            if (map.containsKey(diff))
                return intArrayOf(map[diff]!!, index)
            map[i] = index
        }
        return intArrayOf()
    }
}