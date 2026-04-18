package leetcode.p0108_convert_sorted_array_to_binary_search_tree

import leetcode.p0113_path_sum_II.TreeNode

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        fun build(left: Int, right: Int): TreeNode? {
            if (left > right) return null
            val mid = (right + left)/2
            val node = TreeNode(nums[mid])
            node.left = build(left, mid - 1)
            node.right = build(mid + 1, right)
            return node
        }
        return build(0, nums.size - 1)
    }
}