package leetcode.p0199_binary_tree_right_side_view

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        val result = ArrayList<Int>()
        fun dfs(root: TreeNode?, level: Int){
            if (root == null) return
            if (result.size == level)
                result.add(root.`val`)
            else
                result[level] = root.`val`
            dfs(root.left, level + 1)
            dfs(root.right, level + 1)
        }
        dfs(root, 0)
        return result
    }
}