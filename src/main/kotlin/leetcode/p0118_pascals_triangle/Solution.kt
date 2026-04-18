package leetcode.p0118_pascals_triangle

class Solution {
    fun generate(numRows: Int): List<List<Int>> {
        val result = ArrayList<List<Int>>(numRows)
        var list = emptyList<Int>()
        while (true){
            val l = ArrayList<Int>(list.size + 1)
            result.add(l)
            var index = -1
            while (index < list.size){
                l.add(
                    if (index == -1 || index == list.size - 1) 1
                    else list[index] + list[index + 1]
                )
                index++
            }
            if (result.size == numRows) return result
            list = l
        }
    }
}