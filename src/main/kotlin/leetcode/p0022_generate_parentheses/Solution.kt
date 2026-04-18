package leetcode.p0022_generate_parentheses

class Solution {
    fun generateParenthesis(n: Int): List<String> {
        val result = ArrayList<String>()
        val builder = StringBuilder()

        fun add(
            char: Char,
            open:Int,
            close: Int,
            limit: Int
        ) {
            builder.append(char)
            if (open == close && open == limit)
                result.add(builder.toString())
            else {
                if (open != limit)
                    add('(', open + 1, close, limit)
                if (close != limit && close + 1 <= open)
                    add(')', open, close + 1, limit)
            }
            builder.deleteCharAt(builder.length - 1)
        }

        add('(', 1, 0, n)
        return result
    }
}