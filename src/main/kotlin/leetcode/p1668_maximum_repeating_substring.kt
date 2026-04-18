package leetcode.p1668_maximum_repeating_substring

class Solution {
    fun maxRepeating(sequence: String, word: String): Int {
        if (word.length > sequence.length) return 0
        var k = sequence.length/word.length
        val dp = IntArray(100) { -1 }

        while (k > 0){
            var index = 0
            var count = 0
            var sqIndex = 0
            while (sqIndex < sequence.length){
                if (sequence[sqIndex++] == word[index]){
                    if (++index == word.length){
                        index = 0
                        if (++count == k) return k
                        dp[sqIndex - count * word.length] = count
                    }
                } else {
                    sqIndex -= count * word.length + index
                    count = 0
                    if (dp[sqIndex] != -1){
                        count = dp[sqIndex]
                        sqIndex += count * word.length
                        if (count == k) return k
                    }
                    index = 0
                }
            }
            k --
        }
        return 0
    }
}