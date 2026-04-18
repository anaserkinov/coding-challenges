package leetcode.p0756_pyramid_transition_matrix

class Solution {
    fun pyramidTransition(bottom: String, allowed: List<String>): Boolean {
        val allowedMap = Array(6){ Array(6){ ArrayList<Int>(6) } }
        for (s in allowed) allowedMap[s[0].code - 65][s[1].code - 65].add(s[2].code - 65)
        val row = ArrayList<Int>(bottom.length * 2)
        for (i in bottom.indices){ row.add(bottom[i].code - 65) }
        fun f(index: Int, length: Int): Boolean{
            if (length == 1) return true
            val left = row.removeAt(0)
            val right = if (index == length - 2) row.removeAt(0) else row[0]
            for (top in allowedMap[left][right]){
                row.add(top)
                if (index == length - 2){
                    if (f(0, row.size)) return true
                } else if (f(index + 1, length)) return true
                row.removeLast()
            }
            if (index == length - 2) row.add(0, right)
            row.add(0, left)
            return false
        }
        return f(0, row.size)
    }
}