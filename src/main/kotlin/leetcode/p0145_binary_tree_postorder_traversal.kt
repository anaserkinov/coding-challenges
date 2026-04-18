package leetcode.p0145_binary_tree_postorder_traversal

import java.util.LinkedList

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun postorderTraversal(root: TreeNode?): List<Int> {
        val result = LinkedList<Int>()
        fun dfs(root: TreeNode?){
            if (root == null) return
            dfs(root.left)
            dfs(root.right)
            result.add(root.`val`)
        }
        dfs(root)
        return result
    }
}