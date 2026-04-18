package leetcode.p2900_longest_unequal_adjacent_groups_subsequence_I

import java.util.LinkedList

class Solution {
    fun getLongestSubsequence(words: Array<String>, groups: IntArray): List<String> {
        var choose = groups[0]
        val result = LinkedList<String>()
        groups.forEachIndexed { index, i ->
            if (i == choose){
                result.add(words[index])
                choose = choose xor 1
            }
        }
        return result
    }
}