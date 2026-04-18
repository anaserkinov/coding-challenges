package leetcode.p0102_binary_tree_level_order_traversal

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        val result = ArrayList<ArrayList<Int>>()
        levelOrder(result, root, 0)
        return result
    }
    private fun levelOrder(lists: ArrayList<ArrayList<Int>>, root: TreeNode?, level: Int){
        if (root == null) return
        var list = lists.getOrNull(level)
        if (list == null){
            list = ArrayList()
            lists.add(level, list)
        }
        list.add(root.`val`)
        levelOrder(lists, root.left, level + 1)
        levelOrder(lists, root.right, level + 1)
    }
}