package leetcode.p0112_path_sum

import leetcode.p0113_path_sum_II.TreeNode

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        if (root == null) return false
        if (root.left == null && root.right == null) return root.`val` == targetSum
        return hasPathSum(root.left, targetSum - root.`val`) ||
                hasPathSum(root.right, targetSum - root.`val`)
    }
}