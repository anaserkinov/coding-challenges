package leetcode.p0113_path_sum_II

import java.util.LinkedList

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
        val result = LinkedList<List<Int>>()
        val list = LinkedList<Int>()
        fun sum(root: TreeNode?, targetSum: Int){
            if (root == null) return
            list.addLast(root.`val`)
            if (root.left == null && root.right == null) {
                if (root.`val` == targetSum) result.add(list.toList())
            } else {
                sum(root.left, targetSum - root.`val`)
                sum(root.right, targetSum - root.`val`)
            }
            list.removeLast()
        }
        sum(root, targetSum)
        return result
    }
}