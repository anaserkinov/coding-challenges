package leetcode.p0207_course_schedule

class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val visited = ArrayList<Int>()
        val array = arrayOfNulls<ArrayList<Int>?>(numCourses)
        prerequisites.forEach {
            var list = array[it[0]]
            if (list == null) {
                list = ArrayList()
                array[it[0]] = list
            }
            list.add(it[1])
        }
        fun dfs(index: Int): Boolean{
            val value = array[index] ?: return true
            if (value === visited) return false
            array[index] = visited
            value.forEach {
                if (!dfs(it)) return false
            }
            array[index] = null
            return true
        }
        repeat(numCourses){
            if (!dfs(it)) return false
        }
        return true
    }
}