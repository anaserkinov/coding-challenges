package leetcode.p0853_car_fleet

class Solution {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        val cars = position.zip(speed).sortedByDescending { it.first }
        val stack = ArrayList<Pair<Int, Int>>()
        cars.forEach {
            if (stack.isNotEmpty()){
                val last = stack.last()
                if ((target - it.first).toFloat()/it.second > (target - last.first).toFloat()/last.second)
                    stack.add(it)
            } else
                stack.add(it)
        }
        return stack.size
    }
}