package leetcode.p0763_partition_labels

import kotlin.math.max

class Solution {
    fun partitionLabels(s: String): List<Int> {
        val pos = IntArray(26)
        s.forEachIndexed { index, c -> pos[c.code - 97] = index }
        val result = ArrayList<Int>()
        var size = 0
        var end = 0
        s.forEachIndexed { index, c ->
            size ++
            end = max(end, pos[c.code - 97])
            if (index == end){
                result.add(size)
                size =0
            }
        }
        return result
    }
}