package leetcode.p0757_set_intersection_size_at_least_two

class Solution {
    fun intersectionSizeTwo(intervals: Array<IntArray>): Int {
        intervals.sortWith { a, b ->
            val previousCompare = a[1].compareTo(b[1])
            if (previousCompare != 0) previousCompare else b[0].compareTo(a[0])
        }
        val nums = ArrayList<Int>()
        intervals.forEach {
            var count = 0
            var index = nums.size - 1
            while (index >= 0){
                val num = nums[index--]
                if (num < it[0]) break
                if (num <= it[1]) count ++
            }
            if (count == 0)
                nums.add(it[1] - 1)
            if (count < 2)
                nums.add(it[1])
        }
        return nums.size
    }
}