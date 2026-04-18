package leetcode.p0104_maximum_depth_of_binary_tree

import kotlin.math.max


class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0
        return 1 + max(
            maxDepth(root.left),
            maxDepth(root.right)
        )
    }
}