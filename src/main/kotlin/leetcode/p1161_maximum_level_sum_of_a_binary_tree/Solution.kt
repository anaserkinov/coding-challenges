package leetcode.p1161_maximum_level_sum_of_a_binary_tree

import java.util.LinkedList
import java.util.Queue


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun maxLevelSum(root: TreeNode): Int {
        var level = 1
        var max = Int.MIN_VALUE
        var result = 1
        val queue: Queue<TreeNode> = LinkedList()
        queue.add(root)
        while (queue.isNotEmpty()){
            val size = queue.size
            var sum = 0
            for (i in 0 until size){
                val node = queue.poll()
                node.left?.let { queue.add(it) }
                node.right?.let { queue.add(it) }
                sum += node.`val`
            }
            if (sum > max){
                max = sum
                result = level
            }
            level++
        }
        return result
    }
}