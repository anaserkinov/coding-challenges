package leetcode.p3562_maximum_profit_from_trading_stocks_with_discounts


class Solution {
    fun maxProfit(n: Int, present: IntArray, future: IntArray, hierarchy: Array<IntArray>, budget: Int): Int {
        val NEG = Int.MIN_VALUE
        val graph = Array(n) { mutableListOf<Int>() }
        for ((start, end) in hierarchy) graph[start - 1].add(end - 1)

        fun merge(a: IntArray, b: IntArray): IntArray {
            val c = IntArray(a.size) { NEG }
            for (i in a.indices) {
                if (a[i] == NEG) continue
                for (j in i..b.lastIndex) {
                    if (b[j - i] == NEG) continue
                    c[j] = maxOf(c[j], a[i] + b[j - i])
                }
            }
            return c
        }

        fun dfs(index: Int): Pair<IntArray, IntArray> {
            val subTree = graph[index].map(::dfs)
            fun solve(isParentBought: Boolean): IntArray {
                var dont = IntArray(budget + 1) { NEG }
                dont[0] = 0
                dont = subTree.map { it.first }.fold(dont, ::merge)
                val cost = if (isParentBought) present[index] / 2 else present[index]
                if (cost > budget) return dont
                val profit = future[index] - cost
                var buy = IntArray(budget + 1) { NEG }
                buy[cost] = profit
                buy = subTree.map { it.second }.fold(buy, ::merge)
                return IntArray(budget + 1) { maxOf(dont[it], buy[it]) }
            }
            return solve(false) to solve(true)
        }
        return dfs(0).first.max()
    }
}