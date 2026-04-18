package leetcode.p0131_palindrome_partitioning

class Solution {

    private fun isPalindrome(s: String, l: Int, r: Int): Boolean {
        var left = l
        var right = r
        while (left < right) {
            if (s[left] != s[right]) return false
            left++
            right--
        }
        return true
    }

    fun partition(s: String): List<List<String>> {
        if (s.length == 1) return listOf(listOf(s))
        val result = ArrayList<List<String>>()
        val parts = ArrayList<String>()

        fun i(j: Int, i: Int){
            if (i >= s.length) {
                if (i == j) result.add(parts.toList())
                return
            }

            if (isPalindrome(s, j, i)) {
                parts.add(s.substring(j, i + 1))
                i(i + 1, i + 1)
                parts.removeAt(parts.size - 1)
            }

            i(j, i + 1)
        }
        i(0, 0)
        return result
    }
}