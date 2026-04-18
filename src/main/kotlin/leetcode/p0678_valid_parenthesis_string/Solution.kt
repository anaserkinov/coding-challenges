package leetcode.p0678_valid_parenthesis_string

class Solution {
    fun checkValidString(s: String): Boolean {
        val lefts = ArrayList<Int>(s.length)
        val stars = ArrayList<Int>(s.length)
        s.forEachIndexed { index, c ->
            if (c == '(') lefts.add(index)
            else if (c == '*') stars.add(index)
            else {
                if (lefts.isNotEmpty()) lefts.removeLast()
                else if (stars.isNotEmpty()) stars.removeLast()
                else return false
            }
        }
        repeat(lefts.size){
            if (stars.isEmpty()) return false
            if (lefts.removeLast() > stars.removeLast()) return false
        }
        return true
    }
}