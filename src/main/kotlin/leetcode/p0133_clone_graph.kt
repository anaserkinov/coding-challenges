package leetcode.p0133_clone_graph

class Node(var `val`: Int) {
    var neighbors: ArrayList<Node?> = ArrayList()
}

class Solution {
    fun cloneGraph(node: Node?): Node? {
        val array = Array<Node?>(101) { null }
        fun dfs(node: Node?): Node?{
            if (node == null) return null
            var copy = array[node.`val`]
            if (copy != null) return copy
            copy = Node(node.`val`)
            array[node.`val`] = copy
            node.neighbors.forEach {
                copy.neighbors.add(dfs(it))
            }
            return copy
        }
        return dfs(node)
    }
}