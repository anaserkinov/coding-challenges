package leetcode.p0144_binary_tree_preorder_traversal

import leetcode.p0145_binary_tree_postorder_traversal.TreeNode
import java.util.LinkedList

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun preorderTraversal(root: TreeNode?): List<Int> {
        val result = LinkedList<Int>()
        fun dfs(root: TreeNode?){
            if (root == null) return
            result.add(root.`val`)
            dfs(root.left)
            dfs(root.right)
        }
        dfs(root)
        return result
    }
}