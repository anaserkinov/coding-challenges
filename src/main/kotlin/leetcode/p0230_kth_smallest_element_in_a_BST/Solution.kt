package leetcode.p0230_kth_smallest_element_in_a_BST

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        var count = 0
        fun dfs(root: TreeNode?): Int {
            if (root == null) return -1
            dfs(root.left).let { if (it != -1) return it }
            count ++
            if (count == k) return root.`val`
            dfs(root.right).let { if (it != -1) return it }
            return -1
        }
        return dfs(root)
    }
}