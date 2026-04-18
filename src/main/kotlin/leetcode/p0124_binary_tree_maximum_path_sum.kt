package leetcode.p0124_binary_tree_maximum_path_sum

import kotlin.math.max

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    private var result = Int.MIN_VALUE
    fun maxPathSum(root: TreeNode?): Int {
        fun dfs(root: TreeNode?): Int {
            if (root == null) return 0
            val left = max(dfs(root.left), 0)
            val right = max(dfs(root.right), 0)
            result = max(result, root.`val` + left + right)
            return root.`val` + max(left, right)
        }
        dfs(root)
        return result
    }
}