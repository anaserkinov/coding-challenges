package leetcode.p1339_maximum_produc_of_splitted_binary_tree

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun maxProduct(root: TreeNode?): Int {
        fun sum(tree: TreeNode?): Int{
            if (tree == null) return 0
            return tree.`val` + sum(tree.left) + sum(tree.right)
        }
        val sum = sum(root)
        var max = 0L

        fun findMax(tree: TreeNode?): Int{
            if (tree == null) return 0
            val left = findMax(tree.left)
            val right = findMax(tree.right)
            max = maxOf(
                max,
                maxOf(
                    left * (sum - left).toLong(),
                    right * (sum - right).toLong()
                )
            )
            return tree.`val` + left + right
        }
        findMax(root)

        return (max % 1000000007).toInt()
    }
}