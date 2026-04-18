package leetcode.p0210_course_schedule_II

class Solution {

    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val visited = ArrayList<Int>()
        val array = Array<ArrayList<Int>?>(numCourses) { ArrayList() }
        val result = IntArray(numCourses)
        prerequisites.forEach { array[it[0]]!!.add(it[1]) }
        var i = 0
        fun dfs(index: Int): Boolean{
            val value = array[index] ?: return true
            if (value === visited) return false
            array[index] = visited
            value.forEach {
                if (!dfs(it)) return false
            }
            array[index] = null
            result[i++] = index
            return true
        }
        repeat(numCourses){
            if (!dfs(it)) return intArrayOf()
        }
        return result
    }
}
