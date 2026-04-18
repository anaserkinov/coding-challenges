package leetcode.p3583_count_special_triplets

class Solution {
    fun specialTriplets(nums: IntArray): Int {
        val max = nums.max()
        val right = IntArray(max + 1)
        val left = IntArray(max + 1)
        for (n in nums) {
            right[n]++
        }

        var result = 0L
        for (n in nums) {
            right[n]--
            if (n shl 1 <= max && right[n shl 1] != 0) {
                val lc2 = left[n shl 1]
                if (lc2 != 0)
                    result = (result + right[n shl 1] * lc2.toLong()) % 1_000_000_007L
            }
            left[n]++
        }
        return result.toInt()
    }
}