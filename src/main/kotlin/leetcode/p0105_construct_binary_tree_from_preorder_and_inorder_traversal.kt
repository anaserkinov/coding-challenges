package leetcode.p0105_construct_binary_tree_from_preorder_and_inorder_traversal

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        val map = inorder.withIndex().associate { (index, value) -> value to index }
        var index = 0
        fun build(from: Int, to: Int): TreeNode? {
            if (from > to) return null
            val node = TreeNode(preorder[index++])
            val mid = map[node.`val`]!!
            node.left = build(from, mid - 1)
            node.right = build(mid + 1, to)
            return node
        }
        return build(0, preorder.size - 1)
    }
}