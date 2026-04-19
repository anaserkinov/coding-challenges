package leetcode.p0881_boats_to_save_people

class Solution {
    fun numRescueBoats(people: IntArray, limit: Int): Int {
        val count = IntArray(people.max() + 1)
        for (w in people) {
            count[w] ++
        }
        var w = 1
        var i = 0
        while (i < people.size) {
            while (count[w] == 0){ w ++ }
            people[i ++] = w
            count[w] --
        }

        var left = 0
        var right = people.size - 1
        var res = 0
        while (left <= right) {
            res ++
            if (people[right] + people[left] <= limit)
                left ++
            right --
        }
        return res
    }
}