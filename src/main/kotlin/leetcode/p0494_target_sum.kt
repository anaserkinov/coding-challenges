package leetcode.p0494_target_sum

class Solution {
    fun findTargetSumWays(nums: IntArray, target: Int): Int {
        val m = IntArray((nums.size + 1) * 2000){ -1 }
        fun s(index: Int, target: Int): Int{
            if (index == nums.size){
                return if (target == 0) 1 else 0
            }
            val i = index * 2000 + (target + 1000)
            m[i].let { if (it != -1) return it }
            val result = s(index + 1, target + nums[index]) +
                    s(index + 1, target - nums[index])
            m[i] = result
            return result
        }
        return s(0, target)
    }
}