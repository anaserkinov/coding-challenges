package leetcode.p0226_invert_binary_tree

import leetcode.p0104_maximum_depth_of_binary_tree.TreeNode

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return null
        root.left = root.right.also {
            root.right = root.left
        }
        invertTree(root.left)
        invertTree(root.right)
        return root
    }
}