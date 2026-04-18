package leetcode.p0072_edit_distance

import kotlin.math.min

class Solution {
    fun minDistance(word1: String, word2: String): Int {
        val m = Array(word1.length){ IntArray(word2.length){ -1 } }
        fun search(index1: Int, index2: Int): Int {
            if (index1 == word1.length || index2 == word2.length)
                return word1.length - index1 + word2.length - index2
            m[index1][index2].let { if (it != -1) return it }
            val result = if (word1[index1] == word2[index2])
                search(index1 + 1, index2 + 1)
            else {
                1 + min(
                    min(
                        search(index1, index2 + 1), // insert
                        search(index1 + 1, index2 + 1) // replace
                    ),
                    search(index1 + 1, index2) // delete
                )
            }
            m[index1][index2] = result
            return result
        }
        return search(0, 0)
    }
}