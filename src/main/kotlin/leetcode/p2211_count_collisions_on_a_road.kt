package leetcode.p2211_count_collisions_on_a_road

class Solution {
    fun countCollisions(directions: String): Int {
        var start = 0
        var end = directions.length - 1
        while (start < directions.length && directions[start] == 'L') start ++
        while (end >= 0 && directions[end] == 'R') end --
        var result = 0
        for (i in start..end){
            if (directions[i] != 'S') result ++
        }
        return result
    }
}