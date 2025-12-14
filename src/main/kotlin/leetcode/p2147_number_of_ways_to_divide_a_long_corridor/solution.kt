package leetcode.p2147_number_of_ways_to_divide_a_long_corridor

class Solution {
    fun numberOfWays(corridor: String): Int {
        var result = 1L
        var seatCount = 0
        var plantCount = 0
        for (s in corridor){
            if (s == 'S'){
                if (seatCount == 2){
                    result = (result * (plantCount + 1)) % 1_000_000_007
                    seatCount = 1
                    plantCount = 0
                } else seatCount ++
            } else if (seatCount == 2) plantCount ++
        }
        return if (seatCount == 2) result.toInt()
        else 0
    }
}