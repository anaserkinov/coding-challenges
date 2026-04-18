package leetcode.p0150_evaluate_reverse_polish_notation

class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = ArrayDeque<Int>()
        tokens.forEach {
            if (it.length == 1 && it.first().code < 48){
                val right = stack.removeLast()
                val left = stack.removeLast()
                val r = when(it.first()){
                    '+' -> left + right
                    '-' -> left - right
                    '*' -> left * right
                    else -> left / right
                }
                stack.addLast(r)
            } else {
                stack.addLast(it.toInt())
            }
        }
        return stack.last()
    }
}
