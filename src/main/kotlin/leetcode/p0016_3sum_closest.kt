package leetcode.p0016_3sum_closest

import kotlin.math.abs

class Solution {
    fun threeSumClosest(nums: IntArray, target: Int): Int {
        nums.sort()
        val size = nums.size
        var result = nums[0] + nums[1] + nums[2]
        var diff = abs(target - result)

        for (i in 0 until size - 2){
            if (i > 0 && nums[i] == nums[i - 1]) continue

            var left = i + 1
            var right = size - 1

            val minSum = nums[i] + nums[left] + nums[left + 1]
            if (minSum >= target)
                return if (minSum - target < diff) minSum else result

            val maxSum = nums[i] + nums[right - 1] + nums[right]
            if (maxSum <= target){
                diff = target - maxSum
                result = maxSum
                continue
            }

            while (left < right){
                val sum = nums[i] + nums[left] + nums[right]
                val _diff = abs(sum - target)
                if (_diff < diff){
                    diff = _diff
                    result = sum
                }
                when {
                    sum < target -> left++
                    sum > target -> right--
                    sum == target -> return sum
                }
            }
        }

        return result
    }
}