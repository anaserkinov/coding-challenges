package leetcode.p0020_valid_parentheses

class Solution {
    fun isValid(s: String): Boolean {
        if (s.length == 1) return false

        val stack = ArrayDeque<Char>()

        s.forEach { char ->
            if (stack.isNotEmpty() && stack.last().let { char - it == 1 || char - it == 2 })
                stack.removeLast()
            else
                stack.addLast(char)
        }

        return stack.isEmpty()
    }
}