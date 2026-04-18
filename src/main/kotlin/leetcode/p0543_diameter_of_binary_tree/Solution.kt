package leetcode.p0543_diameter_of_binary_tree

import kotlin.math.max

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    var res = 0
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        dfs(root)
        return res
    }
    private fun dfs(root: TreeNode?): Int {
        if (root == null) return 0
        val lHeight = dfs(root.left)
        val rHeight = dfs(root.right)
        res = max(res, lHeight + rHeight)
        return 1 + max(lHeight, rHeight)
    }
}