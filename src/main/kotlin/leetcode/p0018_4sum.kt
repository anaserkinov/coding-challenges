package leetcode.p0018_4sum

class Solution {
    fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        val n = nums.size
        nums.sort()

        for (i in 0 until n - 3) {  // the 1st
            if (i > 0 && nums[i] == nums[i - 1]) continue   //skip the same
            // i-level pruning
            val minI = nums[i].toLong() + nums[i + 1] + nums[i + 2] + nums[i + 3]
            if (minI > target) break
            val maxI = nums[i].toLong() + nums[n - 1] + nums[n - 2] + nums[n - 3]
            if (maxI < target) continue

            for (j in i + 1 until n - 2) {  // the 2nd
                if (j > i + 1 && nums[j] == nums[j - 1]) continue   // skip the same
                // j-level pruning
                val minJ = nums[i].toLong() + nums[j] + nums[j + 1] + nums[j + 2]
                if (minJ > target) break
                val maxJ = nums[i].toLong() + nums[j] + nums[n - 1] + nums[n - 2]
                if (maxJ < target) continue

                var l = j + 1   // 2rd
                var r = n - 1
                val need = target.toLong() - nums[i] - nums[j]
                while (l < r) {
                    val s = nums[l].toLong() + nums[r]
                    when {
                        s == need -> {
                            res.add(listOf(nums[i], nums[j], nums[l], nums[r]))
                            val lv = nums[l]; val rv = nums[r]
                            while (l < r && nums[l] == lv) l++
                            while (l < r && nums[r] == rv) r--
                        }
                        s < need -> l++
                        else -> r--
                    }
                }
            }
        }
        return res
    }

}
