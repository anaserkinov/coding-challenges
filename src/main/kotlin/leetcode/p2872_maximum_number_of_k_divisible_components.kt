package leetcode.p2872_maximum_number_of_k_divisible_components

class Solution {
    fun maxKDivisibleComponents(n: Int, edges: Array<IntArray>, values: IntArray, k: Int): Int {
        val tree = Array(n + 1){ ArrayList<Int>() }.let { array ->
            edges.forEach { edge ->
                array[edge[0]].add(edge[1])
                array[edge[1]].add(edge[0])
            }
            val result = Array<ArrayList<Int>?>(n + 1){ null }
            fun dfs(index: Int, parent: Int){
                val list = ArrayList<Int>()
                result[index] = list
                for (item in array[index]){
                    if (item == parent) continue
                    list.add(item)
                    dfs(item, index)
                }
            }
            dfs(0, -1)
            result
        }

        var count = 0
        fun dfs(index: Int): Int {
            var value = 0
            if (tree[index] != null)
                for (item in tree[index]!!) value += dfs(item)
            if ((value + values[index]) % k == 0) count ++
            return (value + values[index]) % k
        }
        dfs(0)

        return count
    }
}