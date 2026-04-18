package leetcode.p1854_maximum_population_year

class Solution {
    fun maximumPopulation(logs: Array<IntArray>): Int {
        val linear = IntArray(101)
        logs.forEach {
            linear[it[0] - 1950] ++
            linear[it[1] - 1950] --
        }
        var count = 0
        var max = 0
        var result = 0
        linear.forEachIndexed { index, i ->
            count += i
            if (count > max){
                max = count
                result = index
            }
        }
        return result + 1950
    }
}