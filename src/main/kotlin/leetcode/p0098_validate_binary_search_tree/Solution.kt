package leetcode.p0098_validate_binary_search_tree

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    private fun check(root: TreeNode?, left: Long, right: Long): Boolean {
        if (root == null) return true
        if (root.`val` >= left || root.`val` <= right) return false
        return check(root.left, root.`val`.toLong(), right) && check(root.right, left, root.`val`.toLong())
    }
    fun isValidBST(root: TreeNode?): Boolean {
        if (root == null) return true
        return check(root, Long.MAX_VALUE, Long.MIN_VALUE)
    }
}