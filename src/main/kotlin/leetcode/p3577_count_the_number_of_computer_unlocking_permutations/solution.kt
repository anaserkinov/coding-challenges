package leetcode.p3577_count_the_number_of_computer_unlocking_permutations

class Solution {
    fun countPermutations(complexity: IntArray): Int {
        var result = 1L
        for (i in 1..complexity.size - 1) {
            if (complexity[0] >= complexity[i]) return 0
            result = (result * i) % 1_000_000_007L
        }
        return result.toInt()
    }
}