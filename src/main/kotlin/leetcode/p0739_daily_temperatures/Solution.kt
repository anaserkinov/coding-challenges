package leetcode.p0739_daily_temperatures

class Solution {
    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val result = IntArray(temperatures.size)
        val stack = ArrayList<Int>()
        temperatures.forEachIndexed { index, i ->
            while (stack.isNotEmpty() && i > temperatures[stack.last()]){
                val removed = stack.removeLast()
                result[removed] = index - removed
            }
            stack.add(index)
        }
        return result
    }
}