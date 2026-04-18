package leetcode.p1448_count_good_nodes_in_binary_tree

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun goodNodes(root: TreeNode?): Int {
        var count = 0
        fun dfs(root: TreeNode?, maxValue: Int){
            if (root == null) return
            var maxValue = maxValue
            if (root.`val` >= maxValue){
                count ++
                maxValue = root.`val`
            }
            dfs(root.left, maxValue)
            dfs(root.right, maxValue)
        }
        dfs(root, root!!.`val`)
        return count
    }
}