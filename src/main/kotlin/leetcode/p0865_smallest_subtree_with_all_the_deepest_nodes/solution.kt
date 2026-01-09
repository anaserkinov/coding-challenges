package leetcode.p0865_smallest_subtree_with_all_the_deepest_nodes

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun subtreeWithAllDeepest(root: TreeNode): TreeNode {
        fun dfs(node: TreeNode?, depth: Int): Pair<Int, TreeNode>? {
            if (node == null) return null
            return if ( node.left == null && node.right == null)
                Pair(depth, node)
            else {
                val left = dfs(node.left, depth + 1)
                val right = dfs(node.right, depth + 1)
                if (left != null && right != null){
                    if (left.first == right.first) Pair(left.first, node)
                    else if (left.first > right.first) left else right
                } else left ?: right
            }
        }

        return dfs(root, 0)!!.second
    }
}