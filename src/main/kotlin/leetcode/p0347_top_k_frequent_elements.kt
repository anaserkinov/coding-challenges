package leetcode.p0347_top_k_frequent_elements

import kotlin.math.min

class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        if (nums.size == 1) return nums

        val bucket = Array(nums.size + 1){
            ArrayList<Int>(min(10, nums.size/2))
        }
        HashMap<Int, Int>().let { map ->
            nums.forEach { map[it] = (map[it] ?: 0) + 1 }

            map.keys.forEach {
                val value = map[it]!!
                bucket[value].add(it)
            }
        }

        val result = IntArray(k)
        var index = 0
        for (i in nums.size downTo 0){
            if (bucket[i].size != 0)
                bucket[i].forEach {
                    result[index++] = it
                    if (index == k)
                        return result
                }
        }
        return result
    }
}