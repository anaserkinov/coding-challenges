package leetcode.p0101_symmetric_tree

import leetcode.p0113_path_sum_II.TreeNode

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun isSymmetric(root: TreeNode?): Boolean {
        fun isSymmetric(left: TreeNode?, right: TreeNode?): Boolean {
            if (left?.`val` != right?.`val`) return false
            return left == null ||
                    isSymmetric(left.left, right!!.right) &&
                    isSymmetric(left.right, right.left)
        }
        return isSymmetric(root!!.left, root.right)
    }
}