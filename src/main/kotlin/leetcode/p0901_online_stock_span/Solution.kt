package leetcode.p0901_online_stock_span

class StockSpanner() {

    private val stack = ArrayDeque<Pair<Int, Int>>()

    fun next(price: Int): Int {
        var span = 1
        while (stack.isNotEmpty() && stack.last().first <= price) {
            span += stack.removeLast().second
        }
        stack.addLast(Pair(price, span))
        return span
    }

}
