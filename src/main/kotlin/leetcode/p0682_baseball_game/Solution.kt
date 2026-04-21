package leetcode.p0682_baseball_game

class Solution {
    fun calPoints(operations: Array<String>): Int {
        val queue = ArrayDeque<Int>()
        var result = 0
        for (operation in operations) {
            when(operation[0]){
                '+' -> (queue[queue.lastIndex] + queue[queue.lastIndex - 1]).let {
                    queue.addLast(it)
                    result += it
                }
                'D' -> (queue[queue.lastIndex] * 2).let {
                    queue.addLast(it)
                    result += it
                }
                'C' -> result -= queue.removeLast()
                else -> operation.toInt().let {
                    queue.addLast(it)
                    result += it
                }
            }
        }
        return result
    }
}