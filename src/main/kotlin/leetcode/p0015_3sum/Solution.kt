package leetcode.p0015_3sum

class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        if (nums.size == 3)
            return if (nums.sum() == 0) listOf(nums.toList()) else listOf()

        nums.sort()
        val map = HashMap<Int, Int>()
        nums.forEachIndexed { index, i ->
            map[i] = index
        }

        val result = arrayListOf<List<Int>>()

        var i = 0
        while (i < nums.size - 2){
            if (nums[i] > 0) break

            var j = i + 1
            while (j < nums.size - 1){
                val t = -(nums[i] + nums[j])
                if (map.getOrDefault(t, -1) > j)
                    result.add(listOf(nums[i], nums[j], t))
                j = map[nums[j]]!! + 1
            }

            i = map[nums[i]]!! + 1
        }

        return result
    }
}