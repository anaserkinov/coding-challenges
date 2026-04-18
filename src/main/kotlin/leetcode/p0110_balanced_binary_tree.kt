package leetcode.p0110_balanced_binary_tree

import kotlin.math.abs
import kotlin.math.max

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun isBalanced(root: TreeNode?): Boolean {
        if (root == null) return true
        return depth(root) != -1
    }
    private fun depth(root: TreeNode?): Int {
        if (root == null) return 0
        val left = depth(root.left).also {
            if (it == -1) return -1
        }
        val right = depth(root.right).also {
            if (it == -1) return -1
        }
        if (abs(left - right) > 1) return -1
        return 1 + max(left, right)
    }
}